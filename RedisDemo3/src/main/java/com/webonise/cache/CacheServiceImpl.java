package com.webonise.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.webonise.model.User;

@Component
public class CacheServiceImpl implements CacheService{

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public void save() {
		redisTemplate.opsForHash().put("user", "userId", 4);
		redisTemplate.opsForHash().put("user", "userName", "Reshma");
	}

	@Override
	public User retrieve() {
		
		User user = new User();
		user.setUserId((int) redisTemplate.opsForHash().get("user", "userId"));
		user.setUserName((String) redisTemplate.opsForHash().get("user", "userName"));

		return user;
	}

	@Override
	public User update() {
		/*redisTemplate.opsForHash().*/
		return null;
	}
	
}
