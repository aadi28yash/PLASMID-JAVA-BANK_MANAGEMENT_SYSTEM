import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private int cashInflows;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.cashInflows = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (cashInflows < 5) {
            balance += amount;
            cashInflows++;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Maximum cash inflows reached for this month.");
        }
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void addInterest(double interestRate) {
        balance += balance * interestRate / 100;
        cashInflows = 0; // Reset cash inflows for the next month
    }
}

class BankEmployee {
    private String employeeId;
    private String name;
    private String position;

    public BankEmployee(String employeeId, String name, String position) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}

class Bank {
    private ArrayList<BankAccount> accounts;
    private ArrayList<BankEmployee> employees;

    public Bank() {
        accounts = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    public BankAccount searchAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        for (BankAccount account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder Name: " + account.getAccountHolderName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println();
        }
    }

    public void deleteAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accounts.remove(account);
                System.out.println("Account deleted successfully!");
                return;
            }
        }
        System.out.println("Account not found");
    }

    public void addEmployee(String employeeId, String name, String position) {
        BankEmployee employee = new BankEmployee(employeeId, name, position);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public BankEmployee searchEmployee(String employeeId) {
        for (BankEmployee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    public void displayAllEmployees() {
        for (BankEmployee employee : employees) {
            System.out.println("Employee Id: " + employee.getEmployeeId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println();
        }
    }

    public void deleteEmployee(String employeeId) {
        for (BankEmployee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                employees.remove(employee);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    public void addInterestToAllAccounts(double interestRate) {
        for (BankAccount account : accounts) {
            account.addInterest(interestRate);
        }
    }
}

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
                    // Customer Login
                    System.out.println("Customer Login");
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    BankAccount account = bank.searchAccount(accountNumber);
                    if (account!= null) {
                        System.out.println("Login successful!");
                        customerOperations(bank, scanner, account);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 2:
                    // Employee Login
                    System.out.println("Employee Login");
                    System.out.print("Enter employee id: ");
                    String employeeId = scanner.next();
                    BankEmployee employee = bank.searchEmployee(employeeId);
                    if (employee!= null) {
                        System.out.println("Login successful!");
                        employeeOperations(bank, scanner, employee);
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                case 3:
                    // Admin Login
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
                    String employeeId =scanner.next();
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