package co.charbox.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

import co.charbox.domain.model.mm.ConnectionInfoModel;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeartbeatModel implements IPersistentModel<HeartbeatModel, Integer> {

	private Integer id;
	private DeviceModel device;
	private DateTime time;
	private ConnectionInfoModel connection;
}
