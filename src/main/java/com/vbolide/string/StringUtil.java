package com.vbolide.string;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Calendar;

import com.vbolide.exception.InvalidParameterException;
import com.vbolide.validation.ValidationUtil;

/**
 * Utility class for {@linkplain String} manipulation and handful of utility methods.
 * @author Vamshi Byagari
 */
public class StringUtil {

	private static final String ENGLISH_UPPERCASE_CHARACTERS_WITH_NUMBERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	private StringUtil() {}


	/**
	 * {@linkplainplain CharSequence} [allowed implementations {@linkplain String}, {@linkplain StringBuilder}, {@linkplain StringBuffer}] length based on every byte in the string using {@linkplain Charset}
	 * @param input - input string.
	 * @param charset - sub class of {@linkplain Charset}, if none passed then uses {@linkplain StandardCharsets#UTF_8}.
	 * @return length of string.
	 */
	public static int getLength(CharSequence input, Charset charset) throws InvalidParameterException{
		if(input instanceof String || input instanceof StringBuilder || input instanceof StringBuffer) {
			String stringValue = input.toString();
			if(!ValidationUtil.isValidString(stringValue)) {
				throw new InvalidParameterException("input parameter is invalid");
			}
			return stringValue.getBytes(charset == null ? StandardCharsets.UTF_8 : charset).length;
		}else {
			throw new InvalidParameterException("input implementation is not allowed");
		}
	}


	/**
	 * Determines the output of {@linkplain StringUtil#toAlternatingCase()}
     * <ul>
     * <li>{@linkplain #EVEN_INDEX_CHARACTER_UPPER_CASE}<br></li>
     * <li>{@linkplain #ODD_INDEX_CHARACTER_UPPER_CASE}<br></li>
     *</ul>
	 * @author Vamshi Byagari
	 */
	public enum AlternatingCaseEnum{
		/**
		 * each word even index characters converted to upper-case and odd characters converted to lower-case.
		 */
		EVEN_INDEX_CHARACTER_UPPER_CASE,

		/**
		 * each word even index characters converted to lower-case and odd characters converted to upper-case.
		 */
		ODD_INDEX_CHARACTER_UPPER_CASE
	}

