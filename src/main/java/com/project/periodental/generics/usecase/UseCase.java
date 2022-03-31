package com.project.periodental.generics.usecase;

/**
 * Clase abstracta para construir casos de uso
 * @author djimenez on 28/3/2022
 * periodental
 */
public abstract class UseCase<T> {

    /**
     * Retorna una respuesta al ejecutar el caso de uso
     * @return Una respuesta dada por el caso de uso
     */
    public abstract T execute();
}
