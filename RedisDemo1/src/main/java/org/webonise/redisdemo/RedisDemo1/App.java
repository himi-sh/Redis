package org.webonise.redisdemo.RedisDemo1;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Jedis jedis = new Jedis("localhost");
		System.out.println("Connected to jedis " + jedis.ping());

		jedis.set("name", "himani");
		System.out.println("Stored String is " + jedis.get("name"));

		jedis.lpush("list", "Himani");
		jedis.lpush("list", "sharma");

		List<String> fullName = jedis.lrange("list", 0, -1);

		for (String i : fullName) {
			System.out.println("Name= " + i);
		}

		/*
		 * List<String> keyList = (List<String>) jedis.keys("*"); for(String key
		 * : keyList){ System.out.println("List of Stored Keys :: "+key); }
		 */

		Set<String> keySet = jedis.keys("*");
		for(String key : keySet){
			System.out.println("Keys "+key);
		}
		
		
	}
}
