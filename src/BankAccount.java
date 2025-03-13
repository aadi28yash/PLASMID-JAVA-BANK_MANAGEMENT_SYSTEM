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
        } else {
            System.out.println("Maximum cash inflows reached for this month.");
        }
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void addInterest(double interestRate) {
        balance += balance * interestRate / 100;
        cashInflows = 0;
    }
}

