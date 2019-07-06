package com.token;

import java.util.ArrayList;

public class TokenMachine{ 
	
	private volatile static int tokenId=1;
	
	private static int counterNum=2;
	
	private ArrayList<Integer> privilageCust;
	
	/* get unique token id */
	public synchronized int getTokenId() {
        return tokenId++;
		}

	//return 1 and 2 counter for privilage customers, counter 3 for normal customers
	public int getCounterNum(int id) {
				if(id == 1){			
			if(counterNum%2!=0){
				counterNum++;
				return 1;
			}else{
				counterNum++;
				return 2;
			}
			}
		return 3;
	}

	public ArrayList<Integer> getPrivilageCust() {
		return addPrivilageCust();
	}

	public void setPrivilageCust(ArrayList<Integer> privilageCust) {
		this.privilageCust = privilageCust;
	}

	//created list of account nums of privilage customers
	private ArrayList<Integer> addPrivilageCust(){
		privilageCust = new ArrayList<>();
		privilageCust.add(1345634225);
		privilageCust.add(1343634225);
		privilageCust.add(1342634225);
		privilageCust.add(1345114225);
		privilageCust.add(1342634225);
		privilageCust.add(1345834225);
		privilageCust.add(1245634225);
		privilageCust.add(1145634225);
		return privilageCust;
	}
	
	//Checking of customer is privilage customer through account num
	public boolean isPrivlageCust(long num){
		ArrayList<Integer> privCustomer = getPrivilageCust();
		if(privCustomer.contains((int)num)){
			return true;
		}return false;
	}
}
