package au.com.test.config;

import java.util.Arrays;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import au.com.test.service.JobMatchService;
import au.com.test.service.match.AgeMatcher;
import au.com.test.service.match.CertificatesMatcher;
import au.com.test.service.match.DriverLicenseMatcher;
import au.com.test.service.match.LocationMatcher;
import au.com.test.service.match.SkillsMatcher;
import au.com.test.service.match.WorkerJobMatcher;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate configureRestTemplate(){
		return new RestTemplateBuilder().build();
	}
	
	@Bean
	public JobMatchService configureJobMatchService(){
		WorkerJobMatcher matcher = new WorkerJobMatcher (
			Arrays.asList(
				new AgeMatcher().withWeight(1),
				new SkillsMatcher().withWeight(1.5),
				new LocationMatcher().withWeight(1.1),
				new CertificatesMatcher().withWeight(1.9),
				new DriverLicenseMatcher().withWeight(1.5)
				
			)
		);
		return new JobMatchService(matcher);
	}
}
