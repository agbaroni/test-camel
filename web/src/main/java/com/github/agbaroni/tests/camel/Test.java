package com.github.agbaroni.tests.camel;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.jboss.logging.Logger;

@Consumes(MediaType.TEXT_PLAIN)
@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class Test {

    private static final Logger logger = Logger.getLogger(Test.class);

    @Inject
    private CamelContext camelContext;

    @Inject
    private Bean1 bean;

    @POST
    public void test(String text) {
        ProducerTemplate producer = camelContext.createProducerTemplate();

        producer.requestBody("direct:enter", text, String.class);

        logger.info("TEXT: " + bean.getText());
    }
}
