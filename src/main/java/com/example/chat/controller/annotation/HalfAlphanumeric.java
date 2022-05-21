package com.example.chat.controller.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.chat.controller.annotation.impl.HalfAlphanumericImpl;

/**
 * 半角英数字チェックバリデーター
 * 
 * @author tk
 */
@Target({ElementType.FIELD})
@Constraint(validatedBy={HalfAlphanumericImpl.class})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HalfAlphanumeric {

	String message() default "{validation.HalfAlphanumeric}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
