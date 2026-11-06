package com.pack.springStudentDemo;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringStudentDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudentDemoApplication.class, args);
		System.out.println("Hello World");
	}

}
