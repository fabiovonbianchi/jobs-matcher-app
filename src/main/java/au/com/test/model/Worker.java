package au.com.test.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Worker {

	@JsonProperty(value="userId")
	private int id;
	
	private List<String> skills;
	
	private List<String> certificates;
	
	private boolean hasDriversLicense;
	
	@JsonProperty(value="isActive")
	private boolean active;
	
	private JobSearchAddress jobSearchAddress;
	
	private int rating;
	
	private String transportation;
	
	private int age;
	
	public List<String> getCertificates() {
		return certificates;
	}
	public void setCertificates(List<String> certificates) {
		this.certificates = certificates;
	}
	public boolean isHasDriversLicense() {
		return hasDriversLicense;
	}
	public void setHasDriversLicense(boolean hasDriversLicense) {
		this.hasDriversLicense = hasDriversLicense;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public JobSearchAddress getJobSearchAddress() {
		return jobSearchAddress;
	}
	public void setJobSearchAddress(JobSearchAddress jobSearchAddress) {
		this.jobSearchAddress = jobSearchAddress;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
