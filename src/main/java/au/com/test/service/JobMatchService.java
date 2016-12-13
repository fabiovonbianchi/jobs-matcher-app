package au.com.test.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import au.com.test.model.Job;
import au.com.test.model.JobMatch;
import au.com.test.model.Worker;
import au.com.test.service.match.WorkerJobMatcher;

public class JobMatchService {

	private WorkerJobMatcher matcher;
	
	public JobMatchService(WorkerJobMatcher matcher) {
		this.matcher = matcher;
	}

	public List<JobMatch> match(Worker worker, List<Job> jobs) {
		List<JobMatch> result = new ArrayList<>();
		for (Job j : jobs) {
			result.add(matcher.scoreMatch(worker, j));
		}
		
		Collections.sort(result, Collections.reverseOrder(new Comparator<JobMatch>() {

			@Override
			public int compare(JobMatch o1, JobMatch o2) {
				if (o1.getScore() < o2.getScore()) {
					return -1;
				} else if (o1.getScore() > o2.getScore()) {
					return 1;
				} else {
					return 0;
				}
			}
		}));
		
		return result;
	}
}
