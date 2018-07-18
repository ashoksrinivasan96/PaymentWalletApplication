package com.capgemini.ui;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.ConsumerDetails;
import com.capgemini.bean.TransactionDetails;
import com.capgemini.exceptions.ExistingUsernameException;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceValidation;
import com.capgemini.service.ConsumerService;
import com.capgemini.service.ConsumerServiceValidation;
import com.capgemini.service.TransactionService;

public class MainUI {

	public static void main(String[] args) throws ExistingUsernameException {

		ConsumerServiceValidation consumerServiceValidationObject = new ConsumerServiceValidation();
		AccountServiceValidation accountServiceValidationObject = new AccountServiceValidation();
		AccountService accountServiceObject = new AccountService();
		ConsumerService consumerServiceObject = new ConsumerService();
		TransactionService transactionServiceObject = new TransactionService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			ConsumerDetails consumerDetailsObject = new ConsumerDetails();
			AccountDetails accountDetailsObject = new AccountDetails();
			TransactionDetails transactionDetailsObject = new TransactionDetails();

			System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
			System.out.println("█  PayMidas Payment Wallet Service █");
			System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
			System.out.println("█     1. Create an Account         █");
			System.out.println("█     2. Sign in                   █");
			System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("♠• In order to create your account, we require you to fill few details •♠");
				try {
					while (true) {

						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter your Full Name     █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						String consumerName = br.readLine();
						consumerDetailsObject.setConsumerName(consumerName);
						if (!consumerServiceValidationObject.validateConsumerName(consumerName)) {
							System.err.println("Invalid Name format!\n");
							continue;
						} else
							break;
					}

					while (true) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter your age           █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						int age = Integer.parseInt(br.readLine());
						consumerDetailsObject.setAge(age);
						if (!consumerServiceValidationObject.validateAge(age)) {
							System.err.println("Invalid Age!\n");
							continue;
						} else {
							break;
						}

					}

					while (true) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter your Gender        █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						String gender = br.readLine();
						consumerDetailsObject.setGender(gender);
						if (!consumerServiceValidationObject.validateGender(gender)) {
							System.err.println("Invalid Gender!");
							continue;
						} else
							break;
					}

					while (true) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter a Unique Username  █ ");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						String userName = br.readLine();
						accountDetailsObject.setUserName(userName);

