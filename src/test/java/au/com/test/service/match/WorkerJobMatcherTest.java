package au.com.test.service.match;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import au.com.test.model.Job;
import au.com.test.model.JobMatch;
import au.com.test.model.Worker;

public class WorkerJobMatcherTest {

	@Test
	public void test_scoreMatch_all() {
		List<Matcher> matchers = new ArrayList<>();
		Worker worker = Mockito.mock(Worker.class);
		Job job = Mockito.mock(Job.class);
		
		Matcher m1 = Mockito.mock(Matcher.class);
		when(m1.match(worker, job)).thenReturn(true);
		when(m1.getWeight()).thenReturn(1.1);
		
		Matcher m2 = Mockito.mock(Matcher.class);
		when(m2.match(worker, job)).thenReturn(true);
		when(m2.getWeight()).thenReturn(1.3);
		
		matchers.add(m1);
		matchers.add(m2);
		WorkerJobMatcher jobMatcher = new WorkerJobMatcher(matchers);
		
		JobMatch result = jobMatcher.scoreMatch(worker, job);
		
		assertEquals(2.4, result.getScore(), 0.001);
		verify(m1).match(worker, job);
		verify(m1).getWeight();
		verify(m2).match(worker, job);
		verify(m2).getWeight();
		verifyNoMoreInteractions(m1, m2);
	}
	
	@Test
	public void test_scoreMatch_one_match() {
		List<Matcher> matchers = new ArrayList<>();
		Worker worker = Mockito.mock(Worker.class);
		Job job = Mockito.mock(Job.class);
		
		Matcher m1 = Mockito.mock(Matcher.class);
		when(m1.match(worker, job)).thenReturn(true);
		when(m1.getWeight()).thenReturn(1.1);
		
		Matcher m2 = Mockito.mock(Matcher.class);
		when(m2.match(worker, job)).thenReturn(false);
		
		matchers.add(m1);
		matchers.add(m2);
		WorkerJobMatcher jobMatcher = new WorkerJobMatcher(matchers);
		
		JobMatch result = jobMatcher.scoreMatch(worker, job);
		
		assertEquals(1.1, result.getScore(), 0.001);
		verify(m1).match(worker, job);
		verify(m1).getWeight();
		verify(m2).match(worker, job);
		verifyNoMoreInteractions(m1, m2);
	}
}
