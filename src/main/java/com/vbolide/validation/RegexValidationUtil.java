package com.vbolide.validation;

import java.util.regex.Pattern;

/**
 * Utility class for commonly used Regular Expression validation.
 * 
 * @author Vamshi Byagari
 */
public class RegexValidationUtil {

	/**
	 * contains most commonly used regular expressions.
	 * 
     * <ul>
     * <li>{@linkplain Regex#EMAIL_REGEX}<br></li>
     * <li>{@linkplain Regex#WHITE_SPACE_REGEX}<br></li>
     * <li>{@linkplain Regex#WHITE_SPACE_AND_OTHER_REGEX}<br></li>
     * <li>{@linkplain Regex#LOWERCASE_REGEX}<br></li>
     * <li>{@linkplain Regex#UPPERCASE_REGEX}<br></li>
     * <li>{@linkplain Regex#NUMERIC_LOWECASE_REGEX}<br></li>
     * <li>{@linkplain Regex#NUMERIC_UPPERCASE_REGEX}<br></li>
     * <li>{@linkplain Regex#APLHA_NUMERIC_REGEX}<br></li>
     * <li>{@linkplain Regex#INDIAN_MOBILE_REGEX}<br></li>
     * <li>{@linkplain Regex#NUMERIC_REGEX}<br></li>
     * </ul>
     * 
	 * @author Vamshi Byagari
	 */
	public enum Regex{

		/**
		 * {@linkplain RegexValidationUtil#isValid} uses email validation regular expression pattern
		 */
		EMAIL_REGEX,
		
		/**
		 * {@linkplain RegexValidationUtil#isValid} uses white space validation regular expression pattern
		 */
		WHITE_SPACE_REGEX,
		
		/**
		 * {@linkplain RegexValidationUtil#isValid} uses white space, tab, new line, carriage return and form feed validation regular expression pattern
		 */
		WHITE_SPACE_AND_OTHER_REGEX,
		
		/**
		 * {@linkplain RegexValidationUtil#isValid} uses lower-case characters validation regular expression pattern
		 */
		LOWERCASE_REGEX,
		
		/**
		 * {@linkplain RegexValidationUtil#isValid} uses upper-case characters validation regular expression pattern
		 */
		UPPERCASE_REGEX,
		
		/**
		 * {@linkplain RegexValidationUtil#isValid} uses numeric and lower-case characters validation regular expression pattern
		 */
		NUMERIC_LOWECASE_REGEX,
		
		/**
		 * {@linkplain RegexValidationUtil#isValid} uses numeric and upper-case characters validation regular expression pattern
		 */
		NUMERIC_UPPERCASE_REGEX,
		
		/**
		 * {@linkplain RegexValidationUtil#isValid} uses alpha numeric validation regular expression pattern
		 */
		APLHA_NUMERIC_REGEX,

		/**
		 * {@linkplain RegexValidationUtil#isValid} uses indian mobile number validation regular expression pattern
		 */
		INDIAN_MOBILE_REGEX,

		/**
		 * {@linkplain RegexValidationUtil#isValid} uses number validation regular expression pattern
		 */
		NUMERIC_REGEX,
	}


	/**
	 * email validation regular expression pattern
	 */
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	/**
	 * white space validation regular expression pattern
	 */
	private static final Pattern WHITE_SPACE_PATTERN = Pattern.compile("\\s");

	/**
	 * white space, tab, new line, carriage return and form feed validation regular expression pattern
	 */
	private static final Pattern WHITE_SPACES_AND_OTHER = Pattern.compile("[ \t\n\r\f]+");

	/**
	 * lower-case characters validation regular expression pattern
	 */
	private static final Pattern LOWERCASE_PATTERN = Pattern.compile("^[a-z]*$");

	/**
	 * upper-case characters validation regular expression pattern
	 */
	private static final Pattern UPPERCASE_PATTERN = Pattern.compile("^[A-Z]*$");

	/**
	 * numeric and lower-case characters validation regular expression pattern
	 */
	private static final Pattern NUMBERIC_LOWERCASE_PATTERN = Pattern.compile("^[a-z0-9]*$");

	/**
	 * numeric and upper-case characters validation regular expression pattern
	 */
	private static final Pattern NUMBERIC_UPPERCASE_PATTERN = Pattern.compile("^[A-Z0-9]*$");

	/**
	 * alpha numeric validation regular expression pattern
	 */
	private static final Pattern ALPHA_NUMBERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9]*$");

	/**
	 * indian mobile number validation regular expression pattern
	 */
	private static final Pattern INDIAN_MOBILE_PATTERN = Pattern.compile("[6789]{1}[0-9]{9}");

	/**
	 * number validation regular expression pattern
	 */
	private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");


	/**
	 * validates the input {@linkplain String} with respect to {@linkplain Regex}.
	 * @param input - instance of {@linkplain String} that should be validated.
	 * @param regex - any one value from {@linkplain Regex}
	 * @return the validation results either <b>true</b> or <b>false</b>.
	 */
	public static boolean isValid(String input, Regex regex) {
		switch (regex) {
			case EMAIL_REGEX: return EMAIL_PATTERN.matcher(input).matches();
			case WHITE_SPACE_REGEX: return WHITE_SPACE_PATTERN.matcher(input).matches();
			case WHITE_SPACE_AND_OTHER_REGEX: return WHITE_SPACES_AND_OTHER.matcher(input).matches();
			case LOWERCASE_REGEX: return LOWERCASE_PATTERN.matcher(input).matches();
			case UPPERCASE_REGEX: return UPPERCASE_PATTERN.matcher(input).matches();
			case NUMERIC_LOWECASE_REGEX: return NUMBERIC_LOWERCASE_PATTERN.matcher(input).matches();
			case NUMERIC_UPPERCASE_REGEX: return NUMBERIC_UPPERCASE_PATTERN.matcher(input).matches();
			case APLHA_NUMERIC_REGEX: return ALPHA_NUMBERIC_PATTERN.matcher(input).matches();
			case NUMERIC_REGEX: return NUMERIC_PATTERN.matcher(input).matches();
			case INDIAN_MOBILE_REGEX: return INDIAN_MOBILE_PATTERN.matcher(input).matches();
			default: return false;
		}
	}

}