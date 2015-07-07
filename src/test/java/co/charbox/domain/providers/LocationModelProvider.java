package co.charbox.domain.providers;

import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.LocationModel;

@Component
public class LocationModelProvider implements CharbotModelProvider<LocationModel> {

	@Override
	public LocationModel getModel(Integer id) {
		return LocationModel.builder()
				.id(id)
				.city("Atlanta")
				.continent("North America")
				.country("United States")
				.lat(100.0)
				.lon(-100.0)
				.subdivision("Georgia")
				.timeZone("Eastern")
				.zip("30361")
				.build();
	}
}
