package co.charbox.domain.model;

import lombok.Builder;
import lombok.Data;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
public class TimerResult implements IPersistentModel<TimerResult, String> {

	private String id = "";
	private long startTime;
	private long duration;
	private long pingDuration;
	private String testCaseId;
	private boolean outage = false;
	private MyLocation serverLocation = new MyLocation();
	private MyLocation clientLocation = new MyLocation();
	private long size;
	private double speed;
	private int deviceId;
}
