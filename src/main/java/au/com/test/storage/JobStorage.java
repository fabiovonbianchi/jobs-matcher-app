package au.com.test.storage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import au.com.test.config.JobStorageConfig;
import au.com.test.model.Job;
import au.com.test.model.Worker;

@Repository
public class JobStorage {

	private RestTemplate restTemplate;
	
	private JobStorageConfig config;
	
	@Autowired
	public JobStorage(JobStorageConfig config, RestTemplate restTemplate) {
		this.config = config;
		this.restTemplate = restTemplate;
	}
	
	public List<Worker> getWorkers(){
		ResponseEntity<List<Worker>> response = restTemplate.exchange(
				buildUrl("api/workers"),
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<List<Worker>>(){}
		);
		checkResponse(response);
		return response.getBody();
	}
	
	public List<Job> getJobs(){
		ResponseEntity<List<Job>> response = restTemplate.exchange(
				buildUrl("api/jobs"),
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<List<Job>>(){}
		);
		checkResponse(response);
		return response.getBody();
	}

	private void checkResponse(ResponseEntity<?> response) {
		if (response.getStatusCode() != HttpStatus.OK) {
			throw new RuntimeException(String.format("Rest call failed with status: %s", response.getStatusCodeValue()));
		}
		
	}

	private String buildUrl(String path) {
		return String.format("%s%s", config.getUrl(), path);
	}
}
