package com.pragma.notification.infrastructure.mappers;

public interface Mapper<E, M> {
    E toEntity(M model);
    M toModel(E entity);
}