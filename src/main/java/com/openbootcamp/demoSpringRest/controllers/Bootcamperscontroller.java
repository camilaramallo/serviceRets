package com.openbootcamp.demoSpringRest.controllers;

import com.openbootcamp.demoSpringRest.models.Bootcamper;
import com.openbootcamp.demoSpringRest.services.BootcamperService;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Component
@Path("/")
public class Bootcamperscontroller {
    private final BootcamperService bootService;

    public Bootcamperscontroller(BootcamperService bootService){
        this.bootService = bootService;

        this.bootService.add(new Bootcamper("uno"));
        this.bootService.add(new Bootcamper("dos"));
        this.bootService.add(new Bootcamper("tres"));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<Bootcamper> listartodos(){
        return bootService.getAll();
    }
}
