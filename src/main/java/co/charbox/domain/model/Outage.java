package co.charbox.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Outage implements IPersistentModel<Outage, String> {

	private String id;
	private String deviceId;
	private DateTime startTime;
	private DateTime endTime;
	private long duration;
	private boolean confirmed = false;
}
