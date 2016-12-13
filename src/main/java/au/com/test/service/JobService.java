package au.com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.test.model.JobMatch;
import au.com.test.model.Worker;
import au.com.test.model.WorkerJobMatch;
import au.com.test.storage.JobStorage;

@Service
public class JobService {

	private final static int MAX_MATCHED_JOBS = 3;

	private JobStorage storage;

	private JobMatchService jobMatchService;

	@Autowired
	public JobService(JobStorage storage, JobMatchService jobMatchService) {
		this.storage = storage;
		this.jobMatchService = jobMatchService;
	}

	public List<Worker> getWorkers() {
		return storage.getWorkers();
	}

	public WorkerJobMatch matchJobs(Integer workerId) {

		Optional<Worker> worker = findWorkerById(workerId);
		if (!worker.isPresent()) {
			throw new RuntimeException(String.format("Worker with id: %s was not found", workerId));
		}
		List<JobMatch> jobs = jobMatchService.match(worker.get(), storage.getJobs());

		WorkerJobMatch result = new WorkerJobMatch();
		result.setWorker(worker.get());

		if (jobs != null) {
			if (jobs.size() > MAX_MATCHED_JOBS) {
				result.setJobs(jobs.subList(0, MAX_MATCHED_JOBS));
			} else {
				result.setJobs(jobs);
			}
		}
		return result;
	}

	private Optional<Worker> findWorkerById(Integer workerId) {
		return getWorkers().stream()
				.filter(w -> w.getId() == workerId)
				.findFirst();
	}

}
