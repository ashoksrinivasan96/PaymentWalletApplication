package com.capgemini.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.Bean.AccountDetails;
import com.capgemini.Bean.ConsumerDetails;
import com.capgemini.Bean.TransactionDetails;
import com.capgemini.Service.PaymentService;
import com.capgemini.Service.ServiceValidation;

public class MainUI {

	public static void main(String[] args) {

		
		ServiceValidation sv = new ServiceValidation();
		PaymentService ps = new PaymentService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			ArrayList<String> transactionDetails = new ArrayList<String>();
			ConsumerDetails cd = new ConsumerDetails();
			AccountDetails ad = new AccountDetails();
			TransactionDetails td = new TransactionDetails();

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
						cd.setConsumerName(consumerName);
						if (!sv.validateConsumerName(consumerName)) {
							System.err.println("Invalid Name format!");
							continue;
						} else
							break;
					}

					while (true) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter your age           █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						int age = Integer.parseInt(br.readLine());
						cd.setAge(age);
						if (!sv.validateAge(age)) {
							System.err.println("Invalid Age!");
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
						cd.setGender(gender);
						if (!sv.validateGender(gender)) {
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
						ad.setUserName(userName);
						if (!sv.validateUserName(userName)) {
							System.err.println("Invalid Username!");
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
						ad.setPassword(password);
						if (sv.validatePassword(password, repassword)) {
							break;
						}
						;
					}
					while (true) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter your Email address █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						String email = br.readLine();
						cd.setEmailId(email);
						if (sv.validateEmailID(email)) {
							break;
						} else {
							System.err.println("Invalid Email Format!");
							continue;
						}
					}
					while (true) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter your Mobile Number █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						String phoneNo = br.readLine();
						cd.setPhoneNo(phoneNo);
						if (sv.validatePhoneNo(phoneNo)) {
							break;
						} else {
							System.err.println("Please enter a valid mobile number.");
							continue;
						}
					}
					long bankAccount = (long) (Math.random() * 1000000 + 9999999);
					ad.setBankAccount(bankAccount);
					System.out.println("♠• Thank you for providing the details. •♠\n ♠• You have been assigned "
							+ bankAccount + " as your unique bank account number •♠.");
					
					ad.setBalance(0);
					
					
					td.setTransactionDetails(transactionDetails);
					cd.setTransactionD(td);
					ad.setCd(cd);
					ps.createAccount(ad);
					
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
					ad = sv.validateLogIn(username, password);

					if (ad != null) {

						while (true) {
							long transactionId, bankAccount2;
							double deposit, withdraw, amount;

							System.out.println("♠• Welcome " + ad.getConsumer().getConsumerName() + ". What would you like to do? ");
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
								ps.showBalance(ad);
								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								continue;
							case 2:

								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("█ • Enter the amount you want to deposit █");
								System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
								deposit = sc.nextDouble();
								System.out.println(ps.depositBalance(deposit, ad));
								System.out.println("♠• Amount Successfuly Deposited. •♠");
								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								ad.setAmount(deposit);
								transactionId = (long) (Math.random() * 10000000 + 99999999);
								transactionDetails.add((String.valueOf(ad.getConsumer().getTransactionD().getTransactionDate()) + "\t"));
								transactionDetails.add((String.valueOf(td.getTransactionDate()) + "\t"));
								transactionDetails.add(String.valueOf(transactionId) + "\t");
								transactionDetails.add(String.valueOf(ad.getAmount()) + "\t");
								transactionDetails.add(String.valueOf(ad.getBalance())+"\n");
								ad.getConsumer().getTransactionD().setTransactionDetails(transactionDetails);

								continue;
							case 3:

								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("█ • Enter the amount you want to withdraw  █");
								System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█ ");
								withdraw = sc.nextDouble();
								if (ps.withdrawBalance(withdraw, ad) != null) {
									System.out.println(ad);
									System.out.println("♠• Amount Successfuly Withdrawn. •♠");
									System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
									ad.setAmount(withdraw);
									transactionId = (long) (Math.random() * 10000000 + 99999999);
									ad.getConsumer().getTransactionD().setTransactionDate(LocalDate.now());
									transactionDetails.add((String.valueOf(ad.getConsumer().getTransactionD().getTransactionDate()) + "\t"));
									transactionDetails.add(String.valueOf(transactionId) + "\t");
									transactionDetails.add(String.valueOf(ad.getAmount()) + "\t");
									transactionDetails.add(String.valueOf(ad.getBalance())+"\n");
									ad.getConsumer().getTransactionD().setTransactionDetails(transactionDetails);

									continue;
								} else if (ps.withdrawBalance(withdraw, ad) == null) {
									System.err.println("Insufficient Funds!");
									continue;
								}
								continue;

							case 4:

								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("█ • Enter the bank account you wanna transfer fund  █");
								System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
								bankAccount2 = Long.parseLong(br.readLine());
								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("█ • Enter the amount         █");
								System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
								amount = Double.parseDouble(br.readLine());
								ps.transferFund(bankAccount2, amount, ad);
								if (ps.transferFund(bankAccount2, amount, ad) != null) {
									System.out.println("♠• Funds Transferred Successfully! •♠");
									ad.setAmount(amount);
									
									
									transactionId = (long) (Math.random() * 10000000 + 99999999);
									ad.getConsumer().getTransactionD().setTransactionDate(LocalDate.now());
									transactionDetails.add((String.valueOf(ad.getConsumer().getTransactionD().getTransactionDate()) + "\t"));
									transactionDetails.add(String.valueOf(transactionId) + "\t");
									transactionDetails.add(String.valueOf(ad.getAmount()) + "\t");
									transactionDetails.add(String.valueOf(ad.getBalance())+"\n");
									ad.getConsumer().getTransactionD().setTransactionDetails(transactionDetails);

									continue;
								} else if (ps.transferFund(bankAccount2, amount, ad) == null) {
									continue;
								}

							case 5:
								System.out.println(
										"♠• Transaction details for the Bank Account Number " + ad.getBankAccount());
								ps.printTransaction(ad.getConsumer().getTransactionD());
								continue;

							case 6:
								System.out.println("♠• Have a nice day " + ad.getConsumer().getConsumerName() + ". •♠");
								break;
							}
							break;
						}

					} else if (ad == null) {
						System.err.println("Incorrect Username or Password!");
						break;
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}

	}

}
