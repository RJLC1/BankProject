package utilMeth;

public class ClientVal {

	// VALIDATE CLIENT'S NAME
	// Only lower or upper alphabet chars OR space char.
	// No accents considered

	public static boolean validateName(String name) {

		char[] nameChars = name.toCharArray();
		for (char c : nameChars) {

			if (c >= 'a' && c <= 'z')
				continue;

			else if (c >= 'A' && c <= 'Z')
				continue;

			else if (c == ' ')
				continue;

			return false;
		}

		return true;
	}

	// VALIDATE CLIENT'S "CARTÃO CIDADÃO" NUMBER
	// 8 decimal-based numbers

	public static boolean validateCCNumber(String number) {

		char[] numberChars = number.toCharArray();

		if (numberChars.length != 8)
			return false;

		for (char c : numberChars) {

			if (c >= '0' && c <= '9')
				continue;

			return false;
		}

		return true;
	}

	// VALIDATE CLIENT'S ADDRESS
	// Lower or upper alphabet chars.
	// Decimal chars
	// Spaces, ".", "-", "º" or "," allowed
	// No accents considered

	public static boolean validateAddress(String address) {

		char[] nameChars = address.toCharArray();
		for (char c : nameChars) {

			if (c >= 'a' && c <= 'z')
				continue;

			else if (c >= 'A' && c <= 'Z')
				continue;

			else if (c >= '0' && c <= '9')
				continue;

			else if (c == ' ' || c == '.' || c == '-' || c == ',' || c == 'º')
				continue;

			return false;
		}

		return true;
	}

	// VALIDATE CLIENT'S PHONE NUMBERS
	// 9 decimal-based numbers
	// Max phone numbers per client is 2

	public static boolean validatePhone(String[] phone) {

		if (phone.length == 1) {

			char[] numberChars = phone[0].toCharArray();

			if (numberChars.length != 9)
				return false;

			for (char c : numberChars) {

				if (c >= '0' && c <= '9')
					continue;

				return false;
			}

		}

		if (phone.length == 2) {

			char[] numberChars = phone[0].toCharArray();
			char[] numberChars2 = phone[1].toCharArray();

			if (numberChars.length != 9 || numberChars2.length != 9)
				return false;

			for (char c : numberChars) {

				if (c >= '0' && c <= '9')
					continue;

				return false;
			}

			for (char c : numberChars2) {

				if (c >= '0' && c <= '9')
					continue;

				return false;
			}

		}

		return true;
	}

	// VALIDATE CLIENT'S EMAILS
	// Basic validation where the string needs to contain only 1 "@" and only 1 "." (after @) - EX: chars@fe.up.pt is not allowed
	// "@" can't be 1st char and "." can't be the 1st next char after @
	// "." can't be the last char
	// "_" symbol only allowed until "@"'s indexnumber
	// Decimal and lower case English alphabet chars allowed
	// Max emails per client is 2

	public static boolean validateEmails(String[] emails) {

		if (emails.length == 1) {

			if (!emails[0].contains("@") || !emails[0].contains(".")) {

				System.out.println("Email needs to contain 1 @ and 1 . symbol");
				return false;
			}

			if (emails[0].indexOf('@', emails[0].indexOf('@') + 1) != -1) {

				System.out.println("More then one @ symbol in email is not allowed");
				return false;
			}
			
			int i = emails[0].indexOf('.',emails[0].indexOf('@') +1 );
			
			if ( emails[0].indexOf('.',i +1) != -1 )  {

				System.out.println("More then one . symbol after @ is not allowed");
				return false;
			}
			
			if (i <= (emails[0].indexOf('@') + 1)) {

				System.out.println("Email - At least 1 char must be between the @ and . symbols "
						+ "and the @ symbol can't be in front of the last . symbol");
				return false;

			}
			
			if(emails[0].indexOf('_', emails[0].indexOf('@') + 1) != -1) {
				
				System.out.println("Email - Symbol _ can't be after the @ symbol ");
				return false;
				
			}

			char[] numberChars = emails[0].toCharArray();

			if (numberChars[0] == '@' || numberChars[emails[0].length() - 1] == '.') {

				System.out.println("Email - @ can't be the first symbol and . can't be the last");
				return false;

			}

			for (char c : numberChars) {

				if (c >= '0' && c <= '9')
					continue;

				if (c >= 'a' && c <= 'z')
					continue;

				if (c == '@' || c == '.' || c=='_')
					continue;
				
				System.out.println("Email - unautharized character");
				return false;
			}

		}
		
		if (emails.length == 2) {

			for (int i = 0; i < emails.length; i++) {

				if (!emails[i].contains("@") || !emails[i].contains(".")) {

					System.out.println("Email needs to contain 1 @ and 1 . symbol");
					return false;
				}

				if (emails[i].indexOf('@', emails[i].indexOf('@') + 1) != -1) {

					System.out.println("More then one @ symbol in email is not allowed");
					return false;
				}
				
				int j = emails[i].indexOf('.',emails[i].indexOf('@') +1 );
				
				if ( emails[i].indexOf('.',j +1) != -1 )  {

					System.out.println("More then one . symbol after @ is not allowed");
					return false;
				}
				
				if (j <= (emails[i].indexOf('@') + 1)) {

					System.out.println("Email - At least 1 char must be between the @ and . symbols "
							+ "and the @ symbol can't be in front of the last . symbol");
					return false;

				}
				
				if(emails[i].indexOf('_', emails[i].indexOf('@') + 1) != -1) {
					
					System.out.println("Email - Symbol _ can't be after the @ symbol ");
					return false;
					
				}
			}
			
			char[] numberChars = emails[0].toCharArray();   
			char[] numberChars2 = emails[1].toCharArray();


			if (numberChars[0] == '@' || numberChars[emails[0].length() - 1] == '.') {

				System.out.println("Email - @ can't be the first symbol and . can't be the last");
				return false;

			}
			
			if (numberChars2[0] == '@' || numberChars2[emails[1].length() - 1] == '.') {

				System.out.println("Email - @ can't be the first symbol and . can't be the last");
				return false;

			}

			for (char c : numberChars) {

				if (c >= '0' && c <= '9')
					continue;

				if (c >= 'a' && c <= 'z')
					continue;

				if (c == '@' || c == '.' || c=='_')
					continue;
				
				System.out.println("EMAIL - invalid characters - "
						+ "Only lower case alphabet, numbers, _, @ and . symbols are allowed");
				return false;
			}
			
			for (char c : numberChars2) {

				if (c >= '0' && c <= '9')
					continue;

				if (c >= 'a' && c <= 'z')
					continue;

				if (c == '@' || c == '.' || c=='_')
					continue;
				
				System.out.println("EMAIL - invalid characters - "
						+ "Only lower case alphabet, numbers, _, @ and . symbols are allowed");
				return false;
			}

		}

		return true;
	}
	
	
	// VALIDATE CLIENT'S ADDRESS
	// Lower or upper alphabet chars.
	// Spaces, ".", "-" or "," allowed
	// No accents considered
	
	public static boolean validateProfession(String profession) {

		char[] nameChars = profession.toCharArray();

		for (char c : nameChars) {

			if (c >= 'a' && c <= 'z')
				continue;

			else if (c >= 'A' && c <= 'Z')
				continue;

			else if (c == ' ' || c == '.' || c == '-' || c == ',')
				continue;
			
			
			return false;
		}

		return true;

	}

}