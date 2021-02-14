package de.nikos410.fpr.vehiclemanagement.model.repository;

import de.nikos410.fpr.vehiclemanagement.model.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T extends BaseEntity> {
    Collection<T> findAll();

    Optional<T> findOneById(long id);

    void add(T newEntity);

    void update(T updatedEntity);
}
