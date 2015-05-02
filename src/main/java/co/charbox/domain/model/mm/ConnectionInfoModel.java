package co.charbox.domain.model.mm;

import lombok.Data;

import com.maxmind.geoip2.model.InsightsResponse;

@Data
public class ConnectionInfoModel {
	
	private MyCharboxLocation location;
	private MyCharboxConnection connection;
	
	public ConnectionInfoModel() { }
	
	public ConnectionInfoModel(InsightsResponse insights) {
		this.location = MyCharboxLocation.builder()
				.continent(insights.getContinent().getName())
				.country(insights.getCountry().getName())
				.subdivision(insights.getMostSpecificSubdivision().getName())
				.zip(insights.getPostal().getCode())
				.city(insights.getCity().getName())
				.location(new double[]{ insights.getLocation().getLatitude(), insights.getLocation().getLongitude() })
				.timeZone(insights.getLocation().getTimeZone())
				.build();
			
		
		this.connection = MyCharboxConnection.builder()
				.ip(insights.getTraits().getIpAddress())
				.isp(insights.getTraits().getIsp())
				.anonProxy(insights.getTraits().isAnonymousProxy())
				.satelliteProvider(insights.getTraits().isSatelliteProvider())
				.build();
	}
}
