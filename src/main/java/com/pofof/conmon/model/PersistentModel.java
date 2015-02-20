package com.pofof.conmon.model;

public interface PersistentModel<ModelT> {

	String get_id();
	
	ModelT set_id(String id);
}
