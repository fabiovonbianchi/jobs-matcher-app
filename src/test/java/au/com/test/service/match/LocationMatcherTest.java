package au.com.test.service.match;

import static org.junit.Assert.*;

import org.junit.Test;

import au.com.test.model.Job;
import au.com.test.model.JobSearchAddress;
import au.com.test.model.Location;
import au.com.test.model.Worker;

public class LocationMatcherTest {

	@Test
	public void test_match(){
		LocationMatcher m = new LocationMatcher();
		Worker w = new Worker();
		JobSearchAddress address = new JobSearchAddress();
		//bondi
		address.setLatitude(33.8915);
		address.setLongitude(151.2767);
		address.setUnit("Km");
		address.setMaxJobDistance(40);
		w.setJobSearchAddress(address);
		
		Job j = new Job();
		Location loc = new Location();
		//sydney CBD
		loc.setLatitude(33.8688);
		loc.setLongitude(151.2093);
		j.setLocation(loc);
		
		assertTrue(m.match(w, j));
	}
	
	@Test
	public void test_match_false(){
		LocationMatcher m = new LocationMatcher();
		Worker w = new Worker();
		JobSearchAddress address = new JobSearchAddress();
		//newcastle (australia)
		address.setLatitude(32.9283);
		address.setLongitude(151.7817);
		address.setUnit("Km");
		address.setMaxJobDistance(100);
		w.setJobSearchAddress(address);
		
		Job j = new Job();
		Location loc = new Location();
		//sydney CBD
		loc.setLatitude(33.8688);
		loc.setLongitude(151.2093);
		j.setLocation(loc);
		
		assertFalse(m.match(w, j));
	}
}
