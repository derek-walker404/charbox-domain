package co.charbox.domain.model;

import lombok.Builder;
import lombok.Data;

import org.joda.time.DateTime;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
public class Outage implements IPersistentModel<Outage, String> {

	private String id;
	private String deviceId;
	private DateTime outageTime;
}
