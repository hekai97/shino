package com.hekai.backend;

import com.hekai.backend.utils.DateFormatUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {
	@Test
	void contextLoads() {

	}

	public static void main(String[] args) {
		String date="2022-09-29T16:00:00.000Z";
		date=date.substring(0,9);
		System.out.println(DateFormatUtil.formatToTimestamp(date,"yyyy-MM-dd"));
	}
}
