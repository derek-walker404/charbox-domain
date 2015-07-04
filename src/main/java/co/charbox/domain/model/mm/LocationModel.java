package co.charbox.domain.model.mm;

import com.tpofof.core.data.IPersistentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationModel implements IPersistentModel<LocationModel, Integer> {

	private Integer id;
	private String continent;
	private String country;
	private String city;
	private String subdivision;
	private String zip;
	private Double lat;
	private Double lon;
	private String timeZone;
}
