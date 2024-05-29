import javax.swing.*;
import java.sql.*;
import java.util.Vector;

public class DatabaseTablesList {

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;trustServerCertificate=true";
        String username = "sa";
        String password = "123456789";
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try (Connection conn = getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet tables = metaData.getTables(null, null, "%", new String[] { "TABLE" });

            Vector<Vector<String>> tableData = new Vector<>();
            while (tables.next()) {
                Vector<String> rowData = new Vector<>();
                rowData.add(tables.getString("TABLE_CAT"));
                rowData.add(tables.getString("TABLE_SCHEM"));
                rowData.add(tables.getString("TABLE_NAME"));
                rowData.add(tables.getString("TABLE_TYPE"));
                tableData.add(rowData);
            }

            Vector<String> columnNames = new Vector<>();
            columnNames.add("Database");
            columnNames.add("Schema");
            columnNames.add("Table Name");
            columnNames.add("Type");

            JTable tableList = new JTable(tableData, columnNames);
            JOptionPane.showMessageDialog(null, new JScrollPane(tableList), "Database Tables",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
