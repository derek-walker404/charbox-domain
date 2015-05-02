package co.charbox.domain.model.mm;

import lombok.Builder;
import lombok.Data;
import co.charbox.domain.model.MyLocation;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
public class SSTResults implements IPersistentModel<SSTResults, String> {

	private String id;
	private String deviceId;
	private String deviceKey;
	private long testStartTime; 
	private int downloadSize;
	private int downloadDuration;
	private double downloadSpeed;
	private int uploadSize;
	private int uploadDuration;
	private double uploadSpeed;
	private int pingDuration;
	private ConnectionInfoModel deviceInfo;
	private MyLocation serverLocation;
}
