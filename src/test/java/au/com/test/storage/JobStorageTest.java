package au.com.test.storage;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import au.com.test.config.JobStorageConfig;
import au.com.test.model.Job;
import au.com.test.model.Worker;

public class JobStorageTest {

	
	@SuppressWarnings("unchecked")
	@Test
	public void test_getWorkers(){
		JobStorageConfig config = Mockito.mock(JobStorageConfig.class);
		RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
		
		when(config.getUrl()).thenReturn("u/");
		
		ResponseEntity<List<Worker>> response = Mockito.mock(ResponseEntity.class);
		when(response.getStatusCode()).thenReturn(HttpStatus.OK);
		when(restTemplate.exchange("u/api/workers", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Worker>>() {
				})).thenReturn(response);
		
		JobStorage storage = new JobStorage(config, restTemplate);
		
		storage.getWorkers();
		
		verify(restTemplate).exchange("u/api/workers", HttpMethod.GET, null, new ParameterizedTypeReference<List<Worker>>(){});
		verify(response).getBody();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_getJobs(){
		JobStorageConfig config = Mockito.mock(JobStorageConfig.class);
		RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
		
		when(config.getUrl()).thenReturn("u/");
		
		ResponseEntity<List<Job>> response = Mockito.mock(ResponseEntity.class);
		when(response.getStatusCode()).thenReturn(HttpStatus.OK);
		when(restTemplate.exchange("u/api/jobs", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Job>>() {
				})).thenReturn(response);
		
		JobStorage storage = new JobStorage(config, restTemplate);
		
		storage.getJobs();
		
		verify(restTemplate).exchange("u/api/jobs", HttpMethod.GET, null, new ParameterizedTypeReference<List<Job>>(){});
		verify(response).getBody();
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=RuntimeException.class)
	public void test_getJobs_fail(){
		JobStorageConfig config = Mockito.mock(JobStorageConfig.class);
		RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
		
		when(config.getUrl()).thenReturn("u/");
		
		ResponseEntity<List<Job>> response = Mockito.mock(ResponseEntity.class);
		when(response.getStatusCode()).thenReturn(HttpStatus.INTERNAL_SERVER_ERROR);
		when(restTemplate.exchange("u/api/jobs", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Job>>() {
				})).thenReturn(response);
		
		JobStorage storage = new JobStorage(config, restTemplate);
		
		storage.getJobs();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=RuntimeException.class)
	public void test_getWorkers_fail(){
		JobStorageConfig config = Mockito.mock(JobStorageConfig.class);
		RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
		
		when(config.getUrl()).thenReturn("u/");
		
		ResponseEntity<List<Worker>> response = Mockito.mock(ResponseEntity.class);
		when(response.getStatusCode()).thenReturn(HttpStatus.INTERNAL_SERVER_ERROR);
		when(restTemplate.exchange("u/api/workers", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Worker>>() {
				})).thenReturn(response);
		
		JobStorage storage = new JobStorage(config, restTemplate);
		
		storage.getWorkers();
		
	}
}
