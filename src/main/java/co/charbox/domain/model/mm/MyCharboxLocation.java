package co.charbox.domain.model.mm;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyCharboxLocation {

	private String continent;
	private String country;
	private String city;
	private String subdivision;
	private String zip;
	private double[] location;
	private String timeZone;
}
