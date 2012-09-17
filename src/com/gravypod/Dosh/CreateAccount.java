package com.gravypod.Dosh;


public class CreateAccount extends MoneyUtils {
	
	public static void createAccount(String name) {
		
		if (!Settings.moneyStore.contains("user." + name))
			setUserBal(name, Settings.startingBal);
		
	}
	
}
