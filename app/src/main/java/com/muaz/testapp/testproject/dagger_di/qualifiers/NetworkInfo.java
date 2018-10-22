package com.muaz.testapp.testproject.dagger_di.qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by muazekici on 16.07.2018.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface NetworkInfo {
}
