package co.charbox.domain.model;

import lombok.Builder;
import lombok.Data;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
public class Heartbeat implements IPersistentModel<Heartbeat, String> {

	private String id;
	private int deviceId;
	private long time;
}
