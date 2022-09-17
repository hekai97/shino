package com.hekai.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hekai.backend.utils.RegexUtil;


@SpringBootTest
class BackendApplicationTests {
	@Test
	void contextLoads() {

	}

	public static void main(String[] args) {
		String path="/home/ubuntu/images/1.jpg";
		String res=RegexUtil.getRelativePath(path);
		System.out.println(res);
	}
}
