package com.cube.pumpkin.json;

import java.util.Iterator;

public class JSONArrayIterator implements Iterator<JSONObject> {
	private JSONArray arr;
	private int cursor = -1;

	public JSONArrayIterator(JSONArray arr) {
		this.arr = arr;
	}

	@Override
	public boolean hasNext() {
		return arr != null && arr.length() > cursor + 1;
	}

	@Override
	public JSONObject next() {
		cursor++;
		return arr.getJSONObject(cursor);
	}

	@Override
	public void remove() {
		return;
	}
}
