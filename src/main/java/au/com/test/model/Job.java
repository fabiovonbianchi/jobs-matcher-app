package au.com.test.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {

	@JsonProperty(value="jobId")
	private int id;
	
	private Location location;
	
	@JsonDeserialize(using = MoneySerializer.class)
	private double billRate;
	
	private String company;
	
	private boolean driverLicenseRequired;
	
	private String jobTitle;
	
	private List<String> requiredCertificates;
	
	private int workersRequired;

	public double getBillRate() {
		return billRate;
	}

	public void setBillRate(double billRate) {
		this.billRate = billRate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean isDriverLicenseRequired() {
		return driverLicenseRequired;
	}

	public void setDriverLicenseRequired(boolean driverLicenseRequired) {
		this.driverLicenseRequired = driverLicenseRequired;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public List<String> getRequiredCertificates() {
		return requiredCertificates;
	}

	public void setRequiredCertificates(List<String> requiredCertificates) {
		this.requiredCertificates = requiredCertificates;
	}

	public int getWorkersRequired() {
		return workersRequired;
	}

	public void setWorkersRequired(int workersRequired) {
		this.workersRequired = workersRequired;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
