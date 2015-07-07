package co.charbox.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

import co.charbox.domain.model.mm.ConnectionInfoModel;
import co.charbox.domain.model.mm.SimpleLocationModel;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PingResultModel implements IPersistentModel<PingResultModel, Integer> {

	private Integer id;
	private DeviceModel device;
	private ConnectionInfoModel connectionInfo;
	private SimpleLocationModel serverLocation;
	private DateTime startTime;
	private String uri;
	private double packetLoss;
	private double minLatency;
	private double avgLatency;
	private double maxLatency;
}
