package com.project.periodental.adapter.converter.modelmapper;

import io.activej.inject.annotation.Inject;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public class EntityDtoConverter {

    private final ModelMapper modelMapper;

    @Inject
    public EntityDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <E,D> D convertEntityToDto(E entity, Class<D> clazz) {
        return modelMapper.map(entity, clazz);
    }

    public <E,D> List<D> convertEntitiesToDto(List<E> entities, Class<D> clazz) {
        return entities.stream().map(mapper -> convertEntityToDto(mapper, clazz))
                .collect(Collectors.toList());
    }
}
