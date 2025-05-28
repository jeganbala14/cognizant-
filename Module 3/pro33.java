import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class pro33 {
    private static final String URL = "jdbc:mysql://localhost:3306/Bank";
    private static final String USER = "Dharshini";
    private static final String PASSWORD = "Dharshini@1234";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
             PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {

            conn.setAutoCommit(false);  


            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccountId);
            int debitRows = debitStmt.executeUpdate();


            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccountId);
            int creditRows = creditStmt.executeUpdate();

            if (debitRows == 1 && creditRows == 1) {
                conn.commit();
                System.out.println("Transfer successful.");
            } else {
                conn.rollback();
                System.out.println("Transfer failed, transaction rolled back.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        dao.transferMoney(101, 102, 500.0);
    }
}
