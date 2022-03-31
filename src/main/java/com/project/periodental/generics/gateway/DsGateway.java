package com.project.periodental.generics.gateway;

import java.util.List;

/**
 * Define los métodos de como se obtienen los datos desde la fuente de datos (base de datos)
 * @author djimenez on 28/3/2022
 * periodental
 */
public interface DsGateway<T,ID> {

    /**
     * Devuelve un elemento basado en Id
     * @param id Id del elemento
     * @return Elemento en base a su Id
     */
    T findById(ID id);

    /**
     * Devuelve una lista de elementos
     * @return Una lista de elementos
     */
    List<T> findAll();
}
