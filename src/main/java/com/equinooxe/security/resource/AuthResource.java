/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.security.resource;

import com.equinooxe.domain.User;
import com.equinooxe.service.AuthentificationService;
import com.equinooxe.service.UserService;
import com.equinooxe.resource.user.BasicUserAuthDto;
import com.equinooxe.service.UserService;
import com.equinooxe.service.impl.AuthentificationServiceImpl;
import com.equinooxe.service.impl.UserServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mohamed
 */
@Path("/auth")
public class AuthResource {

    private AuthentificationService userAuth = new AuthentificationServiceImpl();
    private UserService userService = new UserServiceImpl();

    public AuthResource() {
    }

    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(BasicUserAuthDto dto) {
        return Response.status(Response.Status.OK)
                .entity(userService.register(dto.getUsername(), dto.getUsername(), dto.getPassword()))
                .build();
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(BasicUserAuthDto uAuthObject) {
        if (userAuth.login(uAuthObject)) {
            User user = userService.getAuthentificatedUser();
            return Response.status(Response.Status.OK).entity(user).build();
        }
        return Response.status(Response.Status.FORBIDDEN).entity("BadCredentials").build();
    }   

    @Path("/logout")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() {
        userAuth.logout();
        return Response.status(Response.Status.OK).entity("Logout success").build();
    }

    @Path("/ping")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response pingPublic() {
        return Response.status(Response.Status.OK).entity("Public area acces is OK").build();
    }

    public boolean checkUserAuth(BasicUserAuthDto uAuthObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean checkUserAuthByEmail(String userEmail) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
