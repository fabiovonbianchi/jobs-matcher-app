package au.com.test.service.match;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import au.com.test.model.Job;
import au.com.test.model.Worker;

/**
 * Match if worker has required certificates
 *
 */
public class CertificatesMatcher extends WeightedMatcher {


	@Override
	public boolean match(Worker worker, Job job) {
		if (CollectionUtils.isEmpty(job.getRequiredCertificates())) {
			return true;
		}

		if (CollectionUtils.isEmpty(worker.getCertificates())) {
			return false;
		}

		Set<String> certificates = new HashSet<>(worker.getCertificates());
		return certificates.containsAll(job.getRequiredCertificates());
	}

}
