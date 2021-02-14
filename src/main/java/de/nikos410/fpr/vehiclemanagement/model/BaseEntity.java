package de.nikos410.fpr.vehiclemanagement.model;

/**
 * A basic class which describes an entity that is identified by an id.
 *
 * Other entities should be based on this class.
 */
public abstract class BaseEntity {
    private long id;

    /**
     * Return the id that identifies this entity.
     *
     * @return the id that identifies this entity.
     */
    public long getId() {
        return id;
    }

    /**
     * Set the id that identifies this entity.
     *
     * @param id the id that identifies this entity.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Concrete entities should override this by comparing their id. This is not done here because this class can
     * be used as the base for many different things. For example, a person and a vehicle with the id 42 should not
     * be equal.
     *
     * @param obj the reference object with which to compare.
     * @return true if this object has the same id as the obj argument; false otherwise.
     */
    @Override
    public abstract boolean equals(Object obj);

    /**
     * Implemented according to Effective Java - 3rd edition, item 11.
     *
     * @return the hash code value for this object.
     */
    @Override
    public final int hashCode() {
        return Long.hashCode(getId());
    }
}
