package au.com.test.service.match;

import au.com.test.model.Job;
import au.com.test.model.Worker;

public class AgeMatcher extends WeightedMatcher {

	@Override
	public boolean match(Worker worker, Job job) {
		if (worker.getAge() > 30) {
			return job.getBillRate() > 14;
		}
		
		if (worker.getAge() > 25) {
			return job.getBillRate() > 10;
		}
		
		if (worker.getAge() > 20 ) {
			return job.getBillRate() > 5;
		}
		
		return false;
	}

}
