package com.project.periodental.generics.presenter;

import java.util.List;

/**
 * Define los métodos genericos para las vistas de respuestas
 * @author djimenez on 28/03/2022
 * periodental
 */
public interface Presenter<T> {

    /**
     * Devuelve una lista satisfactoria a una solicitud
     * @param responses Respuestas
     * @return Una lista con respuesta satisfactorias
     */
    List<T> prepareAllSuccessView(List<T> responses);

    /**
     * Retorna una respuesta satisfactoria a una solicitud
     * @param response Respuesta
     * @return Una respuesta a la solicitud realizada
     */
    T prepareSuccessView(T response);

    /**
     * Devuelve una respuesta no satisfactoria con un mesnsaje de error
     * @param error Mensaje de error
     * @return Respuesta no satisfactoria
     */
    T prepareFailView(String error);
}
