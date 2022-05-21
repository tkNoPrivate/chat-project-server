package com.example.chat.controller.annotation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.example.chat.controller.annotation.CustomSize;

/**
 * 桁数チェックバリデーター実装
 * 
 * @author tk
 */
public class CustomSizeImpl implements ConstraintValidator<CustomSize, String> {

	/** 最小桁数 */
	private int min;
	
	/**最大桁数*/
	private int max;
	
	@Override
	  public void initialize(CustomSize customSize) {
		min = customSize.min();
	    max = customSize.max();
	  }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (StringUtils.isEmpty(value)) {
			return true;
		}

		int valueSize = value.length();
		return valueSize >= min && valueSize <= max;
	}

}
