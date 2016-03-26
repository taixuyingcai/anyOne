package com.cube.pumpkin.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

//import com.alibaba.fastjson.JSON;

public class JSONArray implements Serializable, Iterable<JSONObject> {
	private static final long serialVersionUID = -226848762823674875L;
	private static final Logger log = Logger.getRootLogger();
	com.alibaba.fastjson.JSONArray data;

	public JSONArray(String str) {
		try {
			data = JSON.parseArray(str);
		} catch (com.alibaba.fastjson.JSONException e) {
			log.error(e.getMessage() + ", str=" + str);
		}
	}

	JSONArray(com.alibaba.fastjson.JSONArray data) {
		this.data = data;
	}

	@Override
	public Iterator<JSONObject> iterator() {
		return new JSONArrayIterator(this);
	}

	public JSONArray() {
		data = new com.alibaba.fastjson.JSONArray();
	}

	public JSONArray(Collection<?> c) {
		List<Object> list = new ArrayList<>(c);
		data = new com.alibaba.fastjson.JSONArray(list);
	}

	@SuppressWarnings("unchecked")
	public <T> ArrayList<T> toList(Class<T> clazz) {
		ArrayList<T> res = new ArrayList<T>();
		if (clazz == Integer.class) {
			for (int i = 0; i < data.size(); i++) {
				res.add(i, (T) data.getInteger(i));
			}
		} else if (clazz == Double.class) {
			for (int i = 0; i < data.size(); i++) {
				res.add(i, (T) data.getDouble(i));
			}
		}
		return res;
	}

	/**
	 * 将source中的各个元素追加到当前数组的结尾,如果source是null直接返回
	 * 
	 * @param source
	 * @return
	 */
	public JSONArray append(JSONArray source) {
		if (source == null) {
			return this;
		}
		for (int i = 0; i < source.length(); i++) {
			data.add(source.get(i));
		}
		return this;
	}

	public JSONArray remove(int index) {
		data.remove(index);
		return this;
	}

	public JSONArray remove(Object o) {
		data.remove(o);
		return this;
	}

	public JSONArray clear() {
		data.clear();
		return this;
	}

	public JSONArray put(Object value) {
		if (value instanceof JSONObject) {
			data.add(((JSONObject) value).data);
		} else if (value instanceof JSONArray) {
			data.add(((JSONArray) value).data);
		} else {
			data.add(value);
		}
		return this;
	}

	public int getInt(int index) {
		try {
			return data.getIntValue(index);
		} catch (JSONException e) {
			log.error(e.getMessage());
		}
		return 0;
	}

	public double getDoulbe(int index) {
		try {
			return data.getDoubleValue(index);
		} catch (JSONException e) {
			log.error(e.getMessage());
		}
		return 0d;
	}

	public String getString(int index) {
		try {
			return data.getString(index);
		} catch (JSONException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public Object get(int index) {
		try {
			return data.get(index);
		} catch (JSONException e) {
			log.error(e.getMessage());
		}
		return 0;
	}

	public void setInt(int index, int o) {
		try {
			if (data.size() <= index) {
				for (int i = data.size(); i <= index; i++) {
					data.add(0);
				}
				data.set(index, o);
			} else {
				data.set(index, o);
			}

		} catch (JSONException e) {
			log.error(e.getMessage());
		}
	}

	public void setString(int index, String str) {
		try {
			if (data.size() <= index) {
				for (int i = data.size(); i <= index; i++) {
					data.add("");
				}
				data.set(index, str);
			} else {
				data.set(index, str);
			}
		} catch (JSONException e) {
			log.error(e.getMessage());
		}
	}

	public JSONObject getJSONObject(int index) {
		try {
			return new JSONObject(data.getJSONObject(index));
		} catch (JSONException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public JSONArray getJSONArray(int index) {
		try {
			return new JSONArray(data.getJSONArray(index));
		} catch (JSONException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public boolean isContains(Object obj) {
		boolean flag = false;
		try {
			flag = data.contains(obj);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return flag;
	}

	public int size() {
		return data.size();
	}

	public int length() {
		return data.size();
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
