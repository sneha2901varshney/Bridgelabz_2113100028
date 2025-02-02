
class BankAccount:
    def __init__(self, accountNumber, accountHolder, balance=0):
        self.accountNumber = accountNumber
        self._accountHolder = accountHolder
        self.__balance = balance

    def get_balance(self):
        return self.__balance

    def set_balance(self, amount):
        if amount >= 0:
            self.__balance = amount
        else:
            print("Balance cannot be negative.")

class SavingsAccount(BankAccount):
    def __init__(self, accountNumber, accountHolder, balance=0):
        super().__init__(accountNumber, accountHolder, balance)
    
    def get_account_holder(self):
        return self._accountHolder
    
    def get_account_number(self):
        return self.accountNumber

account = SavingsAccount(123456, "John Doe", 1000)
print(f"Account Number: {account.get_account_number()}")
print(f"Account Holder: {account.get_account_holder()}")
print(f"Initial Balance: {account.get_balance()}")

account.set_balance(1500)
print(f"Updated Balance: {account.get_balance()}")

