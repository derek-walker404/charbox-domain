package co.charbox.domain.model.mm;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyCharboxConnection {

	private String isp;
	private String ip;
	private boolean anonProxy;
	private boolean satelliteProvider;
	private String conType = "N/A";
	private double expectedSpeed = 50; // Mbps
}
