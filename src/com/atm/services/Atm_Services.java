package com.atm.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import com.atm.model.Atm_Users;
import com.atm.model.TransactionHistory;
import com.atm.dao.AtmDao;

public class Atm_Services {
	List<Atm_Users> userStorage = new ArrayList<Atm_Users>();
	Scanner sc = new Scanner(System.in);
//		int pin = 1111;
//		Long acctNo = 12345678l;
//		Long balance = 100l;

	public void welcomepage() {
		System.out.println("Welcome to Maddy Bank");
		initialOptions();
	}

	public void initialOptions() {
		System.out.println("1. Create Account");
		System.out.println("2. Login Account");
		int op = sc.nextInt();
		if (op == 1) {
			createAccount();
		} else if (op == 2) {
			loginAccount();
		} else {
			initialOptions();
		}
	}

	private void createAccount() {

		System.out.println("Enter Your New User Name");
		sc.nextLine();
		String name = sc.nextLine();
		Long acctNo = randomNumbers();
		System.out.println("Enter Your Address");
		String address = sc.nextLine();
		System.out.println("Enter Your Phone Number");
		long phn = sc.nextLong();
		System.out.println("Enter Your New PIN Number");
		int pin = sc.nextInt();
		System.out.println("Enter Your Opening Balance Amount");
		long balance = sc.nextLong();
		AtmDao atmDao = new AtmDao();
		atmDao.createNewUsersInformation(acctNo, name, pin, phn, address, balance);

//			userStorage.add(user);
		System.out.println("Hellow " + name + " Your Account Created Successful");
		System.out.println("Your Account Details");
		System.out.println("Name: " + name);
		System.out.println("Unique Account Number: " + acctNo);
		System.out.println("PIN Number: " + pin);
		System.out.println("Address: " + address);
		System.out.println("Phone Number: " + phn);
		System.out.println("Balance: " + balance);
		welcomepage();

	}

	private void loginAccount() {
		System.out.println("Enter Your 8 Digit Account Number");
		long acctno = sc.nextLong();
		System.out.println("Enter your 4 Digit PIN Number");
		int pin = sc.nextInt();
		AtmDao atmDao = new AtmDao();
		Atm_Users user = atmDao.getUserByAccountNumberAndPinNumber(acctno, pin);

//			List<Atm_Users> list = userByAccountNumberAndPinNumber.stream()
//					.filter(user -> user.getAccountNumber().equals(acctno))
//					.collect(Collectors.toList());

//			Banking_Usersdata user = null;
//			for(int  i = 0; i < list.size(); i++) {
//				if(userStorage.get(i).getAccountNumber().equals(acctno)) {
//					user = userStorage.get(i);
//				}
//			}

//			for(Banking_Usersdata user1: userStorage) {
//				if(user1.getAccountNumber().equals(acctno)) {
//					user = user1;
//				}
//			}

		if (Objects.nonNull(user)) {
			System.out.println("Login Successful");
			homePage(user);
		} else {
			System.out.println("Incorrect Account Number or Passward");
			loginAccount();
		}

	}

	private void homePage(Atm_Users user) {
		System.out.println("----Welcome To Home Page----");
		System.out.println("1. View Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. View User Details");
		System.out.println("5. Transaction History");
		System.out.println("6. Logout");

		homePageOptions(user);

	}

	private void homePageOptions(Atm_Users user) {
		AtmDao atm_User = new AtmDao();
		System.out.println("Enter Option");
		int option = sc.nextInt();

		if (option == 1) {
			System.out.println("Your Account Balance is " + user.getBalance());
			System.out.println("Click 1 For Go To Home Page");
			int exit = sc.nextInt();
			if (exit == 1) {
				homePage(user);
			}
		} else if (option == 2) {
			System.out.println("Enter Your Deposit Amount");
			long deposit = sc.nextLong();
			Date date = new Date(System.currentTimeMillis());
			System.out.println("RS " + deposit + " is Deposited Successful");
			Long balance = deposit + user.getBalance();
			atm_User.updateUserInformation(balance, user.getAccountNumber());
			user.setBalance(balance);
			atm_User.createTransactionHistoryDeposit(user.getAccountNumber(), date, deposit, balance);
			System.out.println("Your Total Balance is " + balance);
			System.out.println("Click 1 For Go To Home Page");
			int exit = sc.nextInt();
			if (exit == 1) {
				homePage(user);
			}
		} else if (option == 3) {
			System.out.println("Enter Your Withdraw Amount");
			long withdraw = sc.nextLong();
			Date date = new Date(System.currentTimeMillis());
			if (withdraw <= user.getBalance()) {
				System.out.println("RS " + " is Withdraw Successful");
				Long balance = user.getBalance() - withdraw;
				atm_User.updateUserInformation(balance, user.getAccountNumber());
				user.setBalance(balance);
				atm_User.createTransactionHistoryWithdraw(user.getAccountNumber(), date, withdraw, balance);
				System.out.println("Your Total Balance is " + balance);
			} else {
				System.out.println("Insufficient Balance");
				homePage(user);
			}

			System.out.println("Click 1 For Go To Home Page");
			int exit = sc.nextInt();
			if (exit == 1) {
				homePage(user);
			}

		} else if (option == 4) {
			System.out.println("Your Account Details");
			System.out.println("Name: " + user.getName());
			System.out.println("Account Number: " + user.getAccountNumber());
			System.out.println("PIN Number: " + user.getPinNumber());
			System.out.println("Address: " + user.getAddress());
			System.out.println("Phone Number: " + user.getPhoneNumber());
			System.out.println("Balance: " + user.getBalance());
			System.out.println("Click 1 For Go To Home Page");
			int exit = sc.nextInt();
			if (exit == 1) {
				homePage(user);
			}
		} else if (option == 5) {
			System.out.println("Your Transaction History");
			List<TransactionHistory> history = atm_User.getTransactionHistoryByAccountNumber(user.getAccountNumber());

			for (TransactionHistory histo : history) {
				System.out.println(
						"Trasaction Date: " + histo.getTransactionDate() + " |WithDraw: " + histo.getWithdrawAmount()
								+ " |Deposit: " + histo.getDepositAmount() + " |Balance: " + histo.getBalance());
				System.out.println("----------------------------------------------------------");
			}
			System.out.println("Click 1 For Go To Home Page");
			int exit = sc.nextInt();
			if (exit == 1) {
				homePage(user);
			}

		}

		else if (option == 6) {
			System.out.println("Logout Successful");
			welcomepage();
		} else {
			System.out.println("Select Correct Option");
			homePage(user);

		}
	}

	public Long randomNumbers() {
		Random random = new Random();
		Integer in = random.ints(1, 10000000, 99999999).findFirst().getAsInt();
		return in.longValue();

	}
}
