package com.supinfo.supcrowdfunder.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.supinfo.supcrowdfunder.dao.CategoryDao;
import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.entity.Category;

@Path("/categories")
public class CategoryResource {

	private CategoryDao catDao = DaoFactory.getInstance().getCategoryDao();
	
	@GET @Produces(MediaType.APPLICATION_XML)
	public List<Category> getAllCategoriesXml(){
		return catDao.getAllCategories();
	}
	
	@GET @Produces(MediaType.APPLICATION_XML)
	@Path("/{id}")
	public Category getCategoryByIdXml(@PathParam("id") long id){
		return catDao.getCategoryById(id);
	}
}