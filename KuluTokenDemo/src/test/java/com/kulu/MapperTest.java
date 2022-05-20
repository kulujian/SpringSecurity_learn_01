package com.kulu;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kulu.domain.User;
import com.kulu.mapper.UserMapper;

@SpringBootTest
public class MapperTest {

	@Autowired
	private UserMapper	userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Test
	public void TestBCryptPasswordEncoder() {

		//  加密
		//	雖然原文是一樣的，但是因為每次加密時都會產生隨機的【鹽】，透過隨機的【鹽】產生出來的密文才會不一樣
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 透過屬性注入，就可以不用new物件
		String encode = passwordEncoder.encode("1234");
		String encode2 = passwordEncoder.encode("1234");
		System.out.println(encode);
		System.out.println(encode2);
		//		$2a$10$JSHzZee3Kw3zbjzd9WJOL.NxoJ9SKQ3wCp8GFYdGDclcX1bZFxciu
		//		$2a$10$orf.Yx17OD.dYTdfPWeRU.IU1hK7sfOQqzqy6B3mJY9UWll30O1hC
		System.out.println("");
		//	密文校驗
		System.out.println(passwordEncoder.matches("1234", "$2a$10$JSHzZee3Kw3zbjzd9WJOL.NxoJ9SKQ3wCp8GFYdGDclcX1bZFxciu"));
		System.out.println(passwordEncoder.matches("12345", "$2a$10$JSHzZee3Kw3zbjzd9WJOL.NxoJ9SKQ3wCp8GFYdGDclcX1bZFxciu"));
		System.out.println(passwordEncoder.matches("1234", "$2a$10$orf.Yx17OD.dYTdfPWeRU.IU1hK7sfOQqzqy6B3mJY9UWll30O1hC"));
		System.out.println(passwordEncoder.matches("123", "$2a$10$orf.Yx17OD.dYTdfPWeRU.IU1hK7sfOQqzqy6B3mJY9UWll30O1hC"));
	}
	
	
	public void testUserMapper() {
		
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}
}
