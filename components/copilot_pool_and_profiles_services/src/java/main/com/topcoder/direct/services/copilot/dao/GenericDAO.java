/*
 * Copyright (C) 2010 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.direct.services.copilot.dao;

import com.topcoder.direct.services.copilot.model.IdentifiableEntity;

import java.util.List;

/**
 * <p>This interface represents a generic DAO for managing entities in persistence. It defines methods for creating,
 * updating, deleting and retrieving entities to/from persistence.</p>
 *
 * <p><strong>Thread safety:</strong> Implementations of this interface must be thread safe when entities passed to them
 * are used by the caller in thread safe manner.</p>
 *
 * @author saarixx, TCSDEVELOPER
 * @version 1.0
 * @param <T> the type of the entity to be managed by this DAO
 */
public interface GenericDAO<T extends IdentifiableEntity> {

    /**
     * <p>Creates the given entity in the persistence.</p>
     *
     * @param entity the entity to be created in the persistence
     *
     * @return the generated entity ID
     *
     * @throws IllegalArgumentException if entity is null
     * @throws CopilotDAOException      if some other error occurred
     */
    long create(T entity) throws CopilotDAOException;

    /**
     * <p>Updates the given entity in the persistence.</p>
     *
     * @param entity the entity to be updated in the persistence
     *
     * @throws IllegalArgumentException if entity is null or entity.getId() <= 0
     * @throws EntityNotFoundException  if entity with the same ID cannot be found in the persistence
     * @throws CopilotDAOException      if some other error occurred
     */
    void update(T entity) throws CopilotDAOException;

    /**
     * <p>Deletes an entity with the given ID from the persistence.</p>
     *
     * @param entityId the ID of the entity to be deleted
     *
     * @throws IllegalArgumentException if entityId <= 0
     * @throws EntityNotFoundException  if entity with the given ID doesn't exist in the persistence
     * @throws CopilotDAOException      if some other error occurred
     */
    void delete(long entityId) throws CopilotDAOException;

    /**
     * <p>Retrieves an entity from persistence by its ID. Returns null if entity with the given ID is not found.</p>
     *
     * @param entityId the ID of the entity to be retrieved
     *
     * @return the entity with the specified ID retrieved from the persistence or null if not found
     *
     * @throws IllegalArgumentException if entityId <= 0
     * @throws CopilotDAOException      if some other error occurred
     */
    T retrieve(long entityId) throws CopilotDAOException;

    /**
     * <p>Retrieves all entities from the persistence. Returns an empty list if no entities are found.</p>
     *
     * @return the list of entities found in the persistence (not null, doesn't contain null)
     *
     * @throws CopilotDAOException if any error occurred
     */
    List<T> retrieveAll() throws CopilotDAOException;
}

