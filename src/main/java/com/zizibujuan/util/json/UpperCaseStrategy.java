package com.zizibujuan.util.json;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase;

public class UpperCaseStrategy extends PropertyNamingStrategyBase{

	private static final long serialVersionUID = -4026899649446970771L;

	@Override
	public String translate(String propertyName) {
		return propertyName.toUpperCase();
	}

}
