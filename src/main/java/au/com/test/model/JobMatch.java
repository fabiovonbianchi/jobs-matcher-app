package au.com.test.model;

public class JobMatch {

	private final Job job;
	
	private double score;
	
	public JobMatch(Job job) {
		this.job = job;
	}

	public Job getJob() {
		return job;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public JobMatch withScore(double score) {
		this.score = score;
		return this;
	}

	
}
