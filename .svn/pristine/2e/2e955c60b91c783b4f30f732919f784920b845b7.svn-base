package com.supinfo.supcrowdfunder.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Project;

@Path("/projects")
public class ProjectResource {

	private ProjectDao projDao = DaoFactory.getInstance().getProjectDao();
	
	@GET @Produces(MediaType.APPLICATION_XML)
	public List<Project> getAllProjectsXml(){
		return projDao.getAllProjects();
	}
	
	@GET @Produces(MediaType.APPLICATION_XML)
	@Path("/{id}")
	public Project getProjectXml(@PathParam("id") long id){
		return projDao.getProjectById(id);
	}
	
	@POST @Consumes(MediaType.APPLICATION_XML)
	public Response addStudent(Project project) {
	      projDao.equals(project);
	      String projectUri = "/"+project.getProjectId();
	      return Response.created(URI.create(projectUri)).build();
	}
}