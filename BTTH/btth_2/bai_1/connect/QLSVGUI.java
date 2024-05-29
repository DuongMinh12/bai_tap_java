import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class QLSVGUI {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;integratedSecurity=true;integratedSecurity=true;";
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
    private JTextField maSVField, hoTenField, lopField, diemTBField, maLopField, tenLopField, cvhtField;
    private JButton addSVButton, updateSVButton, deleteSVButton, addLopButton, updateLopButton, deleteLopButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QLSVGUI gui = new QLSVGUI();
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

        JPanel sinhVienInputPanel = new JPanel(new GridLayout(5, 2));
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

        sinhVienPanel.add(sinhVienInputPanel, BorderLayout.SOUTH);

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

        // Load data
        loadData();

        // Add listeners
        addSVButton.addActionListener(e -> addSinhVien());
        updateSVButton.addActionListener(e -> updateSinhVien());
        deleteSVButton.addActionListener(e -> deleteSinhVien());

        addLopButton.addActionListener(e -> addLop());
        updateLopButton.addActionListener(e -> updateLop());
        deleteLopButton.addActionListener(e -> deleteLop());
    }

    private void loadData() {
        loadSinhVienData();
        loadLopData();
    }

    private void loadSinhVienData() {
        try {
            con = DriverManager.getConnection(DB_URL, username, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SinhVien");

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
