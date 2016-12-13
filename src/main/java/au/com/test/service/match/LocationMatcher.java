package au.com.test.service.match;

import au.com.test.model.Job;
import au.com.test.model.Worker;

public class LocationMatcher extends WeightedMatcher {

	@Override
	public boolean match(Worker worker, Job job) {
		if (worker.getJobSearchAddress() == null) {
			return false;
		}
		
		if (job.getLocation() == null) {
			return false;
		}
		
		double distance = DistanceCalculator.distance(job.getLocation().getLatitude(), job.getLocation().getLongitude(),
				worker.getJobSearchAddress().getLatitude(), worker.getJobSearchAddress().getLongitude());
		
		return distance <= worker.getJobSearchAddress().getMaxJobDistance();
	}

	private static class DistanceCalculator {

		private static double distance(double lat1, double lon1, double lat2, double lon2) {
			double theta = lon1 - lon2;
			double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
					+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
			dist = Math.acos(dist);
			dist = rad2deg(dist);
			dist = dist * 60 * 1.1515;
			dist = dist * 1.609344;

			return (dist);
		}

		private static double deg2rad(double deg) {
			return (deg * Math.PI / 180.0);
		}

		private static double rad2deg(double rad) {
			return (rad * 180 / Math.PI);
		}
	}

}
