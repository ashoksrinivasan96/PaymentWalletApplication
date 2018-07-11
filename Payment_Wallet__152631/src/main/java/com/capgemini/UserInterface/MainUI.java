package com.capgemini.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.capgemini.Bean.PaymentWallet;

import com.capgemini.Service.PaymentService;
import com.capgemini.Service.ServiceValidation;

public class MainUI {

	public static void main(String[] args) {
		ServiceValidation sv = new ServiceValidation();
		PaymentService ps = new PaymentService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			PaymentWallet pw = new PaymentWallet();

			System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
			System.out.println("█  PayMidas Payment Wallet Service █");
			System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
			System.out.println("█     1. Create an Account         █ ");
			System.out.println("█     2. Show Balance              █");
			System.out.println("█     3. Deposit                   █");
			System.out.println("█     4. Withdraw                  █");
			System.out.println("█     5. Fund Transfer             █");
			System.out.println("█     6. Print Transaction         █");
			System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("♠• In order to create your account, we require you to fill few details •♠");
				try {
					while (true) {
						// ..
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter your Full Name     █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						String consumerName = br.readLine();
						pw.setConsumerName(consumerName);
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
						pw.setAge(age);
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
						pw.setGender(gender);
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
						pw.setUserName(userName);
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
						pw.setPassword(password);
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
						pw.setEmailId(email);
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
						pw.setPhoneNo(phoneNo);
						if (sv.validatePhoneNo(phoneNo)) {
							break;
						} else {
							System.err.println("Please enter a valid mobile number.");
							continue;
						}
					}

					System.out.println(
							"♠• Thank you for providing the details.\n You have been assigned a unique bank account which you can access after signing in.");
					long bankAccount = (long) (Math.random() * 1000000 + 9999999);
					pw.setBankAccount(bankAccount);
					pw.setBalance(0);
					ps.createAccount(pw);
					break;

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			case 2:

				try {
					System.out.println("♠• You need to sign in to view balance •♠");
					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your username      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String username = br.readLine();
					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your password      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String password = br.readLine();
					pw = sv.validateLogIn(username, password);

					if (pw != null) {
						System.out.println(ps.showBalance(pw));
					} else if (pw == null) {
						System.err.println("Incorrect Username or Password!");
					}

					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 3:

				try {
					System.out.println("♠• Please sign in to add balance to your account. •♠");
					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your username      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String username = br.readLine();
					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your password      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String password = br.readLine();
					pw = sv.validateLogIn(username, password);

					if (pw != null) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter the amount you want to deposit █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						double depo = sc.nextDouble();
						System.out.println(ps.depositBalance(depo, pw));

						System.out.println("♠• Amount Successfuly Deposited. •♠");

					} else if (pw == null) {
						System.err.println("Incorrect Username or Password!");
					}
					break;

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			case 4:

				try {
					System.out.println("♠• Please sign in to withdraw balance from your account. •♠");
					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your username      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String username = br.readLine();
					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your password      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String password = br.readLine();
					pw = sv.validateLogIn(username, password);
					if (pw != null) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter the amount you want to withdraw  █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█ ");
						double withdraw = sc.nextDouble();
						if (ps.withdrawBalance(withdraw, pw) != null) {
							System.out.println(pw);
							System.out.println("♠• Amount Successfuly Withdrawn. •♠");
							break;
						} else if (ps.withdrawBalance(withdraw, pw) == null) {
							System.err.println("Insufficient Funds!");
							break;
						}

					} else if (pw == null) {
						System.err.println("Incorrect Username or Password!");
					}

					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			case 5:

				try {
					System.out.println("♠• Please sign in to perform transactions. •♠");
					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your username      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String username = br.readLine();
					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your password      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String password = br.readLine();
					pw = sv.validateLogIn(username, password);
					if (pw != null) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter the bank account you wanna transfer fund  █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						long bankAccount2 = Long.parseLong(br.readLine());
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter the amount         █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						double amount = Double.parseDouble(br.readLine());
						pw = ps.transferFund(bankAccount2, amount, pw);
						if (pw != null) {
							pw.setAmount(amount);
							long transactionId = (long) (Math.random() * 10000000 + 99999999);
							pw.setTransactionId(transactionId);
							System.out.println("♠• Funds Transferred Successfully! •♠");
							System.out.println("♠• Transaction ID: " + transactionId);
							break;
						} else if (pw == null) {
							break;
						}

					}
				}

				catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }

				}
			case 6:

				try {
					System.out.println("♠• Please sign in to view transactions. •♠");
					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your username      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String username = br.readLine();
					System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
					System.out.println("█ • Enter your password      █");
					System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
					String password = br.readLine();
					pw = sv.validateLogIn(username, password);
					if (pw != null) {
						System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
						System.out.println("█ • Enter the transaction ID      █");
						System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
						long transId = Long.parseLong(br.readLine());
						pw = ps.printTransaction(transId, pw);
						if (ps.printTransaction(transId, pw) != null) {
							System.out.println(
									"♠• Transaction details for the transaction ID: " + pw.getTransactionId() + "•♠");
							System.out.println("Receiver's Name: " + pw.getConsumerName());
							System.out.println("Account Number: " + pw.getBankAccount());
							System.out.println("Amount transacted: " + pw.getAmount());
							break;
						}

					} else
						System.err.println("The transaction ID you entered is either wrong, or does not exist!");
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}
}
