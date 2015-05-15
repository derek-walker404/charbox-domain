package co.charbox.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimerResult implements IPersistentModel<TimerResult, String> {

	private String id = "";
	private long startTime;
	private long duration;
	private long pingDuration;
	private String testCaseId;
	private boolean outage = false;
	private MyLocation serverLocation = MyLocation.builder().ip("").build();
	private MyLocation clientLocation = MyLocation.builder().ip("").build();
	private long size;
	private double speed;
	private int deviceId;
}
