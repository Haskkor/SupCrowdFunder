package com.supinfo.supcrowdfunder.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;

@Path("/users")
public class UserResource {

	private UserDao userDao = DaoFactory.getInstance().getUserDao();
		
	@GET @Produces(MediaType.APPLICATION_XML)
	@Path("/{email}")
	public User getUserByMailXml(@PathParam("email") String mail){
		return userDao.getUserByEmail(mail);
	}
	
	@GET @Produces(MediaType.APPLICATION_XML)
	public List<User> getAllUsersXml(){
		return userDao.getAllUsers();
	}
	
	@POST @Consumes(MediaType.APPLICATION_XML)
	public Response addUser(User user) {
	      userDao.addUser(user);
	      String userUri = "/"+user.getUserId();
	      return Response.created(URI.create(userUri)).build();
	}
	
	@PUT @Consumes(MediaType.APPLICATION_XML)
	public Response editUser(User user) {
		userDao.updateUser(user);
		String userUri = "/"+user.getUserId();
		return Response.created(URI.create(userUri)).build();
	}
}