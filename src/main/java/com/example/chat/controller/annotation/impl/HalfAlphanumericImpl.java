package com.example.chat.controller.annotation.impl;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.example.chat.controller.annotation.HalfAlphanumeric;

/**
 * 半角英数字チェックバリデーター実装
 * 
 * @author tk
 */
public class HalfAlphanumericImpl implements ConstraintValidator<HalfAlphanumeric, String> {

	/** 正規表現_半角英数字記号 */
	private static Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (StringUtils.isEmpty(value)) {
			return true;
		}

		return pattern.matcher(value).matches();
	}

}
