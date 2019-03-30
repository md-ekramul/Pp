package com.cg.staticdb;

import java.util.HashMap;

import com.cg.bean.Account;
import com.cg.bean.Transaction;

public class StaticDB {
	
	static HashMap<Long, Account>accountMap = new HashMap<Long,Account>();
	
	static HashMap<Long, Transaction> transMap = new HashMap<Long, Transaction>();
	
	
	public static HashMap <Long, Account> getAccount(){
		return accountMap;
	}
	
	public static HashMap<Long, Transaction> getTransaction()
	{
		return transMap;
	}

}
