package com.hekai.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class BackendApplicationTests {

	@Test
	void contextLoads() {

	}

	public static void main(String[] args) {
		for (int i=0;i<1000;++i){
			System.out.println(UUID.randomUUID());
		}
	}
}
