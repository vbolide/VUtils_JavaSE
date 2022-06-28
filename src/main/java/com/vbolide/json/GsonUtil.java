package com.vbolide.json;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GsonUtil {

	private GsonUtil() {}


	public static Gson gson() {
		return new GsonBuilder().serializeNulls().create();
	}


	public static String getJson(Object object) {
		return new GsonBuilder().serializeNulls().create().toJson(object);
	}
	
	public static JsonElement getJsonElement(Object object) {
		return new GsonBuilder().serializeNulls().create().toJsonTree(object);
	}


	public static String getJson(GsonKV... gsonKVs) {
		Map<Object,Object> map = new HashMap<>();
		for (GsonKV gsonKV : gsonKVs)
			map.put(gsonKV.getKey(), gsonKV.getValue());
		return new GsonBuilder().serializeNulls().create().toJson(map);
	}

	public static String getJson(JsonElement jsonTree, GsonKV... gsonKVs) {
		JsonObject jsonObject = jsonTree.getAsJsonObject();
		for (GsonKV gsonKV : gsonKVs)
			jsonObject.add(gsonKV.getJsonElementKey(), gsonKV.getJsonElement());
		return gson().toJson(jsonObject);
	}


	public static JsonElement getJsonElement(GsonKV... gsonKVs) {
		Map<Object,Object> map = new HashMap<>();
		for (GsonKV gsonKV : gsonKVs)
			map.put(gsonKV.getKey(), gsonKV.getValue());
		return new GsonBuilder().serializeNulls().create().toJsonTree(map);
	}

}