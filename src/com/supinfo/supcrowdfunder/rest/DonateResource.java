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
import com.supinfo.supcrowdfunder.dao.DonateDao;
import com.supinfo.supcrowdfunder.entity.Donate;

@Path("/donations")
public class DonateResource {

	private DonateDao donateDao = DaoFactory.getInstance().getDonateDao();
	
	@GET @Produces(MediaType.APPLICATION_XML)
	@Path("/{projId}")
	public List<Donate> getDonationByProjectXml(@PathParam("projId") long projectId){
		return donateDao.getDonationsByProject(projectId);
	}
	
	@POST @Consumes(MediaType.APPLICATION_XML)
	public Response addDonation(Donate donate) {
	      donateDao.addDonate(donate);
	      String projectUri = "/"+donate.getDonateId();
	      return Response.created(URI.create(projectUri)).build();
	}
}