						if (!accountServiceValidationObject.validateUserName(userName)) {
							System.err.println("Invalid Username!\n");
							continue;
						} else {
							break;
						}

					}
					while (true) {
						String password, repassword;
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter a Strong Password  █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						password = br.readLine();
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Re-Enter your Password   █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						repassword = br.readLine();
						accountDetailsObject.setPassword(password);
						if (accountServiceValidationObject.validatePassword(password, repassword)) {
							break;
						}

					}
					while (true) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter your Email account █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						String email = br.readLine();
						consumerDetailsObject.setEmailId(email);
						if (consumerServiceValidationObject.validateEmailID(email)) {
							break;
						} else {
							System.err.println("Invalid Email Format!\n");
							continue;
						}
					}
					while (true) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter your Mobile Number █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						String phoneNo = br.readLine();
						consumerDetailsObject.setPhoneNo(phoneNo);
						if (consumerServiceValidationObject.validatePhoneNo(phoneNo)) {
							break;
						} else {
							System.err.println("Please enter a valid mobile number.\n");
							continue;
						}
					}
					long bankAccount = (long) (Math.random() * 1000000 + 9999999);
					accountDetailsObject.setBankAccount(bankAccount);
					System.out.println("♠• Thank you for providing the details. •♠\n ♠• You have been assigned "
							+ bankAccount + " as your unique bank account number •♠.");

					accountDetailsObject.setBalance(0);

					consumerServiceObject.createAccount(consumerDetailsObject);
					accountServiceObject.createAccount(accountDetailsObject);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 2:

				try {

					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your username      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String username = br.readLine();
					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your password      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String password = br.readLine();
					accountDetailsObject = accountServiceValidationObject.validateLogIn(username, password);

					if (accountDetailsObject!=null) {

						while (true) {
							long transactionId, userTwoBankAccount;
							double depositAmount, withdrawAmount, transferAmount;

							System.out.println("♠• Welcome! What would you like to do? ");
							System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
							System.out.println("█     1. Show Balance              █");
							System.out.println("█     2. Deposit                   █");
							System.out.println("█     3. Withdraw                  █");
							System.out.println("█     4. Fund Transfer             █");
							System.out.println("█     5. Print Transaction         █");
							System.out.println("█     6. Sign Out                  █");
							System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");

							int signedChoice = sc.nextInt();
							switch (signedChoice) {
							case 1:
								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("█        ♠•  Balance •♠            █");
								System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
								accountServiceObject.showBalance(accountDetailsObject);
								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								continue;
							case 2:

								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("█ • Enter the amount you want to deposit █");
								System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
								depositAmount = sc.nextDouble();

								if (accountServiceObject.depositBalance(depositAmount, accountDetailsObject)) {
									System.out.println("♠• Amount Successfuly Deposited. •♠");
									System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
									accountDetailsObject.setAmount(depositAmount);
									transactionDetailsObject.setTransactionDate(LocalDate.now());
									transactionDetailsObject
											.setTransactionId((long) (Math.random() * 10000000 + 99999999));
									transactionDetailsObject.setTransactionType("Credited");
									transactionDetailsObject.setAmount(depositAmount);
									transactionDetailsObject.setBankAccount(accountDetailsObject.getBankAccount());
									transactionServiceObject.addTransactionDetails(transactionDetailsObject);
								}

								continue;
							case 3:

								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("█ • Enter the amount you want to withdraw  █");
								System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█ ");
								withdrawAmount = sc.nextDouble();
								if (accountServiceObject.withdrawBalance(withdrawAmount,
										accountDetailsObject) != null) {
									System.out.println(accountDetailsObject);
									System.out.println("♠• Amount Successfuly Withdrawn. •♠");
									System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
									accountDetailsObject.setAmount(withdrawAmount);
									transactionDetailsObject.setTransactionDate(LocalDate.now());
									transactionDetailsObject
											.setTransactionId((long) (Math.random() * 10000000 + 99999999));
									transactionDetailsObject.setTransactionType("Debited");
									transactionServiceObject.addTransactionDetails(transactionDetailsObject);

									continue;
								} else if (accountServiceObject.withdrawBalance(withdrawAmount,
										accountDetailsObject) == null) {
									System.err.println("Insufficient Funds!");
									continue;
								}
								continue;

							case 4:

								System.out.println(
										"▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println(
										"█ • Enter the bank account of the person you want to transfer fund         █");
								System.out.println(
										"█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
								userTwoBankAccount = Long.parseLong(br.readLine());
								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("█ • Enter the amount         █");
								System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
								transferAmount = Double.parseDouble(br.readLine());
								transactionId = (long) (Math.random() * 10000000 + 99999999);
								accountDetailsObject.getConsumer().getTransactionD().setTransactionId(transactionId);
								if (accountServiceObject.transferFund(userTwoBankAccount, transferAmount,
										accountDetailsObject)) {
									System.out.println("♠• Funds Transferred Successfully! •♠");
									accountDetailsObject.setAmount(transferAmount);
									transactionDetailsObject.setTransactionDate(LocalDate.now());
									transactionDetailsObject
											.setTransactionId((long) (Math.random() * 10000000 + 99999999));
									transactionDetailsObject.setTransactionType("Debited");
									transactionServiceObject.addTransactionDetails(transactionDetailsObject);

									continue;
								} else if (!accountServiceObject.transferFund(userTwoBankAccount, transferAmount,
										accountDetailsObject)) {
									System.err.println("Bank Account not found!");
									continue;
								}

							case 5:
								System.out.println(
										"  ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("  █           ♠• Transaction details for the Bank Account Number "
										+ accountDetailsObject.getBankAccount() + " •♠         █");
								transactionServiceObject
										.printTransaction(accountDetailsObject.getConsumer().getTransactionD());
								continue;

							case 6:
								System.out.println("♠• Have a nice day "
										+ accountDetailsObject.getConsumer().getConsumerName() + ". •♠");
								break;
							}
							break;
						}

					} else if (accountDetailsObject == null) {
						
						System.out.println("♠  Incorrect Username or Password!   ♠");
						
						continue;
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
		}

	}

}