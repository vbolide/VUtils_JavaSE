package com.vbolide.validation;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Utility class for most commonly used validations.
 * 
 * @author Vamshi Byagari
 */
public class ValidationUtil {

	/**
	 * valid url regular expression pattern
	 */
	public static final String VALID_URL_REGEX = "^(https?:\\/\\/)(www.)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";

	private static final String EMPTY_STRING = "";

	/**
	 * Checks the {@linkplain String}(s) validity.
	 * @param strings variable arguments of {@linkplain String}
	 * @return 
	 * 
     * <ul>
     * <li>One {@linkplain String}<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one {@linkplain String}<br>
     *     true if all the strings are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	public static boolean isValidString(final String... strings) {
		for (String string : strings) {
			if(string == null || string.isEmpty() || EMPTY_STRING.equals(string.trim())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the {@linkplain List}(s) validity.
	 * @param lists variable arguments of {@linkplain List}
	 * @return 
	 * 
     * <ul>
     * <li>One {@linkplain List}<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one {@linkplain List}<br>
     *     true if all the lists are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValidList(final List... lists) {
		for (List list : lists) {
			if(list == null || list.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the {@linkplain Set}(s) validity.
	 * @param sets variable arguments of {@linkplain Set}
	 * @return 
	 * 
     * <ul>
     * <li>One {@linkplain Set}<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one {@linkplain Set}<br>
     *     true if all the sets are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValidSet(final Set... sets) {
		for (Set set : sets) {
			if(set == null || set.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the {@linkplain Map}(s) validity.
	 * @param maps variable arguments of {@linkplain Map}
	 * @return 
	 * 
     * <ul>
     * <li>One {@linkplain Map}<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one {@linkplain Map}<br>
     *     true if all the maps are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValidMap(final Map... maps) {
		for (Map map : maps) {
			if(map == null || map.isEmpty()) {
				return false;
			}
		}
		return true;
	}



	/**
	 * Checks the <b>byte</b> array(s) validity.
	 * @param arrays variable arguments of <b>byte</b> array(s).
	 * @return 
	 * 
     * <ul>
     * <li>One <b>byte</b> array<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one <b>byte</b> array<br>
     *     true if all the byte arrays are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	public static boolean isValidByteArray(final byte[]... arrays) {
		for (byte[] array : arrays) {
			if(array == null || array.length == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the <b>short</b> array(s) validity.
	 * @param arrays variable arguments of <b>short</b> array(s).
	 * @return 
	 * 
     * <ul>
     * <li>One <b>short</b> array<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one <b>short</b> array<br>
     *     true if all the short arrays are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	public static boolean isValidShortArray(final short[]... arrays) {
		for (short[] array : arrays) {
			if(array == null || array.length == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the <b>char</b> array(s) validity.
	 * @param arrays variable arguments of <b>char</b> array(s).
	 * @return 
	 * 
     * <ul>
     * <li>One <b>char</b> array<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one <b>char</b> array<br>
     *     true if all the char arrays are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	public static boolean isValidCharArray(final char[]... arrays) {
		for (char[] array : arrays) {
			if(array == null || array.length == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the <b>boolean</b> array(s) validity.
	 * @param arrays variable arguments of <b>boolean</b> array(s).
	 * @return 
	 * 
     * <ul>
     * <li>One <b>boolean</b> array<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one <b>boolean</b> array<br>
     *     true if all the boolean arrays are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	public static boolean isValidBooleanArray(final boolean[]... arrays) {
		for (boolean[] array : arrays) {
			if(array == null || array.length == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the <b>integer</b> array(s) validity.
	 * @param arrays variable arguments of <b>integer</b> array(s).
	 * @return 
	 * 
     * <ul>
     * <li>One <b>integer</b> array<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one <b>integer</b> array<br>
     *     true if all the integer arrays are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	public static boolean isValidIntArray(final int[]... arrays) {
		for (int[] array : arrays) {
			if(array == null || array.length == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the <b>long</b> array(s) validity.
	 * @param arrays variable arguments of <b>long</b> array(s).
	 * @return 
	 * 
     * <ul>
     * <li>One <b>long</b> array<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one <b>long</b> array<br>
     *     true if all the long arrays are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	public static boolean isValidLongArray(final long[]... arrays) {
		for (long[] array : arrays) {
			if(array == null || array.length == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the <b>float</b> array(s) validity.
	 * @param arrays variable arguments of <b>float</b> array(s).
	 * @return 
	 * 
     * <ul>
     * <li>One <b>float</b> array<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one <b>float</b> array<br>
     *     true if all the float arrays are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	public static boolean isValidFloatArray(final float[]... arrays) {
		for (float[] array : arrays) {
			if(array == null || array.length == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the <b>double</b> array(s) validity.
	 * @param arrays variable arguments of <b>double</b> array(s).
	 * @return 
	 * 
     * <ul>
     * <li>One <b>double</b> array<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one <b>double</b> array<br>
     *     true if all the double arrays are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	public static boolean isValidDoubleArray(final double[]... arrays) {
		for (double[] array : arrays) {
			if(array == null || array.length == 0) {
				return false;
			}
		}
		return true;
	}



	/**
	 * Checks the {@linkplain Object}(s) validity.
	 * @param objects variable arguments of {@linkplain Object}
	 * @return 
	 * 
     * <ul>
     * <li>One {@linkplain Object}<br>
     *     true if non null and not empty otherwise false.
     * </li>
     * <li>More than one {@linkplain Object}<br>
     *     true if all the objects are non null and not empty otherwise false.
     * </li>
     * </ul>
	 */
	public static boolean isValidObjectArray(final Object[]... objects) {
		for (Object[] objectArray : objects) {
			if(objectArray == null || objectArray.length == 0) {
				return false;
			}
		}
		return true;
	}


	/**
	 * Checks the validity of the url.
	 * @param input string url.
	 * @return <b>true</b> if valid <b>flase</b> otherwise.
	 */
	public static boolean isValidURL(final String input) {
		return isValidString(input) && input.matches(VALID_URL_REGEX);
	}
	
}