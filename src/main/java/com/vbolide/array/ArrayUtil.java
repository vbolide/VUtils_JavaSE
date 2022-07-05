package com.vbolide.array;

import com.vbolide.exception.InvalidParameterException;
import com.vbolide.validation.ValidationUtil;

/**
 * Utility class for arrays related operations
 * 
 * @author Vamshi Byagari
 */
public class ArrayUtil {

	private ArrayUtil() { }


	/**
	 * size of primitives data type arrays if non null else zero.
	 * 
	 * @param obj array of primitives data type like {@code byte}, {@code short}, {@code char}, {@code int}, {@code long}, {@code float}, {@code double} and {@code String}
	 * @return size of array
	 */
	public static int size(final Object obj) {
		if(obj == null)
			return 0;

		if(obj instanceof byte[])
			return ((byte[])obj).length;
		if(obj instanceof short[])
			return ((short[])obj).length;
		if(obj instanceof char[])
			return ((char[])obj).length;
		if(obj instanceof int[])
			return ((int[])obj).length;
		if(obj instanceof long[])
			return ((long[])obj).length;
		if(obj instanceof float[])
			return ((float[])obj).length;
		if(obj instanceof double[])
			return ((double[])obj).length;
		if(obj instanceof String[])
			return ((String[])obj).length;

		return 0;
	}

	/**
	 * checks whether the item is available in the array.
	 * 
	 * @param item item to find in array.
	 * @param arrayObject array from which item to find.
	 * @return <ul><li><b>true</b> if item exists</li><li><b>false</b> otherwise</li></ul>
	 * @throws InvalidParameterException input parameters are invalid
	 */
	public static boolean hasItem(final Object item, final Object arrayObject) throws InvalidParameterException{
		if(item == null || arrayObject == null) {
			throw new InvalidParameterException("parameter item and/or array invalid");
		}
		if(item instanceof Byte) {
			byte byteItem = (byte) item;
			if(arrayObject instanceof byte[]) {
				byte[] byteArray = (byte[]) arrayObject;
				for (byte b : byteArray) {
					if(b == byteItem) {
						return true;
					}
				}
				return false;
			}else {
				throw new InvalidParameterException("item and array are not compatible types");
			}
		}
		if(item instanceof Short) {
			short shortItem = (short) item;
			if(arrayObject instanceof short[]) {
				short[] shortArray = (short[]) arrayObject;
				for (short s : shortArray) {
					if(s == shortItem) {
						return true;
					}
				}
				return false;
			}else {
				throw new InvalidParameterException("item and array are not compatible types");
			}
		}
		if(item instanceof Character) {
			char charItem = (char) item;
			if(arrayObject instanceof char[]) {
				char[] charArray = (char[]) arrayObject;
				for (char c : charArray) {
					if(c == charItem) {
						return true;
					}
				}
				return false;
			}else {
				throw new InvalidParameterException("item and array are not compatible types");
			}
		}
		if(item instanceof Integer) {
			int intItem = (int) item;
			if(arrayObject instanceof int[]) {
				int[] intArray = (int[]) arrayObject;
				for (int i : intArray) {
					if(i == intItem) {
						return true;
					}
				}
				return false;
			}else {
				throw new InvalidParameterException("item and array are not compatible types");
			}
		}
		if(item instanceof Long) {
			long longItem = (long) item;
			if(arrayObject instanceof long[]) {
				long[] longArray = (long[]) arrayObject;
				for (long b : longArray) {
					if(b == longItem) {
						return true;
					}
				}
				return false;
			}else {
				throw new InvalidParameterException("item and array are not compatible types");
			}
		}
		if(item instanceof Float) {
			float floatItem = (float) item;
			if(arrayObject instanceof float[]) {
				float[] floatArray = (float[]) arrayObject;
				for (float b : floatArray) {
					if(b == floatItem) {
						return true;
					}
				}
				return false;
			}else {
				throw new InvalidParameterException("item and array are not compatible types");
			}
		}
		if(item instanceof Double) {
			double doubleItem = (double) item;
			if(arrayObject instanceof double[]) {
				double[] doubleArray = (double[]) arrayObject;
				for (double b : doubleArray) {
					if(b == doubleItem) {
						return true;
					}
				}
				return false;
			}else {
				throw new InvalidParameterException("item and array are not compatible types");
			}
		}
		if(item instanceof String) {
			String stringItem = (String) item;
			if(arrayObject instanceof String[]) {
				String[] stringArray = (String[]) arrayObject;
				for (String s : stringArray) {
					if(s.equals(stringItem)) {
						return true;
					}
				}
				return false;
			}else {
				throw new InvalidParameterException("item and array are not compatible types");
			}
		}
		return false;
	}

