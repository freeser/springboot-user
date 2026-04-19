package com.fyfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan // 方式二不用这个
public class SpringbootUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootUserApplication.class, args);
	}

}
