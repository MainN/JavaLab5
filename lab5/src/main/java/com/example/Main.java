package com.example;

import com.example.interfaces.NumberGenerator;
import com.example.qualifies.Digits;
import com.example.qualifies.NumberOfDigits;
import io.quarkus.runtime.Application;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/test")
@ApplicationScoped
public class Main {

    @Inject @NumberOfDigits(Digits.EIGHT)
    NumberGenerator generatorEight;

    @Inject
    NumberGenerator generatorFive;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/callEight")
    public String callGeneratorEight() {
        return generatorEight.generateNumber();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/callFive")
    public String callGeneratorFive() {
        return generatorFive.generateNumber();
    }

    @Inject
    Instance <NumberGenerator> generators;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/getImpl")
    public String getImpl() {
        StringBuilder sb = new StringBuilder();
        for (NumberGenerator generator: generators) {
            sb.append(generator.toString());
        }
        return sb.toString();
    }
}
