package au.com.test.service.match;

import au.com.test.model.Job;
import au.com.test.model.Worker;

/**
 * Match driving license requirements
 *
 */
public class DriverLicenseMatcher extends WeightedMatcher {

	@Override
	public boolean match(Worker worker, Job job) {
		if (job.isDriverLicenseRequired()) {
			return worker.isHasDriversLicense() == true;
		}
		return true;
		
	}

	
}
