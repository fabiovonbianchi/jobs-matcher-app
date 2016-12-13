package au.com.test.service.match;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import au.com.test.model.Job;
import au.com.test.model.Worker;

public class CertificatesMatcherTest {

	
	@Test
	public void test_matchCertificates(){
		CertificatesMatcher m = new CertificatesMatcher();
		Worker w = new Worker();
		w.setCertificates(Arrays.asList("x","a","y","b"));
		
		Job j = new Job();
		j.setRequiredCertificates(Arrays.asList("b","a"));
		
		assertTrue(m.match(w, j));
	}
	
	@Test
	public void test_matchCertificates_no_required(){
		CertificatesMatcher m = new CertificatesMatcher();
		Worker w = new Worker();
		w.setCertificates(Arrays.asList("x","a","y","b"));
		
		Job j = new Job();
		j.setRequiredCertificates(Collections.emptyList());
		
		assertTrue(m.match(w, j));
	}
	
	@Test
	public void test_matchCertificates_no_worker_certificate(){
		CertificatesMatcher m = new CertificatesMatcher();
		Worker w = new Worker();
		w.setCertificates(Collections.emptyList());
		
		Job j = new Job();
		j.setRequiredCertificates(Arrays.asList("b","a"));
		
		assertFalse(m.match(w, j));
	}
	
	@Test
	public void test_matchCertificates_partial_match(){
		CertificatesMatcher m = new CertificatesMatcher();
		Worker w = new Worker();
		w.setCertificates(Arrays.asList("b","x"));
		
		Job j = new Job();
		j.setRequiredCertificates(Arrays.asList("b","a"));
		
		assertFalse(m.match(w, j));
	}
}
