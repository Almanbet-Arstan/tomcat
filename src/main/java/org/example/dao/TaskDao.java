package org.example.dao;

import org.example.model.TaskModel;

import java.util.List;

public interface TaskDao {
    boolean save(TaskModel taskModel);
    List<TaskModel> findAll();
    TaskModel findById(Long id);
    boolean delete(Long id);

}
