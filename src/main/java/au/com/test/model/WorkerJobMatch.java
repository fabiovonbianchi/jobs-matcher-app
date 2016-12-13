package au.com.test.model;

import java.util.List;

public class WorkerJobMatch {

	private Worker worker;
	
	private List<JobMatch> jobs;

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public List<JobMatch> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobMatch> jobs) {
		this.jobs = jobs;
	}
}
