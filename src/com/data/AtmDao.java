package com.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.atm.users.Atm_Users;
import com.config.DatabaseConfiguration;

public class AtmDao {

	private static Connection session = DatabaseConfiguration.createSession();

	public List<Atm_Users> getAllUSers() {
		List<Atm_Users> users = new ArrayList<Atm_Users>();
		try {
			String query = "select * from users";

			Statement st = session.createStatement();
			ResultSet et = st.executeQuery(query);

			while (et.next()) {
				Atm_Users atm_User = new Atm_Users();

				atm_User.setAccountNumber(et.getLong(1));
				atm_User.setName(et.getString(2));
				atm_User.setPinNumber(et.getInt(3));
				atm_User.setPhoneNumber(et.getLong(4));
				atm_User.setAddress(et.getString(5));
				atm_User.setBalance(et.getLong(6));

				users.add(atm_User);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public Atm_Users getUserByAccountNumberAndPinNumber(long acctno, int pin) {
		Atm_Users atm_User = null;
		try {
			String query2 = "SELECT * FROM users WHERE AccountNumber= " + acctno + " and PinNumber= " + pin;

			Statement statement = session.createStatement();
			ResultSet et = statement.executeQuery(query2);

			while (et.next()) {
				atm_User = new Atm_Users();
				atm_User.setAccountNumber(et.getLong(1));
				atm_User.setName(et.getString(2));
				atm_User.setPinNumber(et.getInt(3));
				atm_User.setPhoneNumber(et.getLong(4));
				atm_User.setAddress(et.getString(5));
				atm_User.setBalance(et.getLong(6));

			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		return atm_User;

	}

	public void createNewUsersInformation(Long acctNo, String name, int pin, long phn, String address, long balance) {
		try {

			String newUsersUpdate = "insert into users (AccountNumber,Name, PinNumber, PhoneNumber, Address, Balance) values("
					+ acctNo + ",'" + name + "'," + pin + "," + phn + ",'" + address + "'," + balance + ")";
			Statement ct = session.createStatement();
			ct.executeUpdate(newUsersUpdate);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateUserInformation(Long balance, Long accountNumber) {

		try {

			String newUsersUpdate = "update users set Balance = "+balance+" where AccountNumber = "+accountNumber;
			Statement ct = session.createStatement();
			ct.executeUpdate(newUsersUpdate);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
