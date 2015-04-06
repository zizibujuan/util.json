package com.zizibujuan.util.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.serializer.SerializerFeature;

public class Benchmark {

	private static final int COUNT = 2;
	
	@Test
	public void testBeanStringify(){
		Jackson jackson = new Jackson();
		
		List<Bean> list1 = new ArrayList<Bean>();
		for(int i = 0; i < COUNT; i++){
			Bean bean = new Bean();
			bean.setDate(new Date());
			bean.setText(i + "");
			bean.setIntNumber(i);
			bean.setDoubleNumber(i);
			list1.add(bean);
		}
		long start = System.nanoTime();
		for(Bean bean : list1){
			jackson.stringify(bean);
		}
		long end = System.nanoTime();
		System.out.println((end-start) + ": bean stringify jackson");
		
		com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		start = System.nanoTime();
		for(Bean bean : list1){
			com.alibaba.fastjson.JSON.toJSONString(bean, new UpperCaseNameFilter(),SerializerFeature.WriteDateUseDateFormat);
		}
		end = System.nanoTime();
		System.out.println((end-start) + ": bean stringify fastjson");
		
	}
	
	@Test
	public void testMapStringify(){
		Jackson jackson = new Jackson();
		
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		for(int i = 0; i < COUNT; i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("doubleNumber", 10.2);
			map.put("intNumber", 2);
			map.put("text", "a");
			map.put("date", new Date());
			list1.add(map);
		}
		long start = System.nanoTime();
		for(Map<String, Object> bean : list1){
			jackson.stringify(bean);
		}
		long end = System.nanoTime();
		System.out.println((end-start) + ": map stringify jackson");
		
		start = System.nanoTime();
		for(Map<String, Object> bean : list1){
			com.alibaba.fastjson.JSON.toJSONString(bean, SerializerFeature.WriteDateUseDateFormat);
		}
		end = System.nanoTime();
		System.out.println((end-start) + ": map stringify fastjson");
		
		String jacksonString = "";
		start = System.nanoTime();
		jacksonString = jackson.stringify(list1);
		end = System.nanoTime();
		System.out.println((end-start) + ": list stringify jackson");
		
		
		String fastjsonString = "";
		start = System.nanoTime();
		fastjsonString = com.alibaba.fastjson.JSON.toJSONString(list1, SerializerFeature.WriteDateUseDateFormat);
		end = System.nanoTime();
		System.out.println((end-start) + ": list stringify fastjson");
		
		//System.out.println(jacksonString);
		//System.out.println(fastjsonString);
	}
}
