package com.zizibujuan.util.json;

import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public interface IJson {
	
	Map<String,Object> fromJsonObject(String jsonString);
	
	Map<String,Object> fromJsonObject(Reader reader);
	
	List<Map<String, Object>> fromJsonArray(String jsonString);
	
	List<Map<String, Object>> fromJsonArray(Reader reader);
	
	<T> T fromJsonObject(String jsonString, Class<T> clazz);
	
	<T> T fromJsonObject(InputStream io, Class<T> clazz);
	
	<T> List<T> fromJsonArray(String jsonString, Class<List<?>> collectionClass, Class<T> elementClass);
	
	<T> String stringify(T bean);
}
