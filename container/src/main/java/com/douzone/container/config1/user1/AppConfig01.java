package com.douzone.container.config1.user1;

import org.springframework.context.annotation.Bean;

import com.douzone.container.user.User;

public class AppConfig01 {
	@Bean
	public User user() {
		return new User();
	}
}
