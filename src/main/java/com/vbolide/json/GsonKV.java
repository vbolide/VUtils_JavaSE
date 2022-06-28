package com.vbolide.json;

import com.google.gson.JsonElement;

public class GsonKV {

	private Object key;
	private Object value;

	private GsonKV(Object key, Object value) {
		this.key = key;
		this.value = value;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public static GsonKV o(Object key, Object value) {
		return new GsonKV(key, value);
	}



	private String jsonElementKey;

	private JsonElement jsonElement;
	
	private GsonKV(String jsonElementKey, JsonElement jsonElement) {
		this.jsonElementKey = jsonElementKey;
		this.jsonElement = jsonElement;
	}

	public String getJsonElementKey() {
		return jsonElementKey;
	}

	public void setJsonElementKey(String jsonElementKey) {
		this.jsonElementKey = jsonElementKey;
	}

	public JsonElement getJsonElement() {
		return jsonElement;
	}

	public void setJsonElement(JsonElement jsonElement) {
		this.jsonElement = jsonElement;
	}

	public static GsonKV init(String jsonElementKey, JsonElement jsonElement) {
		return new GsonKV(jsonElementKey, jsonElement);
	}


	@Override
	public String toString() {
		return "GsonKV [key=" + key + ", value=" + value + ", jsonElementKey=" + jsonElementKey + ", jsonElement=" + jsonElement + "]";
	}

}