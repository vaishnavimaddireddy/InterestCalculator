package com.wipro.bank.exception;

@SuppressWarnings("serial")
public class BankValidationException extends Exception{

	public String toString()
	{
		return "Invalid Data";
	}
}
