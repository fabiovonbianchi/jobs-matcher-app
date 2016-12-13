package au.com.test.service.match;

public abstract class WeightedMatcher implements Matcher {

	private double weight = 0;

	public WeightedMatcher withWeight(double weight) {
		this.weight = weight;
		return this;
	}

	@Override
	public double getWeight() {
		return weight;
	}

}
