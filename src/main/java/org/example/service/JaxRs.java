package org.example.service;

import org.example.dao.userDao;
import org.example.dao.userDaoImpl;
import org.example.model.Time;
import org.example.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/jax-rs")
public class JaxRs {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTime(){
        Time time = new Time();
        return Response.ok().entity(time).build();
    }
    @POST
    @Path("/{num1}/{num2}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSum(@PathParam("num2") int num2, @PathParam("num1") int num1){
        return Response.ok().entity(num1 + num2).build();
    }
    @POST
    @Path("/saveUser")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response save(User user){
        userDao userDao = new userDaoImpl();
        user = userDao.saveUser(user);
        String out;
        if(user != null){
            if (user.getPassword().length() > 4){
                out = "Данные приняты, ваш код: " + user.hashCode();
            }
            out = "Слишком короткий пароль";
        }else out = "Не верный ввод данных";
        return Response.ok().entity(out).build();
    }
    @GET
    @Path("/getUser")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll(){
        userDao userDao = new userDaoImpl();
        List<User> allUsers = userDao.getAll();
        return Response.ok().entity(allUsers).build();
    }
}
