package com.hekai.backend;

import com.hekai.backend.utils.EncryptUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

	@Test
	void contextLoads() {

	}

	public static void main(String[] args) {
//		for (int i=0;i<100;++i){
//			String s=UUIDUtil.generationOrderNumber();
//			System.out.println(s+"   长度："+s.length());
//		}
		String password="123456";
		String s=EncryptUtil.encryptSHA3(password);
		System.out.println(s);
		System.out.println(s.length());
	}
}
