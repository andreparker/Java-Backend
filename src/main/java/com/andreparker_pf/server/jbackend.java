package com.andreparker_pf.server;

/**
 * Created by andre on 5/11/15.
 */

import org.glassfish.grizzly.http.server.HttpServer;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


import java.net.URI;

public class jbackend {

    private jbackend()
    {}

    public static final String RESTFUL_URL = "http://localhost:8080/api/";

    public static void main(String[] args) throws Exception
    {
        ResourceConfig rc = new ResourceConfig();
        rc.packages("com.andreparker_pf.api");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(RESTFUL_URL), rc);
        System.out.println("Press enter to stop...");
        System.in.read();
        server.shutdown();
    }
}