	/**
	 * converts the input string to alternating case.
	 * @param input - an instance of {@linkplain String}
	 * @param alternatinCaseEnum - any one value from {@linkplain AlternatingCaseEnum}
	 * @return alternating case string.
	 */
	public static String toAlternatingCase(String input, AlternatingCaseEnum alternatinCaseEnum) throws InvalidParameterException{
		if(!ValidationUtil.isValidString(input) || alternatinCaseEnum == null) {
			throw new InvalidParameterException("input parameter is invalid");
		}
		StringBuilder result = new StringBuilder();
		for (String line : input.split(System.lineSeparator())) {
			String[] words = line.split("\\s");
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if(!word.isEmpty()) {
					for (int j = 0; j < word.length(); j++) {
						boolean isEvenIdex = j%2 == 0;
						if(AlternatingCaseEnum.EVEN_INDEX_CHARACTER_UPPER_CASE == alternatinCaseEnum) {
							result.append(isEvenIdex ? Character.toUpperCase(word.charAt(j)) : Character.toLowerCase(word.charAt(j)));
						}else {
							result.append(isEvenIdex ? Character.toLowerCase(word.charAt(j)) : Character.toUpperCase(word.charAt(j)));
						}
					}
				}
				if (result.length() != words.length)
					result.append(" ");
			}
			result.append(System.lineSeparator());
		}
		return result.toString();
	}

	/**
	 * converts the input string to sentence case (each paragraph first word first character capitalized).
	 * @param input - an instance of {@linkplain String}
	 * @return sentence case string.
	 */
	public static String toSentenceCase(String input) throws InvalidParameterException{
		if(!ValidationUtil.isValidString(input)) {
			throw new InvalidParameterException("input parameter is invalid");
		}
		StringBuilder result = new StringBuilder();
		for (String line : input.split(System.lineSeparator())) {
			String[] words = line.split("\\s");
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if(!word.isEmpty()) {
					if(i == 0) {
						result.append(Character.toUpperCase(word.charAt(0)));
						result.append(word.substring(1).toLowerCase());
					}else {
						result.append(word.toLowerCase());
					}
				}
				if (result.length() != words.length)
					result.append(" ");
			}
			result.append(System.lineSeparator());
		}
		return result.toString();
	}

	/**
	 * converts the input string to title case (each word first character capitalized).
	 * @param input - an instance of {@linkplain String}
	 * @return camel case string.
	 */
	public static String toTitleCase(String input) throws InvalidParameterException{
		return toCamelCase(input);
	}

	/**
	 * converts the input string to capitalize case (each word first character capitalized).
	 * @param input - an instance of {@linkplain String}
	 * @return camel case string.
	 */
	public static String toCapitalizeCase(String input) throws InvalidParameterException{
		return toCamelCase(input);
	}

	/**
	 * converts the input string to camel case (each word first character capitalized).
	 * @param input - an instance of {@linkplain String}
	 * @return camel case string.
	 */
	public static String toCamelCase(String input) throws InvalidParameterException{
		if(!ValidationUtil.isValidString(input)) {
			throw new InvalidParameterException("input parameter is invalid");
		}
		StringBuilder result = new StringBuilder();
		for (String line : input.split(System.lineSeparator())) {
			for (final String word : line.split("\\s")) {
				if (!word.isEmpty()) {
					result.append(Character.toUpperCase(word.charAt(0)));
					result.append(word.substring(1).toLowerCase());
				}
				if (result.length() != input.length())
					result.append(" ");
			}
			result.append(System.lineSeparator());
		}
		return result.toString();
	}


	/**
	 * formats the input number based on the precision provided.
	 * @param input - number to format.
	 * @param precision - to what precision number should be formatted. if the precision is greater than the decimal points then 0 will be appended to it reach the precision number.
	 * @return an instance of {@linkplain String} that contains number with formatted based on precision provided.
	 */
	public static String formatToDecimals(double input, int precision) {
		if(input == (long)input) {
			return String.format("%s", (long)input);
		}else {
			StringBuilder sb = new StringBuilder();
			sb.append("%.");
			sb.append(precision);
			sb.append("f");
			return String.format(sb.toString(), input);
		}
	}


	/**
	 * converts {@linkplain String} to {@linkplain Base64} encoded string.
	 * @param input - an instance of {@linkplain String}
	 * @param charset - any sub class of {@linkplain Charset}, if none passed then uses {@linkplain StandardCharsets#UTF_8}.
	 * @return {@linkplain Base64} encoded string.
	 */
	public static String encodeState(String input, Charset charset) throws InvalidParameterException{
		if(!ValidationUtil.isValidString(input)) {
			throw new InvalidParameterException("input parameter is invalid");
		}
		return new String(Base64.getEncoder().encode(input.getBytes(charset == null ? StandardCharsets.UTF_8 : charset)));
	}

	/**
	 * converts {@linkplain String} to {@linkplain Base64} decoded string.
	 * @param input - an instance of {@linkplain String}
	 * @param charset - any sub class of {@linkplain Charset}, if none passed then uses {@linkplain StandardCharsets#UTF_8}.
	 * @return {@linkplain Base64} decoded string.
	 */
	public static String decodedState(String input, Charset charset) throws InvalidParameterException{
		if(!ValidationUtil.isValidString(input)) {
			throw new InvalidParameterException("input parameter is invalid");
		}
		return new String(Base64.getDecoder().decode(input.getBytes(charset == null ? StandardCharsets.UTF_8 : charset)));
	}


    /**
     * Converts the Current Instance Nano-time to String.
     * @return resultant {@linkplain String}
     */
	public static String getAlphaNumericStringFromNanoTime() {
		String nanoTime = String.valueOf(System.nanoTime());
		StringBuilder result = new StringBuilder();
		for(int i=0; i<nanoTime.length(); i=i+2) {
			String str1 = nanoTime.substring(i, i+2);
			int num1 = Integer.parseInt(str1);
			if(num1>=36) {
				for(int j=0; j<2; j++) {
					String str2 = str1.substring(j, j+1);
					int num2 = Integer.parseInt(str2);
					result.append(ENGLISH_UPPERCASE_CHARACTERS_WITH_NUMBERS.charAt(num2));
				}
			}else {
				result.append(ENGLISH_UPPERCASE_CHARACTERS_WITH_NUMBERS.charAt(num1));
			}
		}
		return result.toString().trim();
	}


    /**
     * Determines the output of {@linkplain StringUtil#getStringFromDate()}.
     * <ul>
     * <li>{@linkplain #UPTO_MONTH}<br></li>
     * <li>{@linkplain #UPTO_DATE}<br></li>
     * <li>{@linkplain #UPTO_HOUR}<br></li>
     * <li>{@linkplain #UPTO_MINUTE}<br></li>
     * <li>{@linkplain #UPTO_SECOND}<br></li>
     * <li>{@linkplain #UPTO_MILLISECOND}<br></li>
     * </ul>
     * 
	 * @author Vamshi Byagari
	 */
	public enum StringFromDateLevel{
		/**
		 * Determines the output of {@linkplain StringUtil#getStringFromDate()} to include YEAR and MONTH
		 */
		UPTO_MONTH,
		
		/**
		 * Determines the output of {@linkplain StringUtil#getStringFromDate()} to include YEAR, MONTH and DATE
		 */
		UPTO_DATE,
		
		/**
		 * Determines the output of {@linkplain StringUtil#getStringFromDate()} to include YEAR, MONTH, DATE and HOUR
		 */
		UPTO_HOUR,
		
		/**
		 * Determines the output of {@linkplain StringUtil#getStringFromDate()} to include YEAR, MONTH, DATE, HOUR and MINUTE
		 */
		UPTO_MINUTE,
		
		/**
		 * Determines the output of {@linkplain StringUtil#getStringFromDate()} to include YEAR, MONTH, DATE, HOUR, MINUTE and SECOND
		 */
		UPTO_SECOND,
		
		/**
		 * Determines the output of {@linkplain StringUtil#getStringFromDate()} to include YEAR, MONTH, DATE, HOUR, MINUTE, SECOND and MILLISECOND
		 */
		UPTO_MILLISECOND
	}

	/**
	 * This method is used to get the string representation of the current date and time including from year to seconds.
	 * @param level - any one value from {@linkplain StringFromDateLevel}
	 * @return string form of date, based on the input argument.
	 */
	public static String getStringFromDate(StringFromDateLevel stringFromDateLevel) {

		Calendar calendar = Calendar.getInstance();
		switch(stringFromDateLevel) {
		case UPTO_MONTH: return String.format("%s%s", getPrexifedStringFromDateVale(calendar.get(Calendar.YEAR), 4),
											getPrexifedStringFromDateVale(calendar.get(Calendar.MONTH)+1, 2));
		
		case UPTO_DATE: return String.format("%s%s%s", getPrexifedStringFromDateVale(calendar.get(Calendar.YEAR), 4),
												getPrexifedStringFromDateVale(calendar.get(Calendar.MONTH)+1, 2),
												getPrexifedStringFromDateVale(calendar.get(Calendar.DATE), 2));
		
		case UPTO_HOUR: return String.format("%s%s%s%s", getPrexifedStringFromDateVale(calendar.get(Calendar.YEAR), 4),
												getPrexifedStringFromDateVale(calendar.get(Calendar.MONTH)+1, 2),
												getPrexifedStringFromDateVale(calendar.get(Calendar.DATE), 2),
												getPrexifedStringFromDateVale(calendar.get(Calendar.HOUR), 2));
		
		case UPTO_MINUTE: return String.format("%s%s%s%s%s", getPrexifedStringFromDateVale(calendar.get(Calendar.YEAR), 4),
													getPrexifedStringFromDateVale(calendar.get(Calendar.MONTH)+1, 2),
													getPrexifedStringFromDateVale(calendar.get(Calendar.DATE), 2),
													getPrexifedStringFromDateVale(calendar.get(Calendar.HOUR), 2),
													getPrexifedStringFromDateVale(calendar.get(Calendar.MINUTE), 2));
			
		case UPTO_SECOND: return String.format("%s%s%s%s%s%s", getPrexifedStringFromDateVale(calendar.get(Calendar.YEAR), 4),
													getPrexifedStringFromDateVale(calendar.get(Calendar.MONTH)+1, 2),
													getPrexifedStringFromDateVale(calendar.get(Calendar.DATE), 2),
													getPrexifedStringFromDateVale(calendar.get(Calendar.HOUR), 2),
													getPrexifedStringFromDateVale(calendar.get(Calendar.MINUTE), 2),
													getPrexifedStringFromDateVale(calendar.get(Calendar.SECOND), 2));
		
		case UPTO_MILLISECOND: return String.format("%s%s%s%s%s%s%s", getPrexifedStringFromDateVale(calendar.get(Calendar.YEAR), 4),
														getPrexifedStringFromDateVale(calendar.get(Calendar.MONTH)+1, 2),
														getPrexifedStringFromDateVale(calendar.get(Calendar.DATE), 2),
														getPrexifedStringFromDateVale(calendar.get(Calendar.HOUR), 2),
														getPrexifedStringFromDateVale(calendar.get(Calendar.MINUTE), 2),
														getPrexifedStringFromDateVale(calendar.get(Calendar.SECOND), 2),
														getPrexifedStringFromDateVale(calendar.get(Calendar.MILLISECOND), 3));
		default: return String.format("%s%s%s", getPrexifedStringFromDateVale(calendar.get(Calendar.YEAR), 4),
				getPrexifedStringFromDateVale(calendar.get(Calendar.MONTH)+1, 2),
				getPrexifedStringFromDateVale(calendar.get(Calendar.DATE), 2));
		}
	}

	/**
	 * This method will generate the string by appending 0 to input argument.
	 * @param value - to which 0's has to be appended.
	 * @param length - the max length of the string.
	 * @return string value appended by 0's.
	 */
	private static String getPrexifedStringFromDateVale(int value, int length) {
		String string = String.valueOf(value);
		if(string.length()==length) {
			return string;
		}else {
			String temp = "";
			for(int i=1; i<length; i++)
				temp = temp+"0";
			return temp+string;
		}
	}


}