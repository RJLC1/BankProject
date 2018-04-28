package mainProj;

import java.time.LocalDate;
import java.util.ArrayList;

//OBJECTIVE: Advance a period; update accounts

//Parameters: current date; number of days to be advanced.

public class Period {

	// Fields

	private static ArrayList<Client> clients = new ArrayList<Client>();
	private static LocalDate advancedDate=LocalDate.now();

	// Methods

	public static LocalDate advancePeriod(int days) {

		advancedDate = advancedDate.plusDays(days);

		for (Client cliente : clients) {

			for (PrazoAccount prazo : cliente.getP_Accounts()) {

				LocalDate util = prazo.getCreation();

				while (advancedDate.compareTo(util.plusYears(1)) >= 0 && prazo.getRemaningYears() > 0) {

					cliente.getO_account().setEuros((1 + prazo.getP_Interests()) * cliente.getO_account().getEuros());
					util = util.plusYears(1);
					prazo.setRemaningYears(prazo.getRemaningYears() - 1);

				}

			}

		}
		
		return advancedDate;

	}

	// Getters

	public static ArrayList<Client> getClients() {
		return clients;
	}

	public static LocalDate getAdvancedDate() {
		return advancedDate;
	}
	
	// Setters

	public static void setClients(ArrayList<Client> clients) {
		Period.clients = clients;
	}



	public static void setAdvancedDate(LocalDate advancedDate) {
		Period.advancedDate = advancedDate;
	}

}
