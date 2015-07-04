package co.charbox.domain.model;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import co.charbox.domain.model.mm.ConnectionInfoModel;
import co.charbox.domain.model.mm.SimpleLocationModel;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SstResultsModel implements IPersistentModel<SstResultsModel, Integer> {

	private Integer id;
	private DeviceModel device;
	private String deviceToken;
	private DateTime startTime; 
	private long downloadSize;
	private int downloadDuration;
	private double downloadSpeed;
	private long uploadSize;
	private int uploadDuration;
	private double uploadSpeed;
	private int pingDuration;
	private ConnectionInfoModel deviceInfo;
	private SimpleLocationModel serverLocation;
}
