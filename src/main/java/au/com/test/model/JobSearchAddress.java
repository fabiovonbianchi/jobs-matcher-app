package au.com.test.model;

public class JobSearchAddress extends Location {

	private int maxJobDistance;
	
	private String unit;

	public int getMaxJobDistance() {
		return maxJobDistance;
	}

	public void setMaxJobDistance(int maxJobDistance) {
		this.maxJobDistance = maxJobDistance;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
