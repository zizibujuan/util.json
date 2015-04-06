package com.zizibujuan.util.json;

import com.alibaba.fastjson.serializer.NameFilter;

public class UpperCaseNameFilter implements NameFilter{

	public String process(Object object, String name, Object value) {
		return name.toUpperCase();
	}

}
