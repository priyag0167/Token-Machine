package com.token;

import java.util.Scanner;

import com.token.impl.TokenImplInterface;

public class TokenMachineImpl implements TokenImplInterface {
	
	private static int ACCOUNTSIZE = 10;

	private TokenMachine token;

	
	@Override
	public void getToken() {	
		System.out.println("Welcome!! to XYZ Bank ");
		System.out.println("Press 'Y' for generating token ");
		Scanner sc = new Scanner(System.in);
		String alpha = sc.nextLine();
		if(alpha.equalsIgnoreCase("Y")){
		generateToken();
		}else{
			System.out.println("Sorry!! You have entered a wrong key.");
			getToken();
		}
	}
	
	private void generateToken(){		
		
		int counterNum =0 ;
		long tokenId = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your account number for token detail: ");
		long accountNum = 0;
		try {
			accountNum = sc.nextLong();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry!! account number is invalid. Please try again.");
			generateToken();
		}
		//Checking if account is valid by checking 10 digits of account number
		if(isValidAccount(accountNum)){
			token = new TokenMachine();
			// if account num is of privilage customer then counter num 1 and 2 will be displayed to customer
			if(token.isPrivlageCust(accountNum)){
				counterNum=token.getCounterNum(1);
				System.out.print("Dear Privilage customer");
			}else{
				counterNum=token.getCounterNum(0);
			}
			tokenId = token.getTokenId();
			System.out.println(" Your token num is: "+tokenId+" .Please directly proceed to counter Num : "+counterNum);
			System.out.println("Thank you!!!");
			getToken();
		}else{
			//if account is invalid customer will be again probed for  new account num
			System.out.println("Sorry!! account number is incorrect. Please try again.");
			generateToken();
		}
	}
	   
	//Checking 10 digits for valid account num
	private boolean isValidAccount(long num){
		int count=0;
		while(num>0){
			num=num/10;
			count++;
		}if(count == ACCOUNTSIZE)
			return true;
		else
			return false;
		}
}
