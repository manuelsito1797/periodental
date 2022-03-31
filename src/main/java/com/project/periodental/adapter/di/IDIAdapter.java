package com.project.periodental.adapter.di;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public interface IDIAdapter {

    <T> T getInstance(Class<T> clazz);
}
