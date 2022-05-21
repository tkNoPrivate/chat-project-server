package com.example.chat.controller.annotation.impl;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.example.chat.controller.annotation.HalfAlphanumericSymbol;

/**
 * 半角英数字記号チェックバリデーター実装
 * 
 * @author tk
 */
public class HalfAlphanumericSymbolImpl implements ConstraintValidator<HalfAlphanumericSymbol, String> {

	/** 正規表現_半角英数字記号 */
	private static Pattern pattern = Pattern.compile("^[a-zA-Z0-9 -/:-@\\[-\\`\\{-\\~]+$");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (StringUtils.isEmpty(value)) {
			return true;
		}

		return pattern.matcher(value).matches();
	}

}
