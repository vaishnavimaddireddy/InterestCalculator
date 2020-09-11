package com.wipro.bank.acc;

public class RDAccount extends Account{
	public RDAccount(int tenure, float principal) {
		this.tenure=tenure;
		this.principal=principal;
	}
	public float calculateInterest() {
		float r=rateOfInterest/100;
		int n=4;
		float p=0.0f;
		float t=tenure*12;
		for(int i=0;i<t;i++)
		{
			p=p+principal*(float)((Math.pow(1+(r/n),n*(t-i)/12.0))-1);
		}
		return p;
	}
	public float calculateAmountDeposited()
	{
		return (principal*tenure*12);
	}
}