	/**
	 * Delimiters that are most commonly used to append strings, 
	 * used as a parameter for {@linkplain ArrayUtil#arrayFromParameterSeperatedString(ArrayDelimeter, String)} and
	 * {@linkplain ArrayUtil#parameterSeperatedStringFromArray(ArrayDelimeter, String...)}.
	 * 
     * <ul>
     * <li>{@linkplain #SPACE}<br></li>
     * <li>{@linkplain #COMMA}<br></li>
     * <li>{@linkplain #DOT}<br></li>
     * <li>{@linkplain #DOLLAR}<br></li>
     * <li>{@linkplain #HASH}<br></li>
     * <li>{@linkplain #AT}<br></li>
     * <li>{@linkplain #ASTERIC}<br></li>
     * <li>{@linkplain #AMPERSAND}<br></li>
     * <li>{@linkplain #UNDERSCORE}<br></li>
     * <li>{@linkplain #HYPHEN}<br></li>
     * <li>{@linkplain #PERCENTILE}<br></li>
     *</ul>
	 * @author Vamshi Byagari
	 */
	public enum ArrayDelimeter{
		/**
		 * <b>\\s</b>
		 */
		SPACE(" "),

		/**
		 * <b>,</b>
		 */
		COMMA(","),

		/**
		 * <b>.</b>
		 */
		DOT("."),

		/**
		 * <b>$</b>
		 */
		DOLLAR("$"),

		/**
		 * <b>#</b>
		 */
		HASH("#"),

		/**
		 * <b>@</b>
		 */
		AT("@"),

		/**
		 * <b>*</b>
		 */
		ASTERIC("*"),

		/**
		 * <b>&</b>
		 */
		AMPERSAND("&"),

		/**
		 * <b>_</b>
		 */
		UNDERSCORE("_"),

		/**
		 * <b>-</b>
		 */
		HYPHEN("-"),

		/**
		 * <b>%</b>
		 */
		PERCENTILE("%");

		public final String label;

		private ArrayDelimeter(String label) {
			this.label = label;
		}
	}

	/**
	 * forms a {@code String} from input array parameter using provided parameter.
	 * @param parameter used to join strings.
	 * @param inputs variable arguments of {@code String}.
	 * @return {@linkplain String} formed by appending parameter to in-between each string in array.
	 * @throws InvalidParameterException input parameters are invalid.
	 */
	public static String parameterSeperatedStringFromArray(final ArrayDelimeter arrayDelimeter, final String... inputs) throws InvalidParameterException{
		if(arrayDelimeter != null && size(inputs) > 0) {
			StringBuilder result = new StringBuilder();
			for (String input : inputs) {
				if(result.length() == 0) {
					result.append(input);
				}else {
					result.append(arrayDelimeter.label);
					result.append(input);
				}
			}
			return result.toString();
		}else {
			throw new InvalidParameterException("invalid parameters provided");
		}
	}

	/**
	 * forms a {@code String} array from {@code String} by using {@linkplain String#split(String)} with provided parameter. 
	 * @param parameter used to split string.
	 * @param input source string.
	 * @return an array of {@code String} which is splitted using the parameter provided.
	 * @throws InvalidParameterException input parameters are invalid.
	 */
	public static String[] arrayFromParameterSeperatedString(final ArrayDelimeter arrayDelimeter, final String input) throws InvalidParameterException{
		if(arrayDelimeter != null &&  ValidationUtil.isValidString(input)) {
			return input.split(arrayDelimeter.label);
		}else {
			throw new InvalidParameterException("invalid parameters provided");
		}
	}

	/**
	 * forms a {@code String} from input array parameter using provided parameter.
	 * @param parameter used to join strings.
	 * @param inputs variable arguments of {@code String}.
	 * @return {@linkplain String} formed by appending parameter to in-between each string in array.
	 * @throws InvalidParameterException input parameters are invalid.
	 */
	public static String parameterSeperatedStringFromArray(final String parameter, final String... inputs) throws InvalidParameterException{
		if(ValidationUtil.isValidString(parameter) && size(inputs) > 0) {
			StringBuilder result = new StringBuilder();
			for (String input : inputs) {
				if(result.length() == 0) {
					result.append(input);
				}else {
					result.append(parameter);
					result.append(input);
				}
			}
			return result.toString();
		}else {
			throw new InvalidParameterException("invalid parameters provided");
		}
	}

	/**
	 * forms a {@code String} array from {@code String} by using {@linkplain String#split(String)} with provided parameter. 
	 * @param parameter used to split string.
	 * @param input source string.
	 * @return an array of {@code String} which is splitted using the parameter provided.
	 * @throws InvalidParameterException input parameters are invalid.
	 */
	public static String[] arrayFromParameterSeperatedString(final String parameter, final String input) throws InvalidParameterException{
		if(ValidationUtil.isValidString(parameter, input)) {
			return input.split(parameter);
		}else {
			throw new InvalidParameterException("invalid parameters provided");
		}
	}

}