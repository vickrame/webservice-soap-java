package com.prios.ws.web.rest;

import java.security.Principal;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.xml.ws.WebServiceContext;

import com.prios.ws.entity.PersonneRest;
import com.prios.ws.helper.UserWSRole;
import com.services.ReservationService;


@Path("/reservation")
@RolesAllowed({"TEST_WS_ALL", "TEST_WS_CONSULT", "TEST_WS_WRITE"})
public class ReservationRestAPI {

	@Context
	private SecurityContext context;
	
	
	@Resource
	private WebServiceContext serviceContext;
	
	
	
	@EJB
	private ReservationService resa ;
	
	@GET
    @Produces({"application/xml", "application/octect-stream"})
	@Path("/admin/all")
	@RolesAllowed("TEST_WS_CONSULT")
    public Response findAll() {

		Principal p = context.getUserPrincipal();
		
		System.out.println("p " + p);
		System.out.println("consult ? " + context.isUserInRole(UserWSRole.CONSULT.getRole()));
		System.out.println("write ? " + context.isUserInRole(UserWSRole.ECRITURE.getRole()));
		
		PersonneRest pers = new PersonneRest();
		pers.setId("123456");
		pers.setNom("NOM");
		pers.setPrenom("PRENOM");


        return Response.ok(pers).build();
    } 
	
//	@GET
//    @Produces({"application/xml", "application/octect-stream"})
//	@Path("/get/{id}")
//    public Response findById(@QueryParam("id") String id) {
//		Personne pers = new Personne();
//		pers.setId("123456");
//		pers.setNom("NOM");
//		pers.setPrenom("PRENOM");
//
//		CacheControl cache = new CacheControl();
//		cache.setMaxAge(-1);
//		
//		
//		ResponseBuilder builderResponse = new ResponseBuilderImpl();
//		builderResponse.cacheControl(cache);
//		
//		pers.setPhoto(new DataHandler(new FileDataSource(new File("C:\\Dev\\test.pdf"))));
//
//		builderResponse.status(200);
//		return builderResponse.entity(pers).build();
////		return builderResponse.build().ok(pers);
////        return Response.ok(pers).build();
//    } 
	
//	@GET
//    @Produces({"application/xml", "application/octect-stream"})
//	@Path("/get")
//	public Response find(@MatrixParam Personne pers){
//		return Response.ok(pers).build();
//	}

}
