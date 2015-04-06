package com.zizibujuan.util.json;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JacksonTests {

	private Jackson jackson;
	
	@Before
	public void setUp(){
		jackson = new Jackson();
	}
	
	@Test
	public void testBean(){
		Calendar c = Calendar.getInstance();
		c.set(2015, 1, 2, 12, 23, 45);
		Bean bean = new Bean();
		bean.setDoubleNumber(10.2);
		bean.setIntNumber(2);
		bean.setDate(c.getTime());
		bean.setText("a");
		String jsonString = jackson.stringify(bean);
		System.out.println(jsonString);
		Assert.assertTrue(jsonString.contains("\"TEXT\":\"a\""));
		Assert.assertTrue(jsonString.contains("\"INTNUMBER\":2"));
		Assert.assertTrue(jsonString.contains("\"DOUBLENUMBER\":10.2"));
		Assert.assertTrue(jsonString.contains("\"DATE\":\"2015-02-02 12:23:45\""));
		
		//String jsonString1 = "{\"text\":\"a\",\"intNumber\":2,\"doubleNumber\":10.2,\"date\":\"2015-02-02 12:23:45\"}";
		String jsonString1 = "{\"TEXT\":\"a\",\"INTNUMBER\":2,\"DOUBLENUMBER\":10.2,\"DATE\":\"2015-02-02 12:23:45\"}";
		Bean bean1 = jackson.fromJsonObject(jsonString1, Bean.class);
		Assert.assertEquals("a", bean1.getText());
		Assert.assertEquals(2, bean1.getIntNumber());
		Assert.assertEquals(10.2, bean1.getDoubleNumber(), 1);
		Assert.assertEquals(DateFormatUtils.format(c.getTime(), "yyyy-MM-dd HH:mm:ss"), 
				DateFormatUtils.format(bean1.getDate(), "yyyy-MM-dd HH:mm:ss"));
	}
	
	
	@Test
	public void testMap(){
		Calendar c = Calendar.getInstance();
		c.set(2015, 1, 2, 12, 23, 45);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("doubleNumber", 10.2);
		map.put("intNumber", 2);
		map.put("text", "a");
		map.put("date", c.getTime());

		String jsonString = jackson.stringify(map);
		System.out.println(jsonString);
		Assert.assertTrue(jsonString.contains("\"text\":\"a\""));
		Assert.assertTrue(jsonString.contains("\"intNumber\":2"));
		Assert.assertTrue(jsonString.contains("\"doubleNumber\":10.2"));
		Assert.assertTrue(jsonString.contains("\"date\":\"2015-02-02 12:23:45\""));
		
		String jsonString1 = "{\"text\":\"a\",\"intNumber\":2,\"doubleNumber\":10.2,\"date\":\"2015-02-02 12:23:45\"}";
		Map<String, Object> map1 = jackson.fromJsonObject(jsonString1);
		Assert.assertEquals("a", map1.get("text"));
		Assert.assertEquals(2, Integer.valueOf(map1.get("intNumber").toString()).intValue());
		Assert.assertEquals(10.2, Double.valueOf(map1.get("doubleNumber").toString()).doubleValue(), 1);
		Assert.assertEquals(DateFormatUtils.format(c.getTime(), "yyyy-MM-dd HH:mm:ss"), map1.get("date"));
	}
}
