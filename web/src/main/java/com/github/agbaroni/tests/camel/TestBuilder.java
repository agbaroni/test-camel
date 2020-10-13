package com.github.agbaroni.tests.camel;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class TestBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:enter").to("bean:bean?method=setText");
    }
}
