package mainProj;

import java.time.LocalDate;

//SIMPLIFIED VERSION:

//1- No agency concept;
//2- No VIP clients;
//3- No investment accounts;
//4- Only 1 registry per movement
//5- Interest calculations performed only on prazo accounts


public class App {

	public static void main(String[] args) {

		String[] names = { "Ricardo Capao", "Luis Esteves", "Henrique Varela", "Gustavo Martim" };
		int[] numberCC = { 13056783, 38194719, 21487789, 21857809 };
		String[] adress = { "St. York, 7124", "Avenue LA, 138", "Baker street, 221B", "Silver St.,8248" };
		int[][] phone = { { 919010424 }, { 910987354, 903093443 }, { 929409239 }, { 934239400, 987623457 } };
		String[][] emails = { { "ricardo.j.l.capao@gmail.com", "ricardo.jorge.lc@gmail.com" }, { "abs_@hot.pt" },
				{ "ecv@jbs.com" }, { "assdv@asdd.pt" } };
		String[] profession = { "Electrical-Enginner, Power Systems", "Cientist", "Math teacher", "CEO" };

//		Client cliente = new Client(names[0], numberCC[0], adress[0], phone[0], emails[0], profession[0]);
//		Client cliente1 = new Client(names[1], numberCC[1], adress[1], phone[1], emails[1], profession[1]);
//
//
//		// toString() tests
//
//		// System.out.println(cliente);
//		//
//		// System.out.println(cliente.getO_account());
//		//
//		// System.out.println(cliente.getO_account().getD_Cards().get(0));
//		// *
//		// cliente.getO_account().getC_Cards().add(new
//		// CreditCard(cliente.getO_account(), 'C', 500));
//		//
//		// System.out.print(cliente.getO_account().getC_Cards().get(0));
//
//		// Testing deposit orderAcc
//
//		// System.out.println(cliente.getO_account().getEuros());
//		// cliente.getO_account().deposit(cliente.getO_account().getD_Cards().get(0),
//		// 1000); System.out.println(cliente.getO_account().getEuros());
//		// System.out.println(cliente.getO_account().getO_movements().get(0));
//
//		// Testing withdraw orderAcc
//
//		// new CreditCard(cliente.getO_account(), 500);
//		// System.out.println(cliente.getO_account().getEuros());
//		// System.out.println(cliente.getO_account().getC_Cards().get(0).getPlafond());
//		//
//		// cliente.getO_account().withdraw(cliente.getO_account().getC_Cards().get(0),
//		// 2001); System.out.println(cliente.getO_account().getEuros());
//		// System.out.println(cliente.getO_account().getC_Cards().get(0).getPlafond());
//
//		// Testing every movement
//
//		new CreditCard(cliente.getO_account(), 500);
//		new CreditCard(cliente1.getO_account(), 500);
//
//
//		new SavingsAccount(cliente1, 2000);
//		new PrazoAccount(cliente1, 2000, 5);
//
//		new SavingsAccount(cliente, 2000);
//		new PrazoAccount(cliente, 2000, 5);
//
//
//		System.out.println("TRANSFERS TEST\n");
//
//		System.out.print("Initial plafonds:   \n\n");
//
//		System.out.print("Cliente:   " + cliente.getO_account().getC_Cards().get(0).getPlafond());
//		System.out.print("\nCliente 1: " + cliente1.getO_account().getC_Cards().get(0).getPlafond() + "\n\n");
//
//		System.out.print("Before ----> Ordem Accounts");
//		System.out.print(" | Prazo Accounts");
//		System.out.print(" | Savings Accounts\n");
//
//		System.out.print("Cliente:        " + cliente.getO_account().getEuros() + "            "
//				+ cliente.getP_Accounts().get(0).getEuros() + "            "
//				+ cliente.getS_Accounts().get(0).getEuros());
//		System.out.print("\nCliente 1:      " + cliente1.getO_account().getEuros() + "            "
//				+ cliente1.getP_Accounts().get(0).getEuros() + "            "
//				+ cliente1.getS_Accounts().get(0).getEuros());
//
//		System.out.print("\n\n--------------------PROCESSING MOVEMENTS--------------------------------\n\n");
//
//		// Deposit to order account using debit and credit card (no difference)
//
//		// cliente.getO_account().deposit(cliente.getO_account().getD_Cards().get(0),
//		// 1000);
//		// cliente.getO_account().deposit(cliente.getO_account().getC_Cards().get(0),
//		// 1000);
//
//		// Deposit to prazo account using debit and credit card (no difference)
//
//		// cliente.getP_Accounts().get(0).deposit(cliente.getO_account().getD_Cards().get(0),
//		// 1000);
//		// cliente.getP_Accounts().get(0).deposit(cliente.getO_account().getC_Cards().get(0),
//		// 1000);
//
//		// Deposit to savings account using debit and credit card (no difference)
//
//		// cliente.getS_Accounts().get(0).deposit(cliente.getO_account().getD_Cards().get(0),
//		// 1000);
//		// cliente.getS_Accounts().get(0).deposit(cliente.getO_account().getC_Cards().get(0),
//		// 1000);
//
//		// ----------------------------------------------------------------------------------------
//
//		// Withdraw from order account using debit and credit card
//		//
//		// cliente.getO_account().withdraw(cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getO_account().withdraw(cliente.getO_account().getC_Cards().get(0),
//		// 400);
//		//
//		// Withdraw from account using debit and credit card
//		//
//		// cliente.getP_Accounts().get(0).withdraw(cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getP_Accounts().get(0).withdraw(cliente.getO_account().getC_Cards().get(0),
//		// 2000);
//		//
//		// Withdraw from savings account using debit and credit card
//		//
//		// cliente.getS_Accounts().get(0).withdraw(cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getS_Accounts().get(0).withdraw(cliente.getO_account().getC_Cards().get(0),
//		// 400);
//		//
//		// Transfer from order account
//		
//		// cliente.getO_account().transfer(cliente1.getO_account(),cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getO_account().transfer(cliente1.getO_account(),cliente.getO_account().getC_Cards().get(0),
//		// 400);
//		 
//		// cliente.getO_account().transfer(cliente1.getP_Accounts().get(0),cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getO_account().transfer(cliente1.getP_Accounts().get(0),cliente.getO_account().getC_Cards().get(0),
//		// 400);
//
//		// cliente.getO_account().transfer(cliente1.getS_Accounts().get(0),cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getO_account().transfer(cliente1.getS_Accounts().get(0),cliente.getO_account().getC_Cards().get(0),
//		// 400);
//		
//		// Transfer from prazo account
//		
//		// cliente.getP_Accounts().get(0).transfer(cliente1.getO_account(),cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getP_Accounts().get(0).transfer(cliente1.getO_account(),cliente.getO_account().getC_Cards().get(0),
//		// 400);
//		 
//		// cliente.getP_Accounts().get(0).transfer(cliente1.getP_Accounts().get(0),cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getP_Accounts().get(0).transfer(cliente1.getP_Accounts().get(0),cliente.getO_account().getC_Cards().get(0),
//		// 400);
//
//		// cliente.getP_Accounts().get(0).transfer(cliente1.getS_Accounts().get(0),cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getP_Accounts().get(0).transfer(cliente1.getS_Accounts().get(0),cliente.getO_account().getC_Cards().get(0),
//		// 400);
//		
//		// Transfer from savings account
//
//		// cliente.getS_Accounts().get(0).transfer(cliente1.getO_account(),cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getS_Accounts().get(0).transfer(cliente1.getO_account(),cliente.getO_account().getC_Cards().get(0),
//		// 400);
//
//		// cliente.getS_Accounts().get(0).transfer(cliente1.getP_Accounts().get(0),cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getS_Accounts().get(0).transfer(cliente1.getP_Accounts().get(0),cliente.getO_account().getC_Cards().get(0),
//		// 400);
//
//		// cliente.getS_Accounts().get(0).transfer(cliente1.getS_Accounts().get(0),cliente.getO_account().getD_Cards().get(0),
//		// 2000);
//		// cliente.getS_Accounts().get(0).transfer(cliente1.getS_Accounts().get(0),cliente.getO_account().getC_Cards().get(0),
//		// 400);
//		
//		// cliente.getS_Accounts().get(0).transfer(cliente.getS_Accounts().get(0),cliente.getO_account().getD_Cards().get(0),
//		// 1000);
//		// cliente.getS_Accounts().get(0).transfer(cliente.getS_Accounts().get(0),cliente.getO_account().getC_Cards().get(0),
//		// 2400);
//		
//		System.out.print("Final plafonds:   \n\n");
//
//		System.out.print("Cliente:   " + cliente.getO_account().getC_Cards().get(0).getPlafond());
//		System.out.print("\nCliente 1: " + cliente1.getO_account().getC_Cards().get(0).getPlafond() + "\n\n");
//
//		System.out.print("After ----> Ordem Accounts");
//		System.out.print(" | Prazo Accounts");
//		System.out.print(" | Savings Accounts\n");
//
//		System.out.print("Cliente:        " + cliente.getO_account().getEuros() + "            "
//				+ cliente.getP_Accounts().get(0).getEuros() + "            " + cliente.getS_Accounts().get(0).getEuros());
//		System.out.print("\nCliente 1:      " + cliente1.getO_account().getEuros() + "            "
//				+ cliente1.getP_Accounts().get(0).getEuros() + "            " + cliente1.getS_Accounts().get(0).getEuros()+"\n\n");
//
//		
//		//Testing registry
//		
//		// System.out.println(cliente.getO_account().getO_movements());
//		// System.out.println(cliente.getP_Accounts().get(0).getP_movements());
//		// System.out.println(cliente.getS_Accounts().get(0).getS_movements()+"\n\n");
//		//
//		// cliente.getO_account().deposit(cliente.getO_account().getC_Cards().get(0),
//		// 1000);
//		// cliente.getS_Accounts().get(0).transfer(cliente1.getO_account(),cliente.getO_account().getC_Cards().get(0),
//		// 1000);
//		// cliente.getO_account().withdraw(cliente.getO_account().getC_Cards().get(0),
//		// 2500);
//		//
//		// System.out.println(cliente.getO_account().getO_movements());
//		// System.out.println(cliente.getP_Accounts().get(0).getP_movements());
//		// System.out.println(cliente.getS_Accounts().get(0).getS_movements());
//	
//		
			
		// TESTING PERIOD - PRAZO

		Client cliente2 = new Client(names[2], numberCC[2], adress[2], phone[2], emails[2], profession[2]);
		Client cliente3 = new Client(names[3], numberCC[3], adress[3], phone[3], emails[3], profession[3]);
		
		DebitCard client2DC=cliente2.getO_account().getD_Cards().get(0);
		CreditCard client2CC = new CreditCard(cliente2.getO_account(), 500);
		OrderAccount client2OA=cliente2.getO_account();
		SavingsAccount client2SA = new SavingsAccount(cliente2, 2000);
		PrazoAccount client2PA = new PrazoAccount(cliente2, 2000, 5);

		DebitCard client3DC=cliente3.getO_account().getD_Cards().get(0);
		CreditCard client3CC = new CreditCard(cliente3.getO_account(), 500);
		OrderAccount client3OA=cliente3.getO_account();
		SavingsAccount client3SA = new SavingsAccount(cliente3, 2000);
		PrazoAccount client3PA = new PrazoAccount(cliente3, 2000, 4);
		
		System.out.println("PERIODS TEST");

		System.out.println("\nBefore time jump-----------------"+LocalDate.now()+"\n");

		System.out.println("Client2 order account(eur) = "+client2OA.getEuros());
		System.out.println("Client2 prazo account(eur) = "+client2PA.getEuros()+"\n");
		
		System.out.println("Client3 order account(eur) = "+client3OA.getEuros());
		System.out.println("Client3 prazo account(eur) = "+client3PA.getEuros());

//		client2OA.transfer(client3OA, client2DC, 1000);
//		System.out.println("\nTransfer registry - "+client2OA.getO_movements().get(1));

		LocalDate advance = Period.advancePeriod(1900);
		
//		client3OA.transfer(client2OA, client3DC, 1001);
//		System.out.println("\nTransfer registry - "+client3OA.getO_movements().get(1));
//		
//		client3PA.transfer(client3OA, client3DC, 1001);
//		System.out.println("\nTransfer registry - "+client3PA.getP_movements().get(1));
		
		System.out.print("\n--------------------PROCESSING MOVEMENTS--------------------------------\n");
		
		
		System.out.println("\nAfter time jump-----------------"+advance+"\n");

		System.out.println("Client2 order account(eur) = "+client2OA.getEuros());
		System.out.println("Client2 prazo account(eur) = "+client2PA.getEuros()+"\n");
		
		System.out.println("Client3 order account(eur) = "+client3OA.getEuros());
		System.out.println("Client3 prazo account(eur) = "+client3PA.getEuros()+"\n");
		
	}

}
