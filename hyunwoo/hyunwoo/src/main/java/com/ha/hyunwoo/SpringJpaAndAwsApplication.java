package com.ha.hyunwoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 모두 활성화
@SpringBootApplication
public class SpringJpaAndAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAndAwsApplication.class, args);
	}

}
