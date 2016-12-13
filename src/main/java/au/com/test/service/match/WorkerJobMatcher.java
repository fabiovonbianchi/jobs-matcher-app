package au.com.test.service.match;

import java.util.List;

import au.com.test.model.Job;
import au.com.test.model.JobMatch;
import au.com.test.model.Worker;

public class WorkerJobMatcher {

	private List<Matcher> matchers;
	
	public WorkerJobMatcher(List<Matcher> matchers) {
		this.matchers = matchers;
	}
	
	public JobMatch scoreMatch(Worker worker, Job job) {
		double score = 0;
		for (Matcher matcher : matchers) {
			if (matcher.match(worker, job)) {
				score+= matcher.getWeight();
			}
		}
		return new JobMatch(job).withScore(score);
	}

}
