# Banking-App-with-SQL
This ATM application is purely developed with java 8 SE and MySQL. it is console based application, Which is developed based on real ATM machine.

## Application Design Reference: [Design Architecture Link](https://drive.google.com/file/d/1Zi7fyEXoKMP_aNEb62JM36QSbmaLETfU/view?usp=sharing)

## Features:

- Welcome Page
   - [Create Account](#create_account)
   - [Login](#login)
   
- Home Page
   - [View account details](#view_details)
   - [View account balance](#view_balance)
   - [Deposit](#deposit)
   - [Withdraw](#withdraw)
   - [Transaction history](#history)
   - [Logout](#logout)
   
   
### Create Account <a name = "create_account"></a>
   - In create login user can create new login with account number, which is unique number for every login.
### Login <a name = "login"></a>
   - After created the login, User can login with the account number and pin number to access the ATM application.
        
#### After login, User can access the application features,

### View account balance <a name = "view_balance"></a>
   - In this feature user can see the currect balance of the account
### Deposit <a name = "deposit"></a>
   - User can deposit the amount and user can see the balance after deposit.
### Withdraw <a name = "withdraw"></a>
   - User can withdraw amount. Only if the withdraw amount below and equal to currect balance, or else it will show the error massage.
### View account details <a name = "view_details"></a>
   - User can see the account details. which having all the information about the account.
### Transaction history <a name = "history"></a>
   - In this feature, User can see the all transactions with trasaction date. It have some information like deposit and withdraw.
### Logout <a name = "logout"></a>
   - User can logout the account, It will navigate to welcome page. 

## Used technologies and methods are,
### java 8: 
   - Oops concepts, Scanner, List, Object, Random Class, Iteration and Condition Statements. 
### SQL(MySQL): 
   - SELECT, UPDATE, INSERT, CREATE, ALTER, ORDER BY, WHERE, SET
   - Constraints (Foreign Key, Primary Key, Unique Key, Not Null)
