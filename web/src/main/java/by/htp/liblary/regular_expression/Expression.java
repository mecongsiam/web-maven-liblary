package by.htp.liblary.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
	private static final String EMAIL_VALIDATION_REG = "([.[^@\\s\u002B]]+)@([.[^@\\s]]+)\\.([a-z]+){2,33}";
	private static final String PHONE_VALIDATION = "\\d{7}";
	private static final String LOGIN_VALIDATION = "([a-zA-Z0-9А-Яа-я]+){2,20}";
	private static final String PASSWORD_VALIDATION = ".{2,30}";
	private static final String NAME_VALIDATION = "([a-zA-Z0-9А-Яа-я]+){2,20}";
	private static final String SURNAME_VALIDATION = "([a-zA-Z0-9А-Яа-я]+){2,20}";
	private static final String ADRESS_VALIDATION = "([a-zA-Z0-9А-Яа-я]+){2,35}";

	public static boolean emailValidation(String email) {

		Pattern p = Pattern.compile(EMAIL_VALIDATION_REG);
		Matcher m = p.matcher(email);
		if (m.matches()) {
			return false;
		}
		return true;

	}

	public static boolean phoneValidation(String phone) {
		Pattern p = Pattern.compile(PHONE_VALIDATION);
		Matcher m = p.matcher(phone);
		if (m.matches()) {
			return false;
		}
		return true;

	}

	public static boolean loginValidation(String login) {
		Pattern p = Pattern.compile(LOGIN_VALIDATION);
		Matcher m = p.matcher(login);
		if (m.matches()) {
			return false;
		}
		return true;

	}

	public static boolean passwordValidation(String password) {
		Pattern p = Pattern.compile(PASSWORD_VALIDATION);
		Matcher m = p.matcher(password);
		if (m.matches()) {
			return false;
		}
		return true;

	}

	public static boolean nameValidation(String name) {
		Pattern p = Pattern.compile(NAME_VALIDATION);
		Matcher m = p.matcher(name);
		if (m.matches()) {
			return false;
		}
		return true;

	}

	public static boolean surnameValidation(String surname) {
		Pattern p = Pattern.compile(SURNAME_VALIDATION);
		Matcher m = p.matcher(surname);
		if (m.matches()) {
			return false;
		}
		return true;

	}

	public static boolean adressValidation(String adress) {
		Pattern p = Pattern.compile(ADRESS_VALIDATION);
		Matcher m = p.matcher(adress);
		if (m.matches()) {
			return false;
		}
		return true;

	}

}
