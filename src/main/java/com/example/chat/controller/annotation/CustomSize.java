package com.example.chat.controller.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.chat.controller.annotation.impl.CustomSizeImpl;

/**
 * 桁数チェックバリデーター
 * 
 * @author tk
 */
@Target({ElementType.FIELD})
@Constraint(validatedBy={CustomSizeImpl.class})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomSize {

	String message() default "{validation.CustomSize}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	int min();
	
	int max();
}
