package com.vbolide.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Utility class for {@linkplain Map} based on {@linkplain MapInstanceType}, simple way to create a map and add items to it.
 * 
 * @author Vamshi Byagari
 */
public class MapUtil {

	/**
	 * determines that which map implementation should be instantiated in {@linkplain MapUtil#init()}.
	 * 
     * <ul>
     * <li>{@linkplain MapInstanceType#CONCURRENT_HASHMAP}<br></li>
     * <li>{@linkplain MapInstanceType#HASHMAP}<br></li>
     * <li>{@linkplain MapInstanceType#HASHTABLE}<br></li>
     * <li>{@linkplain MapInstanceType#IDENTITY_HASHMAP}<br></li>
     * <li>{@linkplain MapInstanceType#LINKED_HASHMAP}<br></li>
     * <li>{@linkplain MapInstanceType#TREEMAP}<br></li>
     * <li>{@linkplain MapInstanceType#WEAK_HASHMAP}<br></li>
	 * </ul>
	 * 
	 * @author Vamshi Byagari
	 */
	public enum MapInstanceType{
		/**
		 * {@linkplain ConcurrentHashMap} instance used in {@linkplain MapUtil#init()}.
		 */
		CONCURRENT_HASHMAP,
		
		/**
		 * {@linkplain HashMap} instance used in {@linkplain MapUtil#init()}.
		 */
		HASHMAP,
		
		/**
		 * {@linkplain Hashtable} instance used in {@linkplain MapUtil#init()}.
		 */
		HASHTABLE,
		
		/**
		 * {@linkplain IdentityHashMap} instance used in {@linkplain MapUtil#init()}.
		 */
		IDENTITY_HASHMAP,
		
		/**
		 * {@linkplain LinkedHashMap} instance used in {@linkplain MapUtil#init()}.
		 */
		LINKED_HASHMAP,
		
		/**
		 * {@linkplain TreeMap} instance used in {@linkplain MapUtil#init()}.
		 */
		TREEMAP,
		
		/**
		 * {@linkplain WeakHashMap} instance used in {@linkplain MapUtil#init()}.
		 */
		WEAK_HASHMAP
	}

	/**
	 * {@linkplain Map} reference that holds the instance of {@linkplain Map} implementation class based on {@linkplain MapInstanceType}
	 */
	private Map<String, Object> map;

	private MapUtil(MapInstanceType mapInstanceType) {
		switch (mapInstanceType) {
			case CONCURRENT_HASHMAP: map = new ConcurrentHashMap<>(); break;
			case HASHTABLE: map = new Hashtable<>(); break;
			case IDENTITY_HASHMAP: map = new IdentityHashMap<>(); break;
			case LINKED_HASHMAP: map = new LinkedHashMap<>(); break;
			case TREEMAP: map = new TreeMap<>(); break;
			case WEAK_HASHMAP: map = new WeakHashMap<>(); break;
			default: map = new HashMap<>(); break;
		}
	}

	/**
	 * creates an instance of {@linkplain MapUtil}
	 * @param mapInstanceType - any one value of {@linkplain MapInstanceType}
	 * @return {@linkplain MapUtil} instance.
	 */
	public static MapUtil init(MapInstanceType mapInstanceType) {
		return new MapUtil(mapInstanceType);
	}

	/**
	 * add key, value pair to {@linkplain MapUtil#map}
	 * @param key - key to add in map
	 * @param value - value to add in map
	 * @return reference of {@linkplain MapUtil}
	 */
	public MapUtil add(String key, Object value) {
		map.put(key, value);
		return this;
	}

	/**
	 * add key, value paid to {@linkplain MapUtil#map} and return it.
	 * @param key - key to add in map
	 * @param value - value to add in map
	 * @return {@linkplain MapUtil#map}
	 */
	public Map<String, Object> build(String key, Object value){
		map.put(key, value);
		return map;
	}

	/**
	 * return the {@linkplain MapUtil#map}
	 * @return {@linkplain MapUtil#map}
	 */
	public Map<String, Object> build(){
		return map;
	}

}