package com.vbolide.validation;

import java.util.regex.Pattern;

import com.vbolide.exception.InvalidParameterException;

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
		 * {@linkplain RegexValidationUtil#isValid(String, Regex)} uses email validation regular expression pattern
		 * {@code ^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$}
		 */
		EMAIL_REGEX("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"),
		
		/**
		 * {@linkplain RegexValidationUtil#isValid(String, Regex)} uses white space validation regular expression pattern
		 * {@code \\s}
		 */
		WHITE_SPACE_REGEX("\\s"),
		
		/**
		 * {@linkplain RegexValidationUtil#isValid(String, Regex)} uses white space, tab, new line, carriage return and form feed validation regular expression pattern
		 * {@code [ \t\n\r\f]+}
		 */
		WHITE_SPACE_AND_OTHER_REGEX("[ \t\n\r\f]+"),
		
		/**
		 * {@linkplain RegexValidationUtil#isValid(String, Regex)} uses lower-case characters validation regular expression pattern
		 * {@code ^[a-z]*$}
		 */
		LOWERCASE_REGEX("^[a-z]*$"),
		
		/**
		 * {@linkplain RegexValidationUtil#isValid(String, Regex)} uses upper-case characters validation regular expression pattern
		 * {@code ^[A-Z]*$}
		 */
		UPPERCASE_REGEX("^[A-Z]*$"),
		
		/**
		 * {@linkplain RegexValidationUtil#isValid(String, Regex)} uses numeric and lower-case characters validation regular expression pattern
		 * {@code ^[a-z0-9]*$}
		 */
		NUMERIC_LOWECASE_REGEX("^[a-z0-9]*$"),
		
		/**
		 * {@linkplain RegexValidationUtil#isValid(String, Regex)} uses numeric and upper-case characters validation regular expression pattern
		 * {@code ^[A-Z0-9]*$}
		 */
		NUMERIC_UPPERCASE_REGEX("^[A-Z0-9]*$"),
		
		/**
		 * {@linkplain RegexValidationUtil#isValid(String, Regex)} uses alpha numeric validation regular expression pattern
		 * {@code ^[a-zA-Z0-9]*$}
		 */
		APLHA_NUMERIC_REGEX("^[a-zA-Z0-9]*$"),

		/**
		 * {@linkplain RegexValidationUtil#isValid(String, Regex)} uses indian mobile number validation regular expression pattern
		 * {@code [6789]{1}[0-9]{9}}
		 */
		INDIAN_MOBILE_REGEX("[6789]{1}[0-9]{9}"),

		/**
		 * {@linkplain RegexValidationUtil#isValid(String, Regex)} uses number validation regular expression pattern
		 * {@code ^[0-9]*$}
		 */
		NUMERIC_REGEX("^[0-9]*$");


		public final String label;

		private Regex(String label) {
			this.label = label;
		}
	}

	/**
	 * validates the input {@linkplain String} with respect to {@linkplain Regex}.
	 * @param input instance of {@linkplain String} that should be validated.
	 * @param regex any one value from {@linkplain Regex}
	 * @return the validation results either <b>true</b> or <b>false</b>.
	 * @throws InvalidParameterException input parameters are invalid
	 */
	public static boolean isValid(final String input, final Regex regex) throws InvalidParameterException{
		if(regex == null) {
			throw new InvalidParameterException("invalid input parameter");
		}
		return Pattern.compile(regex.label).matcher(input).matches();
	}

}