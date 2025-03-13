import java.util.Scanner;

class BankManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        while (true) {
            System.out.println("=======================================");
            System.out.println("Welcome to the Bank Management System!");
            System.out.println("1. Customer Login");
            System.out.println("2. Employee Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit the System");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Customer Login");
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    BankAccount account = bank.searchAccount(accountNumber);
                    if (account != null) {
                        System.out.println("Login successful!");
                        customerOperations(bank, scanner, account);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 2:
                    System.out.println("Employee Login");
                    System.out.print("Enter employee id: ");
                    String employeeId = scanner.next();
                    BankEmployee employee = bank.searchEmployee(employeeId);
                    if (employee != null) {
                        System.out.println("Login successful!");
                        employeeOperations(bank, scanner, employee);
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                case 3:
                    System.out.println("Admin Login");
                    adminOperations(bank, scanner);
                    break;
                case 4:
                    System.out.println("Thank You for visiting our Bank");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    private static void customerOperations(Bank bank, Scanner scanner, BankAccount account) {
        while (true) {
            System.out.println("Customer Operations");
            System.out.println("1. Deposit Amount");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Check Balance");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Balance: " + account.getBalance());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void employeeOperations(Bank bank, Scanner scanner, BankEmployee employee) {
        while (true) {
            System.out.println("Employee Operations");
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bank.createAccount(accountNumber, accountHolderName, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    bank.deleteAccount(accountNumber);
                    break;
                case 3:
                    bank.displayAllAccounts();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void adminOperations(Bank bank, Scanner scanner) {
        while (true) {
            System.out.println("Admin Operations");
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Add Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Delete Employee");
            System.out.println("7. Add Interest to All Accounts");
            System.out.println("8. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bank.createAccount(accountNumber, accountHolderName, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    bank.deleteAccount(accountNumber);
                    break;
                case 3:
                    bank.displayAllAccounts();
                    break;
                case 4:
                    System.out.print("Enter employee id: ");
                    String employeeId = scanner.next();
                    System.out.print("Enter employee name: ");
                    String employeeName = scanner.next();
                    System.out.print("Enter employee position: ");
                    String employeePosition = scanner.next();
                    bank.addEmployee(employeeId, employeeName, employeePosition);
                    break;
                case 5:
                    bank.displayAllEmployees();
                    break;
                case 6:
                    System.out.print("Enter employee id: ");
                    employeeId = scanner.next();
                    bank.deleteEmployee(employeeId);
                    break;
                case 7:
                    System.out.print("Enter interest rate(in %): ");
                    double interestRate = scanner.nextDouble();
                    bank.addInterestToAllAccounts(interestRate);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
