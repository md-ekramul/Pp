package com.cg.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import com.cg.bean.Account;
import com.cg.bean.Transaction;
import com.cg.exception.AccountException;
import com.cg.staticdb.StaticDB;

public class AccountDaoImpl implements AccountDao {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	@Override
	public Account addAccount(Account ac) {
		StaticDB.getAccount().put(ac.getAccNo(), ac);
		return ac;
	}

	@Override
	public void addTransaction(long transId, Transaction ts) {
		StaticDB.getTransaction().put(transId, ts);

	}

	@Override
	public Account showAccount(long accNo) throws AccountException {
		HashMap<Long, Account> accountMap = StaticDB.getAccount();
		if(accountMap.size()==0)
			throw new AccountException("No Employee data found");
		else
		return StaticDB.getAccount().get(accNo); 
	}

	@Override
	public long[] showTransIds(long accNo) {
		
		return StaticDB.getAccount().get(accNo).getTransId();
	}
	
	public void updateBal(long accNo, double amount) {
		double balance = StaticDB.getAccount().get(accNo).getAccBal()+amount;
		StaticDB.getAccount().get(accNo).setAccBal(balance);
	} 

	@Override
	public double deposit(long accNo, double amount) {
		
		updateBal(accNo, amount);
		StaticDB.getAccount().get(accNo).setTransId(((long)(Math.random()*1000+1)));
		LocalDateTime now= LocalDateTime.now();
		Transaction ts = new Transaction("Deposit",amount, StaticDB.getAccount().get(accNo).getAccBal(), dtf.format(now));
		addTransaction(StaticDB.getAccount().get(accNo).getTransId(0), ts);
		
	}

	@Override
	public double withdrawl(long accNo, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean transfer(long accNo1, long accNo2, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashMap<Long, Transaction> showTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

}
