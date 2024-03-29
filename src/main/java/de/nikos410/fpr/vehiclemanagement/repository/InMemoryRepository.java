package de.nikos410.fpr.vehiclemanagement.repository;

import de.nikos410.fpr.vehiclemanagement.model.BaseEntity;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * A basic {@link Repository} implementation that keeps data in memory and does not persist anything.
 *
 * @param <T> the datatype contained in this repository.
 */
public abstract class InMemoryRepository<T extends BaseEntity> implements Repository<T> {

    protected final Set<T> content = new HashSet<>();

    /**
     * {@inheritDoc}
     *
     * @return a {@link Set} containing all elements in this repository.
     */
    @Override
    public Set<T> findAll() {
        // Return a new instance to prevent exposing the internal set.
        return new HashSet<>(content);
    }

    @Override
    public Optional<T> findOneById(long id) {
        return content.stream()
                .filter(e -> id == e.getId())
                .findAny();
    }

    @Override
    public void add(T newEntity) {
        final boolean added = content.add(newEntity);
        if (!added) {
            throw new IllegalArgumentException(MessageFormat.format("Element with id {0} already exists.", newEntity.getId()));
        }
    }

    /**
     * {@inheritDoc}
     * <br>
     * <strong>This is a No-Op for this repository type, since no data is persisted.</strong>
     *
     * @param updatedEntity The entity to update.
     */
    @Override
    public void update(T updatedEntity) {
        // No-Op for this repository type, since no data is persisted.
    }

    @Override
    public void remove(long id) {
        final T toDelete = findOneById(id).orElseThrow(() -> new IllegalArgumentException(MessageFormat.format("Element with id {0} is not present.", id)));
        content.remove(toDelete);
    }
}
