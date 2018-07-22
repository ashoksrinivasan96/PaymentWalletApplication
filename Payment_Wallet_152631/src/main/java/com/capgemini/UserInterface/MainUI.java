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
import com.capgemini.PaymentExceptions.ExistingUsernameException;
import com.capgemini.Service.PaymentService;
import com.capgemini.Service.ServiceValidation;

public class MainUI {

	public static void main(String[] args) throws ExistingUsernameException {

		ServiceValidation serviceValidationObject = new ServiceValidation();
		PaymentService paymentServiceObject = new PaymentService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			ArrayList<String> transactionDetails = new ArrayList<String>();
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
						if (!serviceValidationObject.validateConsumerName(consumerName)) {
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
						if (!serviceValidationObject.validateAge(age)) {
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
						if (!serviceValidationObject.validateGender(gender)) {
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
						
							if (!serviceValidationObject.validateUserName(userName)) {
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
						if (serviceValidationObject.validatePassword(password, repassword)) {
							break;
						}
						;
					}
					while (true) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter your Email account █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						String email = br.readLine();
						consumerDetailsObject.setEmailId(email);
						if (serviceValidationObject.validateEmailID(email)) {
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
						if (serviceValidationObject.validatePhoneNo(phoneNo)) {
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

					transactionDetailsObject.setTransactionDetails(transactionDetails);
					consumerDetailsObject.setTransactionD(transactionDetailsObject);
					accountDetailsObject.setCd(consumerDetailsObject);
					paymentServiceObject.createAccount(accountDetailsObject);

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
					accountDetailsObject = serviceValidationObject.validateLogIn(username, password);

					if (accountDetailsObject != null) {

						while (true) {
							long transactionId, userTwoBankAccount;
							double depositAmount, withdrawAmount, transferAmount;

							System.out.println("♠• Welcome " + accountDetailsObject.getConsumer().getConsumerName()
									+ ". What would you like to do? ");
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
								paymentServiceObject.showBalance(accountDetailsObject);
								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								continue;
							case 2:

								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("█ • Enter the amount you want to deposit █");
								System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
								depositAmount = sc.nextDouble();
								System.out.println(
										paymentServiceObject.depositBalance(depositAmount, accountDetailsObject));
								System.out.println("♠• Amount Successfuly Deposited. •♠");
								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								accountDetailsObject.setAmount(depositAmount);
								accountDetailsObject.getConsumer().getTransactionD()
										.setTransactionDate(LocalDate.now());
								transactionId = (long) (Math.random() * 10000000 + 99999999);
								accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
										.add((String.valueOf(accountDetailsObject.getConsumer().getTransactionD()
												.getTransactionDate()) + "      \t"));
								accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
										.add(String.valueOf(transactionId) + "\t");
								accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
										.add("Credited\t\t");
								accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
										.add(String.valueOf(accountDetailsObject.getAmount()) + " \t");
								accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
										.add(String.valueOf(accountDetailsObject.getBalance()) + "\n");

								continue;
							case 3:

								System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("█ • Enter the amount you want to withdraw  █");
								System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█ ");
								withdrawAmount = sc.nextDouble();
								if (paymentServiceObject.withdrawBalance(withdrawAmount,
										accountDetailsObject) != null) {
									System.out.println(accountDetailsObject);
									System.out.println("♠• Amount Successfuly Withdrawn. •♠");
									System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
									accountDetailsObject.setAmount(withdrawAmount);
									transactionId = (long) (Math.random() * 10000000 + 99999999);
									accountDetailsObject.getConsumer().getTransactionD()
											.setTransactionDate(LocalDate.now());
									accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
											.add((String.valueOf(accountDetailsObject.getConsumer().getTransactionD()
													.getTransactionDate()) + "      \t"));
									accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
											.add(String.valueOf(transactionId) + " \t");
									accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
											.add("Debited\t\t");
									accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
											.add(String.valueOf(accountDetailsObject.getAmount()) + " \t");
									accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
											.add(String.valueOf(accountDetailsObject.getBalance()) + "\n");

									continue;
								} else if (paymentServiceObject.withdrawBalance(withdrawAmount,
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
								if (paymentServiceObject.transferFund(userTwoBankAccount, transferAmount,
										accountDetailsObject)) {
									System.out.println("♠• Funds Transferred Successfully! •♠");
									accountDetailsObject.setAmount(transferAmount);
									accountDetailsObject.getConsumer().getTransactionD()
											.setTransactionDate(LocalDate.now());
									accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
											.add((String.valueOf(accountDetailsObject.getConsumer().getTransactionD()
													.getTransactionDate()) + "      \t"));
									accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
											.add(String.valueOf(transactionId) + "\t");
									accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
											.add("Debited\t\t");
									accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
											.add(String.valueOf(accountDetailsObject.getAmount()) + " \t");
									accountDetailsObject.getConsumer().getTransactionD().getTransactionDetails()
											.add(String.valueOf(accountDetailsObject.getBalance()) + "\n");

									continue;
								} else if (!paymentServiceObject.transferFund(userTwoBankAccount, transferAmount,
										accountDetailsObject)) {
									System.err.println("Bank Account not found!");
									continue;
								}

							case 5:
								System.out.println(
										"  ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
								System.out.println("  █           ♠• Transaction details for the Bank Account Number "
										+ accountDetailsObject.getBankAccount() + " •♠         █");
								paymentServiceObject
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
						System.err.println("Incorrect Username or Password!\n");
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
