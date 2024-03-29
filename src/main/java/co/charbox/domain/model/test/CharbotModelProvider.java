package co.charbox.domain.model.test;

import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.data.dao.test.IModelProvider;

public interface CharbotModelProvider<ModelT extends IPersistentModel<ModelT, Integer>> extends IModelProvider<ModelT, Integer> {

}
