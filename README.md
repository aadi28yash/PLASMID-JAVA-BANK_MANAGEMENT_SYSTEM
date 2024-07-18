# PLASMID-JAVA-BANK_MANAGEMENT_SYSTEM

A Bank Management System (BMS) is a software application that enables banks and other financial institutions to manage their daily operations efficiently. It is a comprehensive system that automates and streamlines various banking processes, improving customer service, reducing operational costs, and increasing productivity.

This is a Java program that implements a Bank Management System. Here's a breakdown of the code:

BankAccount class:

Represents a bank account with attributes:
accountNumber: a unique identifier for the account
accountHolderName: the name of the account holder
balance: the current balance of the account
cashInflows: the number of cash inflows (deposits) made to the account this month
Methods:
deposit(double amount): adds the specified amount to the account balance and increments the cash inflows counter
withdraw(double amount): subtracts the specified amount from the account balance if sufficient funds are available
addInterest(double interestRate): adds interest to the account balance based on the specified interest rate and resets the cash inflows counter for the next month
BankEmployee class:

Represents a bank employee with attributes:
employeeId: a unique identifier for the employee
name: the employee's name
position: the employee's position at the bank
Methods:
getters for the employee's attributes
Bank class:

Represents the bank itself, which has:
a list of BankAccount objects (accounts)
a list of BankEmployee objects (employees)
Methods:
createAccount(String accountNumber, String accountHolderName, double initialBalance): creates a new BankAccount object and adds it to the accounts list
searchAccount(String accountNumber): searches for a BankAccount object by account number and returns it if found
displayAllAccounts(): displays all accounts in the accounts list
deleteAccount(String accountNumber): deletes a BankAccount object by account number if found
addEmployee(String employeeId, String name, String position): creates a new BankEmployee object and adds it to the employees list
searchEmployee(String employeeId): searches for a BankEmployee object by employee ID and returns it if found
displayAllEmployees(): displays all employees in the employees list
deleteEmployee(String employeeId): deletes a BankEmployee object by employee ID if found
addInterestToAllAccounts(double interestRate): adds interest to all accounts in the accounts list based on the specified interest rate
BankManagementSystem class:

The main class that contains the main method
Creates a Bank object and provides a menu-driven interface for users to interact with the system
Methods:
customerOperations(Bank bank, Scanner scanner, BankAccount account): handles customer operations (deposit, withdraw, check balance)
employeeOperations(Bank bank, Scanner scanner, BankEmployee employee): handles employee operations (create account, delete account, display all accounts)
adminOperations(Bank bank, Scanner scanner): handles admin operations (create account, delete account, display all accounts, add employee, display all employees, delete employee, add interest to all accounts)
The program uses a Scanner object to read input from the user and performs different operations based on the user's choice.

Here's an example of how the program could be used:

Run the program: java BankManagementSystem
Choose an option from the main menu:
Customer Login: enter account number and perform operations (deposit, withdraw, check balance)
Employee Login: enter employee ID and perform operations (create account, delete account, display all accounts)
Admin Login: perform operations (create account, delete account, display all accounts, add employee, display all employees, delete employee, add interest to all accounts)
Exit the System: exit the program
Note that this program does not persist data, so all data will be lost when the program is terminated. In a real-world scenario, you would want to use a database to store data persistently.
