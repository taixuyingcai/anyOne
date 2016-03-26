package com.cube.pumpkin.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

public class JSONObject implements Serializable {
	private static final long serialVersionUID = -5161953975668478530L;
	private static final Logger log = Logger.getRootLogger();
	final com.alibaba.fastjson.JSONObject data;

	public JSONObject(String str) {
		try {
			data = JSON.parseObject(str);
		} catch (com.alibaba.fastjson.JSONException e) {
			log.error(e.getMessage() + ", str=" + str);
			throw new com.cube.pumpkin.json.JSONException(e.getMessage());
		}
	}

	JSONObject(com.alibaba.fastjson.JSONObject data) {
		this.data = data;
	}

	public JSONObject() {
		data = new com.alibaba.fastjson.JSONObject();
	}

	public JSONObject(HashMap<String, ?> m) {
		data = new com.alibaba.fastjson.JSONObject();
		for (String key : m.keySet()) {
			Object o = m.get(key);
			if (o instanceof JSONArray) {
				data.put(key, ((JSONArray) o).data);
			} else if (o instanceof JSONObject) {
				data.put(key, ((JSONObject) o).data);
			} else {
				data.put(key, o);
			}
		}
	}

	public String getString(String key) {
		if (data.containsKey(key)) {
			return data.getString(key);
		}
		return "";
	}

	public static Set<String> getNames(JSONObject json) {
		return json.data.keySet();
	}

	public Set<String> keys() {
		return data.keySet();
	}

	public Object get(String key) {
		return data.get(key);
	}

	public int getInt(String key) {
		return data.getIntValue(key);
	}

	public int optInt(String key, int defaultValue) {
		if (data.containsKey(key)) {
			return data.getIntValue(key);
		}
		return defaultValue;
	}

	public float getFloat(String key) {
		return data.getFloatValue(key);
	}

	public double getDouble(String key) {
		return data.getDoubleValue(key);
	}

	public Double optDouble(String key, Double defaultValue) {
		if (data.containsKey(key)) {
			return data.getDouble(key);
		}
		return defaultValue;
	}

	public long getLong(String key) {
		return data.getLongValue(key);
	}

	public boolean getBoolean(String key) {
		return data.getBooleanValue(key);
	}

	/**
	 * key不存在时返回null
	 * @param key
	 * @return
	 */
	public JSONObject getJSONObject(String key) {
		if (data.containsKey(key)) {
			return new JSONObject(data.getJSONObject(key));
		}
		return null;
	}

	/**
	 * key不存在时返回null
	 * @param key
	 * @return
	 */
	public JSONArray getJSONArray(String key) {
		if (data.containsKey(key)) {
			return new JSONArray(data.getJSONArray(key));
		}
		return null;
	}

	public JSONObject put(String key, Object value) {
		if (value instanceof JSONObject) {
			data.put(key, ((JSONObject) value).data);
		} else if (value instanceof JSONArray) {
			data.put(key, ((JSONArray) value).data);
		} else {
			data.put(key, value);
		}
		return this;
	}

	public void append(JSONObject params) {
		if (params == null || params.length() == 0) {
			return;
		}
		for (String key : params.keys()) {
			put(key, params.get(key));
		}
	}

	public int length() {
		return data.size();
	}

	public boolean has(String key) {
		return data.containsKey(key);
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
