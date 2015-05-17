package co.charbox.domain.model;

import org.joda.time.DateTime;

import com.tpofof.core.data.IPersistentModel;

import co.charbox.domain.model.mm.ConnectionInfoModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PingResults implements IPersistentModel<PingResults, String> {

	private String id;
	private String deviceId;
	private DateTime testStartTime;
	private int packetSize;
	private String uri;
	private int packetCount;
	private double packetLoss;
	private double minLatency;
	private double avgLatency;
	private double maxLatency;
	private double latencyStdDev;
	private ConnectionInfoModel connectionInfo;
}
