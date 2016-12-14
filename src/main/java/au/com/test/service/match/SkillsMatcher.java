package au.com.test.service.match;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import au.com.test.model.Job;
import au.com.test.model.Worker;

/**
 * Match worker skills with job title
 *
 */
public class SkillsMatcher extends WeightedMatcher {

	@Override
	public boolean match(Worker worker, Job job) {
		if (CollectionUtils.isEmpty(worker.getSkills())) {
			return false;
		}
		if (job.getJobTitle() == null) {
			return false;
		}
		Set<String> skills = new HashSet<String>(worker.getSkills());
		
		return skills.contains(job.getJobTitle());
	}

}
