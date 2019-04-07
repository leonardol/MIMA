package com.mima.machine.service;

import com.mima.machine.service.dto.TaskDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Task.
 */
public interface TaskService {

    /**
     * Save a task.
     *
     * @param taskDTO the entity to save
     * @return the persisted entity
     */
    TaskDTO save(TaskDTO taskDTO);

    /**
     * Get all the tasks.
     *
     * @return the list of entities
     */
    List<TaskDTO> findAll();
    
    /**
     * Get all the tasks of a machine.
     *
     * @return the list of entities
     */
    List<TaskDTO> findAllByIdMachine(long idMachine);


    /**
     * Get the "id" task.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<TaskDTO> findOne(Long id);

    /**
     * Delete the "id" task.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
