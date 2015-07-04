package co.charbox.domain.model.mm;

import com.tpofof.core.data.IPersistentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionModel implements IPersistentModel<ConnectionModel, Integer> {

	private Integer id;
	private String isp;
	private String ip;
	private double expectedSpeed; // Mbps
}
