package com.vbolide.json;

import com.google.gson.JsonElement;

public class GsonKV {

	private Object key;
	private Object value;

	private GsonKV(final Object key, final Object value) {
		this.key = key;
		this.value = value;
	}

	public Object getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}

	public static GsonKV init(final Object key, final Object value) {
		return new GsonKV(key, value);
	}



	private String jsonElementKey;

	private JsonElement jsonElement;
	
	private GsonKV(final String jsonElementKey, final JsonElement jsonElement) {
		this.jsonElementKey = jsonElementKey;
		this.jsonElement = jsonElement;
	}

	public String getJsonElementKey() {
		return jsonElementKey;
	}

	public JsonElement getJsonElement() {
		return jsonElement;
	}

	public static GsonKV init(final String jsonElementKey, final JsonElement jsonElement) {
		return new GsonKV(jsonElementKey, jsonElement);
	}


	@Override
	public String toString() {
		return "GsonKV [key=" + key + ", value=" + value + ", jsonElementKey=" + jsonElementKey + ", jsonElement=" + jsonElement + "]";
	}

}