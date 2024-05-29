import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class QLSVGUIBai5 {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;trustServerCertificate=true";
    private static Connection con = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    String username = "sa";
    String password = "123456789";

    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JPanel sinhVienPanel, lopPanel;
    private JTable sinhVienTable, lopTable;
    private DefaultTableModel sinhVienModel, lopModel;
    private JTextField maSVField, hoTenField, lopField, diemTBField, diemTBFieldMin, diemTBFieldMax, searchField;
    private JButton addSVButton, updateSVButton, deleteSVButton, searchButton;
    private JComboBox<String> searchComboBox;

    private JTextField maLopField, tenLopField, cvhtField;
    private JButton addLopButton, updateLopButton, deleteLopButton;

    private JRadioButton ascendingRadioButton, descendingRadioButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QLSVGUIBai5 gui = new QLSVGUIBai5();
            gui.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Quản Lý Sinh Viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tabbedPane = new JTabbedPane();
        sinhVienPanel = new JPanel(new BorderLayout());
        lopPanel = new JPanel(new BorderLayout());

        sinhVienModel = new DefaultTableModel();
        sinhVienTable = new JTable(sinhVienModel);
        lopModel = new DefaultTableModel();
        lopTable = new JTable(lopModel);

        sinhVienPanel.add(new JScrollPane(sinhVienTable), BorderLayout.CENTER);
        lopPanel.add(new JScrollPane(lopTable), BorderLayout.CENTER);

        JPanel sinhVienInputPanel = new JPanel(new GridLayout(6, 2));
        maSVField = new JTextField();
        hoTenField = new JTextField();
        lopField = new JTextField();
        diemTBField = new JTextField();
        addSVButton = new JButton("Thêm");
        updateSVButton = new JButton("Sửa");
        deleteSVButton = new JButton("Xóa");

        sinhVienInputPanel.add(new JLabel("Mã SV:"));
        sinhVienInputPanel.add(maSVField);
        sinhVienInputPanel.add(new JLabel("Họ Tên:"));
        sinhVienInputPanel.add(hoTenField);
        sinhVienInputPanel.add(new JLabel("Lớp:"));
        sinhVienInputPanel.add(lopField);
        sinhVienInputPanel.add(new JLabel("Điểm TB:"));
        sinhVienInputPanel.add(diemTBField);
        sinhVienInputPanel.add(addSVButton);
        sinhVienInputPanel.add(updateSVButton);
        sinhVienInputPanel.add(deleteSVButton);

        // Add search panel
        JPanel searchPanel = new JPanel(new GridLayout(3, 2));
        searchComboBox = new JComboBox<>(new String[] { "Mã SV", "Họ tên", "Lớp", "Điểm TB" });
        searchField = new JTextField();
        diemTBFieldMin = new JTextField();
        diemTBFieldMax = new JTextField();
        searchButton = new JButton("Tìm");

        searchPanel.add(new JLabel("Tìm kiếm theo:"));
        searchPanel.add(searchComboBox);
        searchPanel.add(new JLabel("Giá trị tìm kiếm:"));
        searchPanel.add(searchField);
        searchPanel.add(new JLabel("Điểm TB từ:"));
        searchPanel.add(diemTBFieldMin);
        searchPanel.add(new JLabel("Đến:"));
        searchPanel.add(diemTBFieldMax);
        searchPanel.add(new JLabel(""));
        searchPanel.add(searchButton);

        sinhVienPanel.add(sinhVienInputPanel, BorderLayout.NORTH);
        sinhVienPanel.add(searchPanel, BorderLayout.SOUTH);

        JPanel lopInputPanel = new JPanel(new GridLayout(4, 2));
        maLopField = new JTextField();
        tenLopField = new JTextField();
        cvhtField = new JTextField();
        addLopButton = new JButton("Thêm");
        updateLopButton = new JButton("Sửa");
        deleteLopButton = new JButton("Xóa");

        lopInputPanel.add(new JLabel("Mã Lớp:"));
        lopInputPanel.add(maLopField);
        lopInputPanel.add(new JLabel("Tên Lớp:"));
        lopInputPanel.add(tenLopField);
        lopInputPanel.add(new JLabel("Cố Vấn Học Tập:"));
        lopInputPanel.add(cvhtField);
        lopInputPanel.add(addLopButton);
        lopInputPanel.add(updateLopButton);
        lopInputPanel.add(deleteLopButton);

        lopPanel.add(lopInputPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Sinh Viên", sinhVienPanel);
        tabbedPane.addTab("Lớp", lopPanel);

        frame.add(tabbedPane);
        frame.setVisible(true);

        // add new research
        ascendingRadioButton = new JRadioButton("Tăng dần");
        descendingRadioButton = new JRadioButton("Giảm dần");

        ButtonGroup group = new ButtonGroup();
        group.add(ascendingRadioButton);
        group.add(descendingRadioButton);

        JPanel sortingPanel = new JPanel(new GridLayout(1, 2));
        sortingPanel.add(ascendingRadioButton);
        sortingPanel.add(descendingRadioButton);

        // ascendingRadioButton.addActionListener(e -> loadSinhVienData());
        // descendingRadioButton.addActionListener(e -> loadSinhVienData());

        sinhVienPanel.add(sortingPanel, BorderLayout.NORTH);

        // Load data
        loadData();

        // Add listeners
        addSVButton.addActionListener(e -> addSinhVien());
        updateSVButton.addActionListener(e -> updateSinhVien());
        deleteSVButton.addActionListener(e -> deleteSinhVien());

        addLopButton.addActionListener(e -> addLop());
        updateLopButton.addActionListener(e -> updateLop());
        deleteLopButton.addActionListener(e -> deleteLop());

        searchComboBox.addActionListener(e -> updateSearchFields());
        searchButton.addActionListener(e -> searchSinhVien());

        ascendingRadioButton.addActionListener(e -> loadSinhVienData());
        descendingRadioButton.addActionListener(e -> loadSinhVienData());

    }

    private void loadData() {
        loadSinhVienData();
        loadLopData();
    }

    private void loadSinhVienData() {
        try {
            con = DriverManager.getConnection(DB_URL, username, password);
            statement = con.createStatement();

            String sortingOrder;
            if (ascendingRadioButton.isSelected()) {
                sortingOrder = "ASC";
            } else {
                sortingOrder = "DESC";
            }

            String query = "SELECT * FROM SinhVien ORDER BY DiemTB " + sortingOrder;

            resultSet = statement.executeQuery(query);

            sinhVienModel.setRowCount(0);
            sinhVienModel.setColumnCount(0);
            sinhVienModel = resultSetToTableModel(resultSet);
            sinhVienTable.setModel(sinhVienModel);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void loadLopData() {
        try {
            con = DriverManager.getConnection(DB_URL, username, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Lop");

            lopModel.setRowCount(0);
            lopModel.setColumnCount(0);
            lopModel = resultSetToTableModel(resultSet);
            lopTable.setModel(lopModel);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void addSinhVien() {
        try {
            con = DriverManager.getConnection(DB_URL, username, password);
            String query = "INSERT INTO SinhVien (MaSV, HoTen, Lop, DiemTB) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(maSVField.getText()));
            ps.setString(2, hoTenField.getText());
            ps.setString(3, lopField.getText());
            ps.setFloat(4, Float.parseFloat(diemTBField.getText()));
            ps.executeUpdate();

            loadSinhVienData();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void updateSinhVien() {
        try {
            con = DriverManager.getConnection(DB_URL, username, password);
            String query = "UPDATE SinhVien SET HoTen = ?, Lop = ?, DiemTB = ? WHERE MaSV = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, hoTenField.getText());
            ps.setString(2, lopField.getText());
            ps.setFloat(3, Float.parseFloat(diemTBField.getText()));
            ps.setInt(4, Integer.parseInt(maSVField.getText()));
            ps.executeUpdate();

            loadSinhVienData();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void deleteSinhVien() {
        try {
            con = DriverManager.getConnection(DB_URL, username, password);
            String query = "DELETE FROM SinhVien WHERE MaSV = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(maSVField.getText()));
            ps.executeUpdate();

            loadSinhVienData();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void addLop() {
        try {
            con = DriverManager.getConnection(DB_URL, username, password);
            String query = "INSERT INTO Lop (MaLop, TenLop, CVHT) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maLopField.getText());
            ps.setString(2, tenLopField.getText());
            ps.setString(3, cvhtField.getText());
            ps.executeUpdate();

            loadLopData();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void updateLop() {
        try {
            con = DriverManager.getConnection(DB_URL, username, password);
            String query = "UPDATE Lop SET TenLop = ?, CVHT = ? WHERE MaLop = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, tenLopField.getText());
            ps.setString(2, cvhtField.getText());
            ps.setString(3, maLopField.getText());
            ps.executeUpdate();

            loadLopData();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void deleteLop() {
        try {
            con = DriverManager.getConnection(DB_URL, username, password);
            String query = "DELETE FROM Lop WHERE MaLop = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maLopField.getText());
            ps.executeUpdate();

            loadLopData();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void searchSinhVien() {
        try {
            con = DriverManager.getConnection(DB_URL, username, password);
            String selectedItem = (String) searchComboBox.getSelectedItem();
            String query;
            PreparedStatement ps;

            switch (selectedItem) {
                case "Mã SV":
                    if (searchField.getText().isEmpty()) {
                        // Hiển thị thông báo lỗi hoặc yêu cầu người dùng nhập dữ liệu
                        return;
                    }
                    query = "SELECT * FROM SinhVien WHERE MaSV = ?";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, Integer.parseInt(searchField.getText()));
                    break;
                case "Họ tên":
                    if (searchField.getText().isEmpty()) {
                        // Hiển thị thông báo lỗi hoặc yêu cầu người dùng nhập dữ liệu
                        return;
                    }
                    query = "SELECT * FROM SinhVien WHERE HoTen LIKE ?";
                    ps = con.prepareStatement(query);
                    ps.setString(1, "%" + searchField.getText() + "%");
                    break;
                case "Lớp":
                    if (searchField.getText().isEmpty()) {
                        // Hiển thị thông báo lỗi hoặc yêu cầu người dùng nhập dữ liệu
                        return;
                    }
                    query = "SELECT * FROM SinhVien WHERE Lop = ?";
                    ps = con.prepareStatement(query);
                    ps.setString(1, searchField.getText());
                    break;
                case "Điểm TB":
                    if (diemTBFieldMin.getText().isEmpty() || diemTBFieldMax.getText().isEmpty()) {
                        // Hiển thị thông báo lỗi hoặc yêu cầu người dùng nhập dữ liệu
                        return;
                    }
                    query = "SELECT * FROM SinhVien WHERE DiemTB BETWEEN ? AND ?";
                    ps = con.prepareStatement(query);
                    ps.setFloat(1, Float.parseFloat(diemTBFieldMin.getText()));
                    ps.setFloat(2, Float.parseFloat(diemTBFieldMax.getText()));
                    break;
                default:
                    return;
            }

            ResultSet rs = ps.executeQuery();
            sinhVienModel.setRowCount(0); // Clear previous data
            while (rs.next()) {
                Object[] rowData = { rs.getInt("MaSV"), rs.getString("HoTen"), rs.getString("Lop"),
                        rs.getFloat("DiemTB") };
                sinhVienModel.addRow(rowData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void updateSearchFields() {
        String selectedItem = (String) searchComboBox.getSelectedItem();
        switch (selectedItem) {
            case "Mã SV":
                searchField.setVisible(true);
                diemTBFieldMin.setVisible(false);
                diemTBFieldMax.setVisible(false);
                break;
            case "Họ tên":
            case "Lớp":
                searchField.setVisible(true);
                diemTBFieldMin.setVisible(false);
                diemTBFieldMax.setVisible(false);
                break;
            case "Điểm TB":
                searchField.setVisible(false);
                diemTBFieldMin.setVisible(true);
                diemTBFieldMax.setVisible(true);
                break;
            default:
                break;
        }
    }

    private DefaultTableModel resultSetToTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }

    private void closeResources() {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
