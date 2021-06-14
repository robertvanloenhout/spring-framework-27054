package com.calitha.spring27054;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.StandardIntegrationFlow;
import org.springframework.integration.dsl.context.IntegrationFlowContext;
import org.springframework.integration.http.dsl.Http;
import org.springframework.integration.http.dsl.HttpRequestHandlerEndpointSpec;
import org.springframework.stereotype.Component;

@Component
public class MyInitializer {

  private final IntegrationFlowContext context;

  public MyInitializer(IntegrationFlowContext context) {
    this.context = context;
  }

  @EventListener
  public void init(ContextRefreshedEvent event) {
    HttpRequestHandlerEndpointSpec spec = Http.inboundGateway("/flow");
    StandardIntegrationFlow flow = IntegrationFlows.from(spec)
        .transform(m -> {
          throw new IllegalArgumentException("Illegal request in transformer");
        })
        .get();
    context.registration(flow)
        .id("flow")
        .register();
  }
}
