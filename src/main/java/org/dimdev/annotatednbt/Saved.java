package org.dimdev.annotatednbt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // TODO: split annotation, error when set on field but not containing class
@Retention(RetentionPolicy.SOURCE)
public @interface Saved {}
