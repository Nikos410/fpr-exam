package de.nikos410.fpr.vehiclemanagement.model.repository;

import de.nikos410.fpr.vehiclemanagement.model.BaseEntity;

import java.util.Collection;
import java.util.Optional;

/**
 * Provides a standardized way of storing and accessing entities.
 *
 * @param <T> the datatype contained in this repository.
 */
public interface Repository<T extends BaseEntity> {

    /**
     * Returns all elements in this repository.
     *
     * @return a collection containing all elements in this repository.
     */
    Collection<T> findAll();

    /**
     * Returns a specific element if it is present in this repository.
     *
     * @param id the id of the element to return.
     * @return an Optional containing the element with the given id, or an empty Optional if the element is not present
     * in this repository.
     */
    Optional<T> findOneById(long id);

    /**
     * Adds a new element to this repository.
     *
     * The element must not be present in this repository already. If it is use {@link #update}
     *
     * @param newEntity the element to add to this repository.
     */
    void add(T newEntity);

    /**
     * Updates the data described in this entity. For example, a database-based repository should persist the data to
     * the database.
     *
     * The element must be present in this repository already. If it isn't use {@link #add}
     *
     * @param updatedEntity The entity to update.
     */
    void update(T updatedEntity);
}
