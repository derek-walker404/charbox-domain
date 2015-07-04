package co.charbox.domain.model.mm;

import com.tpofof.core.data.IPersistentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleLocationModel implements IPersistentModel<SimpleLocationModel, Integer> {

	private Integer id;
	@NonNull private String ip;
	private Double lat;
	private Double lon;
}
