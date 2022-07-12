package com.kakao.zemni;

public class AccountTest {

	public static void main(String[] args) {
		Account account = new Account();
		account.setAccountNumber("123-45678");
		account.setPersonName("홍길동");
		System.out.println("계좌 " + account.getAccountNumber() + "( 예금주 : " + account.getPersonName() + " )");
		account.setBalance(10000);
		account.getBalance();
		account.Deposit(20000);
		account.withDraw(45000);
	}

}