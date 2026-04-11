package com.kireygroup.camel.k8s.route;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class IntegrationRoute extends EndpointRouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from(timer("timer").period(1000))
			.routeId("timerRoute")
			.log("What {{configmap:my-config/drink}} do you want?")
			.log("I want {{configmap:my-config/first}}")
			.log("This is my supersecret {{secret:my-secret/supersecret}}");
	}
}
