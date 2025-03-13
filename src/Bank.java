import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Bank {
    private Connection connection;

    public Bank() {
        try {
        	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "AdityaChauhan");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        try {
            String query = "INSERT INTO bank_accounts (account_number, account_holder_name, balance) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, accountNumber);
            stmt.setString(2, accountHolderName);
            stmt.setDouble(3, initialBalance);
            stmt.executeUpdate();
            System.out.println("Account created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BankAccount searchAccount(String accountNumber) {
        try {
            String query = "SELECT * FROM bank_accounts WHERE account_number = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new BankAccount(rs.getString("account_number"), rs.getString("account_holder_name"), rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void displayAllAccounts() {
        try {
            String query = "SELECT * FROM bank_accounts";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Account Number: " + rs.getString("account_number"));
                System.out.println("Account Holder Name: " + rs.getString("account_holder_name"));
                System.out.println("Balance: " + rs.getDouble("balance"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(String accountNumber) {
        try {
            String query = "DELETE FROM bank_accounts WHERE account_number = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, accountNumber);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Account deleted successfully!");
            } else {
                System.out.println("Account not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee(String employeeId, String name, String position) {
        try {
            String query = "INSERT INTO bank_employees (employee_id, name, position) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, employeeId);
            stmt.setString(2, name);
            stmt.setString(3, position);
            stmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BankEmployee searchEmployee(String employeeId) {
        try {
            String query = "SELECT * FROM bank_employees WHERE employee_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new BankEmployee(rs.getString("employee_id"), rs.getString("name"), rs.getString("position"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void displayAllEmployees() {
        try {
            String query = "SELECT * FROM bank_employees";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Employee Id: " + rs.getString("employee_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Position: " + rs.getString("position"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(String employeeId) {
        try {
            String query = "DELETE FROM bank_employees WHERE employee_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, employeeId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addInterestToAllAccounts(double interestRate) {
        try {
            String query = "UPDATE bank_accounts SET balance = balance + (balance * ? / 100)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setDouble(1, interestRate);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

