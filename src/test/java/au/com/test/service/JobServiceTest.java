package au.com.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import au.com.test.model.Job;
import au.com.test.model.JobMatch;
import au.com.test.model.Worker;
import au.com.test.model.WorkerJobMatch;
import au.com.test.storage.JobStorage;

public class JobServiceTest {

	@Test
	public void test_getWorkers() {
		JobStorage storage = Mockito.mock(JobStorage.class);
		
		Worker w1 = new Worker();
		w1.setId(1);
		Worker w2 = new Worker();
		w1.setId(2);
		when(storage.getWorkers()).thenReturn(Arrays.asList(w1,w2));
		
		JobService service = new JobService(storage, Mockito.mock(JobMatchService.class));

		List<Worker> workers =  service.getWorkers();
		
		assertEquals(2,workers.size());
		assertEquals(w1, workers.get(0));
		assertEquals(w2, workers.get(1));
		
		verify(storage).getWorkers();
	}
	
	@Test
	public void test_matchJobs() {
		JobStorage storage = Mockito.mock(JobStorage.class);
		JobMatchService matchService = Mockito.mock(JobMatchService.class);
		
		Worker w1 = new Worker();
		w1.setId(1);
		when(storage.getWorkers()).thenReturn(Arrays.asList(w1));
		
		Job j1 = new Job();
		j1.setId(1);
		Job j2 = new Job();
		j1.setId(2);
		List<Job> jobs = Arrays.asList(j1,j2);
		when(storage.getJobs()).thenReturn(jobs);
		
		JobMatch m1 = Mockito.mock(JobMatch.class);
		JobMatch m2 = Mockito.mock(JobMatch.class);
		
		List<JobMatch> matchedJobs = Arrays.asList(m1,m2);
		
		when(matchService.match(w1, jobs)).thenReturn(matchedJobs);
		
		JobService service = new JobService(storage, matchService);
		WorkerJobMatch matchResult = service.matchJobs(1);
		
		assertEquals(w1, matchResult.getWorker());
		assertEquals(2, matchedJobs.size());
		
		verify(storage).getWorkers();
		verify(matchService).match(w1, jobs);
	}
	
	@Test(expected=RuntimeException.class)
	public void test_matchJobs_fail_worker_not_found() {
		JobStorage storage = Mockito.mock(JobStorage.class);
		Worker w1 = new Worker();
		w1.setId(1);
		when(storage.getWorkers()).thenReturn(Arrays.asList(w1));
		
		JobService service = new JobService(storage, Mockito.mock(JobMatchService.class));
		service.matchJobs(99);
	}
}
