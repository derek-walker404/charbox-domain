package co.charbox.domain.model;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Heartbeat implements IPersistentModel<Heartbeat, String> {

	private String id;
	private String deviceId;
	private DateTime time;
}
