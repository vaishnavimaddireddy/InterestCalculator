package com.wipro.bank.service;
import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;

public class BankService {
	public boolean validateData(float principal, int tenure,int age, String gender)
	{
	  try
	  {
		  if(principal<500)
			  throw new BankValidationException();
		  if(!(tenure==5||tenure==10))
			  throw new BankValidationException();
		  if(!(gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female")))
			  throw new BankValidationException();
		  if(!(age>=1&&age<=100))
			  throw new BankValidationException();
			  
	  }
	  catch(BankValidationException e)
	  {
		  return false;
	  }
	  return true;
	}
	public void calculate(float principal,int tenure, int age, String gender)
	{
		boolean validate=validateData(principal, tenure, age, gender);
		BankValidationException e=new BankValidationException();
		if(!(validate))
			System.out.println(e.toString());
		else 
		{
			RDAccount rda=new RDAccount(tenure, principal);
			rda.setInterest(age, gender);
			float ci=rda.calculateInterest();
			System.out.println(ci);
			float cad=rda.calculateAmountDeposited();
			System.out.println(cad);
			float cma=rda.calculateMaturityAmount(cad, ci);
			System.out.println(cma);
		}
	}
}
