package ch.fhnw.swa.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelRouteBuilder extends RouteBuilder {

    @Override
    public void configure() {
        from("file:data?fileName=input.txt&noop=true")
                .convertBodyTo(String.class).process(new BodyProcessor())
                .to("file:data?fileName=output.txt");
    }

    //
    // Helper classes
    //

    private final static class BodyProcessor implements Processor {
        public void process(Exchange exchange) {
            Message in = exchange.getIn();
            String body = in.getBody(String.class);
            in.setBody(body.toUpperCase());
        }
    }
}
