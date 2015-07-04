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
public class OutageModel implements IPersistentModel<OutageModel, Integer> {

	private Integer id;
	private DeviceModel device;
	private DateTime startTime;
	private DateTime endTime;
	private long duration;
	private boolean confirmed = false;
	private String type;
	private ConnectionInfoModel connectionInfo;
}
