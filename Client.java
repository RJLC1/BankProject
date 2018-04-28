package mainProj;

import java.util.ArrayList;

import utilMeth.ClientVal;

public class Client {

	public static final int MAX_PHONENUMBERS_CLIENT = 2;
	public static final int MAX_EMAILS_CLIENT = 2;
	public static int id = 0;

	// Fields

	private final int number = ++id;
	private String name;
	private int numberCC;
	private String address;
	private int[] phone = new int[MAX_PHONENUMBERS_CLIENT];
	private String[] emails = new String[MAX_EMAILS_CLIENT];
	private String profession;
	private OrderAccount o_Account;
	private ArrayList<PrazoAccount> p_Accounts = new ArrayList<PrazoAccount>();
	private ArrayList<SavingsAccount> s_Accounts = new ArrayList<SavingsAccount>();

	// Constructor

	public Client(String name, int numberCC, String address, int[] phone, String[] emails, String profession) {

		setName(name);
		setNumberCC(numberCC);
		setAddress(address);
		setPhone(phone);
		setEmails(emails);
		setProfession(profession);
		this.o_Account=new OrderAccount(this, 2000);
		Period.getClients().add(this);

	}

	// Getters

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public int getNumberCC() {
		return numberCC;
	}

	public String getAddress() {
		return address;
	}

	public int[] getPhone() {
		return phone;
	}

	public String[] getEmails() {
		return emails;
	}

	public String getProfession() {
		return profession;
	}

	public OrderAccount getO_account() {
		return o_Account;
	}

	public ArrayList<PrazoAccount> getP_Accounts() {
		return p_Accounts;
	}

	public ArrayList<SavingsAccount> getS_Accounts() {
		return s_Accounts;
	}

	// Setters

	public void setName(String name) {

		if (ClientVal.validateName(name))
			this.name = name;
		else
			System.out.println("Invalid name - Only lower and upper " + "case alphabet characters are allowed");

	}

	public void setNumberCC(int numberCC) {

		Integer number = new Integer(numberCC);
		if (ClientVal.validateCCNumber(Integer.toString(number)))
			this.numberCC = numberCC;
		else
			System.out.println("Invalid CC number - only eight 0-9 numbers allowed ");

	}

	public void setAddress(String address) {

		if (ClientVal.validateAddress(address))
			this.address = address;
		else
			System.out.println("Invalid address - lower and upper "
					+ "case alphabet characters allowed.\n0-9 numbers allowed\nOther symbols allowed: . - º ,");
	}

	public void setPhone(int[] phone) {

		if (phone.length > Client.MAX_PHONENUMBERS_CLIENT) {
			System.out.println("PHONE NUMBER -  Max phone numbers per client is 2");
			return;
		}

		if (phone.length == 1) {

			Integer a = new Integer(phone[0]);
			String[] number = { Integer.toString(a) };

			if (ClientVal.validatePhone(number)) {
				this.phone = phone;
				return;
			} else {
				System.out.println(
						"Invalid phone number at phone[0] " + "- A phonenumber must be a 9 decimal-based number");
				return;
			}

		}

		if (phone.length == 2) {

			Integer a = new Integer(phone[0]);
			Integer b = new Integer(phone[1]);

			String[] number = { Integer.toString(a), Integer.toString(b) };

			if (ClientVal.validatePhone(number)) {
				this.phone = phone;
				return;
			} else {
				System.out.println("Invalid phone number at phone[0] or phone[1] "
						+ "- A phonenumber must be a 9 decimal-based number");
				return;
			}

		}

	}

	public void setEmails(String[] emails) {

		if (emails.length > Client.MAX_EMAILS_CLIENT) {

			System.out.println("EMAIL - Max emails per client is 2");
			return;

		}

		if (ClientVal.validateEmails(emails))
			this.emails = emails;

	}

	public void setProfession(String profession) {

		if (ClientVal.validateProfession(profession))
			this.profession = profession;
		else
			System.out.println("Invalid profession - lower and upper "
					+ "case alphabet characters allowed\nOther symbols allowed: . - ,");
	}

	public void setO_account(OrderAccount o_Account) {

		if (this.o_Account != null) {

			System.out.println(
					"INVALID - CLIENT - This client already has a order account! - He can only have 1 order account");
			return;
		}
		this.o_Account = o_Account;
	}

	public void setP_accounts(ArrayList<PrazoAccount> p_Accounts) {
		this.p_Accounts = p_Accounts;
	}

	public void setS_accounts(ArrayList<SavingsAccount> s_Accounts) {
		this.s_Accounts = s_Accounts;
	}

	//toString
	
	public String toString(){
		
		String message = "\nCLIENT INFO: \n" + "Name:               " + this.name + "\nNumber CC:          " + this.numberCC + "\nAddress:            "
				+ this.address + "\nMain phone:         " + this.phone[0] + "\nMain email:         " + this.emails[0] + "\nProfession:         "
				+ this.profession;
		return message;
				
	}
	
	
}
