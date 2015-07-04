package co.charbox.domain.data;

import org.springframework.beans.factory.annotation.Autowired;

import com.tpofof.core.bootstrap.Initializable;
import com.tpofof.core.data.dao.jdbc.JooqConnectionProvider;
import com.tpofof.core.utils.Config;

public class MysqlInitializer implements Initializable {

	@Autowired private JooqConnectionProvider connPro;
	@Autowired private Config config;
	
	@Override
	public boolean init() {
		
		return false;
	}

}
