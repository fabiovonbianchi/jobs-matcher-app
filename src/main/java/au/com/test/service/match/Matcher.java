package au.com.test.service.match;

import au.com.test.model.Job;
import au.com.test.model.Worker;

public interface Matcher {

	boolean match(Worker worker, Job job);
	
	double getWeight();
}
