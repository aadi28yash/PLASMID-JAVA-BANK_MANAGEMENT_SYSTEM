# PLASMID-JAVA-BANK_MANAGEMENT_SYSTEM
A Bank Management System (BMS) is a software application that enables banks and other financial institutions to manage their daily operations efficiently. It is a comprehensive system that automates and streamlines various banking processes, including account management, transaction processing, loan management, and customer relationship management.

This is a Java program that implements a simple Bank Management System. Here's a breakdown of the code:

Classes:

BankAccount: Represents a bank account with attributes like account number, account holder name, balance, and cash inflows. BankEmployee: Represents a bank employee with attributes like employee ID, name, and position. Bank: Represents the bank itself, with methods to create accounts, delete accounts, display all accounts, add employees, display all employees, delete employees, and add interest to all accounts. BankManagementSystem: The main class that contains the main method and implements the user interface for the bank management system. BankAccount class:

Has private fields for account number, account holder name, balance, and cash inflows. Has getters and setters for these fields. Has methods to deposit, withdraw, and add interest to the account. The deposit method checks if the cash inflows limit (5) has been reached for the month, and if so, prevents further deposits. The withdraw method checks if the balance is sufficient for the withdrawal. BankEmployee class:

Has private fields for employee ID, name, and position. Has getters and setters for these fields. Bank class:

Has an ArrayList of BankAccount objects and an ArrayList of BankEmployee objects. Has methods to: Create a new account and add it to the list. Search for an account by account number and return it if found. Display all accounts. Delete an account by account number. Add an employee and add it to the list. Search for an employee by employee ID and return it if found. Display all employees. Delete an employee by employee ID. Add interest to all accounts. BankManagementSystem class:

Has a main method that creates a Bank object and a Scanner object for user input. Implements a menu-driven user interface with options for customer login, employee login, admin login, and exit. For each login option, it prompts the user to enter their credentials and then calls the corresponding method to handle the login. The customerOperations method handles customer login and provides options to deposit, withdraw, check balance, and return to the main menu. The employeeOperations method handles employee login and provides options to create an account, delete an account, display all accounts, and return to the main menu. The adminOperations method handles admin login and provides options to create an account, delete an account, display all accounts, add an employee, display all employees, delete an employee, add interest to all accounts, and return to the main menu. Overall, this program provides a simple implementation of a bank management system with basic functionality for customers, employees, and administrators.
