package com.webonise.cache;

import org.springframework.stereotype.Component;

import com.webonise.model.User;

@Component
public interface CacheService {

	public void save();

	public User retrieve();

	public User update();

}
