package com.project.periodental.generics.usecase;

/**
 * Caso de uso que toma un parámetro en concreto
 * @author djimenez on 28/3/2022
 * periodental
 */
public abstract class UseCaseWithParam<T,P> {

    /**
     * Devuelve una respuesta dado el parámetro
     * @param param Parametro que recibe el caso de usi
     * @return Respuesta del caso de uso
     */
    public abstract T execute(P param);
}
