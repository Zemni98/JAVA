package com.kakao.zemni;

public class Account {
	private String personName;
	private String accountNumber;
	private int balance;

	public void Deposit(int money) {
		this.balance += money;
		System.out.println(money + "원 입금합니다.");
		System.out.println("잔액 : " + balance + "원");
	}

	public void withDraw(int money) {
		this.balance -= money;
		System.out.println(money + "원 출급합니다.");
		System.out.println("잔액 : " + balance + "원");

	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		System.out.println("잔액 : " + this.balance + "원");
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;

	}
}