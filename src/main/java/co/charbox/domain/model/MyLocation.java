package co.charbox.domain.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class MyLocation {

	@NonNull private String ip;
	private double[] location = new double[2];

	public MyLocation setLat(double lat) {
		getLocation()[0] = lat;
		return this;
	}

	public MyLocation setLon(double lon) {
		getLocation()[1] = lon;
		return this;
	}
}
