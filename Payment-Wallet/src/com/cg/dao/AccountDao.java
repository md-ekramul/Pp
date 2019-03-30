package com.cg.dao;



import java.util.HashMap;

import com.cg.bean.Account;
import com.cg.bean.Transaction;
import com.cg.exception.AccountException;

public interface AccountDao {

	long transId = 0;
	public Account addAccount (Account ac);
	public void addTransaction(long transId, Transaction ts );
	public Account showAccount(long accNo) throws AccountException;
	public long[] showTransIds (long accNo);
	public double deposit (long accNo, double amount);
	public double withdrawl (long accNo, double amount);
	public boolean transfer (long accNo1, long accNo2, double amount);
	public HashMap<Long,Transaction> showTransactions();
	
}
