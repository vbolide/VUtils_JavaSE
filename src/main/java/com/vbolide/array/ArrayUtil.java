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
	 * @param obj - array of primitives data type like {@code byte}, {@code short}, {@code char}, {@code int}, {@code long}, {@code float}, {@code double} and {@code String}
	 * @return size of array
	 */
	public static int size(Object obj) {
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
	 * @param item - item to find in array.
	 * @param arrayObject - array from which item to find.
	 * @return <ul><li><b>true</b> if item exists</li><li><b>false</b> otherwise</li></ul>
	 * @throws InvalidParameterException - input parameters are invalid
	 */
	public static boolean hasItem(Object item, Object arrayObject) throws InvalidParameterException{
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
	 * forms a {@code String} from input array parameter using provided parameter.
	 * @param parameter - 
	 * @param inputs - variable arguments of {@code String}.
	 * @return {@linkplain String} formed by appending parameter to in-between each string in array.
	 * @throws InvalidParameterException - input parameters are invalid.
	 */
	public static String parameterSeperatedStringFromArray(String parameter, String... inputs) throws InvalidParameterException{
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
	 * forms a {@code String} array from {@code String} by using {@linkplain String#split()} with provided parameter. 
	 * @param parameter - used to split string.
	 * @param input - source string.
	 * @return an array of {@code String} which is splitted using the parameter provided.
	 * @throws InvalidParameterException - input parameters are invalid.
	 */
	public static String[] arrayFromParameterSeperatedString(String parameter, String input) throws InvalidParameterException{
		if(ValidationUtil.isValidString(parameter, input)) {
			return input.split(parameter);
		}else {
			throw new InvalidParameterException("invalid parameters provided");
		}
	}

}