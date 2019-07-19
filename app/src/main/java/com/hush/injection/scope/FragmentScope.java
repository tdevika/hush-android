package com.hush.injection.scope;

import java.lang.annotation.Documented;

import javax.inject.Scope;

/** Dagger scope for dependencies that should only have a single instance created per fragment. */
@Scope
@Documented
public @interface FragmentScope {}
