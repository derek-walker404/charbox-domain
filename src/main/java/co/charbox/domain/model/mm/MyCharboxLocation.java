package co.charbox.domain.model.mm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyCharboxLocation {

	private String continent;
	private String country;
	private String city;
	private String subdivision;
	private String zip;
	private double[] location;
	private String timeZone;
}
