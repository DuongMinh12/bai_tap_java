import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class StudentDatabase {

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;trustServerCertificate=true";
        String username = "sa";
        String password = "123456789";
        return DriverManager.getConnection(url, username, password);
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Quan ly sinh vien");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        JTable table = new JTable();
        table.setModel(new DefaultTableModel(new Object[] { "MaSV", "HoTen", "Lop", "DiemTB" }, 0));

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SinhVien");
            ResultSetMetaData metaData = rs.getMetaData();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            Vector<String> columnNames = new Vector<>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            model.setColumnIdentifiers(columnNames);

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row.add(rs.getObject(columnIndex));
                }
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(StudentDatabase::createAndShowGUI);
    }
}