/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.resource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Application;
import org.secnod.shiro.jersey.AuthInjectionBinder;
import org.secnod.shiro.jersey.AuthorizationFilterFeature;
import org.secnod.shiro.jersey.SubjectFactory;

/**
 *
 * @author ABCD-user
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    private static final Logger log = java.util.logging.Logger.getLogger(ApplicationConfig.class.getName());

    /**
     * This is how the Jersey - Jackson serialize the object returned as
     * Response Object @see:
     *
     * @return
     */
    @Override
    public Set<Object> getSingletons() {
        Set<Object> set = new HashSet<>();
        log.log(Level.INFO, "Enabling custom Jackson JSON provider");
        set.add(new JacksonJsonProvider().configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(DeserializationFeature.WRAP_EXCEPTIONS, true)
        );
        set.add(new AuthorizationFilterFeature());
        set.add(new SubjectFactory());
        set.add(new AuthInjectionBinder());
        return set;
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> map = new HashMap<>();
        //May not be needed
        //log.log(Level.INFO, "Disabling MOXy JSON provider: see ApplicationConfig::getPropriesties()");
        //map.put("jersey.config.disableMoxyJson.server", true);
        return map;
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.equinooxe.controller.TestController.class);
        resources.add(com.equinooxe.resource.CORSResponseFilter.class);
        resources.add(com.equinooxe.resource.GenericExceptionMapper.class);
        resources.add(com.equinooxe.resource.user.UserResource.class);
        resources.add(com.equinooxe.security.resource.AuthResource.class); 
    }

}
