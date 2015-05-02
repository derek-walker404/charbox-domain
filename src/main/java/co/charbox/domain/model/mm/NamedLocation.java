package co.charbox.domain.model.mm;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NamedLocation {

	private String name;
	private String isoCode;
}
