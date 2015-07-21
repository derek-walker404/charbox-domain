package co.charbox.domain.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import co.charbox.domain.model.RoleModel;
import co.charbox.domain.model.auth.AdminAuthModel;
import co.charbox.domain.model.auth.SystemAuthModel;

import com.tpofof.core.data.dao.context.PrincipalSearchContext;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSort;
import com.tpofof.core.security.IAuthModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharbotSearchContext implements PrincipalSearchContext<RoleModel> {

	private SearchWindow window;
	private SimpleSort sort;
	private IAuthModel<RoleModel> principal;
	
	public static CharbotSearchContext getAdminContext() {
		return CharbotSearchContext.builder()
				.principal(new AdminAuthModel())
				.build();
	}
	
	public static CharbotSearchContext getSystemContext() {
		return CharbotSearchContext.builder()
				.principal(new SystemAuthModel())
				.build();
	}
}
