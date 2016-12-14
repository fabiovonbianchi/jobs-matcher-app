package au.com.test.service.match;

import static org.junit.Assert.*;

import org.junit.Test;

import au.com.test.model.Job;
import au.com.test.model.Worker;

public class DriversLicenseMatcherTest {

	@Test
	public void test_match(){
		DriverLicenseMatcher m = new DriverLicenseMatcher();
		Worker w = new Worker();
		w.setHasDriversLicense(true);
		
		Job j = new Job();
		j.setDriverLicenseRequired(true);
		
		assertTrue(m.match(w, j));
	}
	
	@Test
	public void test_match_no_license_required() {
		DriverLicenseMatcher m = new DriverLicenseMatcher();
		Worker w = new Worker();
		w.setHasDriversLicense(false);
		
		Job j = new Job();
		j.setDriverLicenseRequired(false);
		
		assertTrue(m.match(w, j));
	}
	
	@Test
	public void test_match_false(){
		DriverLicenseMatcher m = new DriverLicenseMatcher();
		Worker w = new Worker();
		w.setHasDriversLicense(false);
		
		Job j = new Job();
		j.setDriverLicenseRequired(true);
		
		assertFalse(m.match(w, j));
	}
}
