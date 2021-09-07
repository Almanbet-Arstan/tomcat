package org.example.service;

import org.example.dao.TaskDao;
import org.example.dao.daoImpl.TaskDaoImpl;
import org.example.model.ResponseModel;
import org.example.model.TaskModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/task")
public class TaskService {

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseModel save(TaskModel taskModel){
        TaskDao taskDao = new TaskDaoImpl();
        if(taskDao.save(taskModel)){
            return ResponseModel.builder()
                    .data(null)
                    .isSuccess(true)
                    .message("Успех")
                    .build();
        }
        return ResponseModel.builder()
                .data(null)
                .isSuccess(false)
                .message("FAIL")
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseModel getById(@PathParam("id") Long id){
        TaskDao taskDao = new TaskDaoImpl();
        return ResponseModel.builder()
                .data(taskDao.findById(id))
                .isSuccess(true)
                .message("SUCCESS")
                .build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseModel getAll(){
        TaskDao taskDao = new TaskDaoImpl();
        return ResponseModel.builder()
                .isSuccess(true)
                .data(taskDao.findAll())
                .message("Успех")
                .build();
    }
}