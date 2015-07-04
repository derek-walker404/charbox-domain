package co.charbox.domain.model.mm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.maxmind.geoip2.model.InsightsResponse;
import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionInfoModel implements IPersistentModel<ConnectionInfoModel, Integer> {
	
	private Integer id;
	private LocationModel location;
	private ConnectionModel connection;
	
	public ConnectionInfoModel(InsightsResponse insights) {
		this.location = LocationModel.builder()
				.continent(insights.getContinent().getName())
				.country(insights.getCountry().getName())
				.subdivision(insights.getMostSpecificSubdivision().getName())
				.zip(insights.getPostal().getCode())
				.city(insights.getCity().getName())
				.lat(insights.getLocation().getLatitude())
				.lon(insights.getLocation().getLongitude())
				.timeZone(insights.getLocation().getTimeZone())
				.build();
			
		
		this.connection = ConnectionModel.builder()
				.ip(insights.getTraits().getIpAddress())
				.isp(insights.getTraits().getIsp())
				.build();
	}
}
