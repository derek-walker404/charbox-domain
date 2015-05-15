package co.charbox.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyLocation {

	@NonNull private String ip;
	private double[] location;

	public MyLocation setLat(double lat) {
		getLocation()[0] = lat;
		return this;
	}

	public MyLocation setLon(double lon) {
		getLocation()[1] = lon;
		return this;
	}
	
	public double[] getLocation() {
		if (location == null) {
			location = new double[2];
		}
		return location;
	}
}
