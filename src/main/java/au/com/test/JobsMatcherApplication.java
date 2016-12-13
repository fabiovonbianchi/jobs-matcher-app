package au.com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class JobsMatcherApplication {

	public static void main(String[] args) {
        SpringApplication.run(JobsMatcherApplication.class, args);
    }
}
