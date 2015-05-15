package co.charbox.domain.model.mm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyCharboxConnection {

	private String isp;
	private String ip;
	private boolean anonProxy;
	private boolean satelliteProvider;
	private String conType = "N/A";
	private double expectedSpeed = 50; // Mbps
}
