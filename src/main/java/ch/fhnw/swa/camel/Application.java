package ch.fhnw.swa.camel;

import org.apache.camel.main.Main;

/**
 * Main class that boot the Camel application
 */
public final class Application {

    public static void main(String[] args) throws Exception {
        // use Camels Main class
        Main main = new Main();
        // and add the routes (you can specify multiple classes)
        main.configure().addRoutesBuilder(CamelRouteBuilder.class);
        // now keep the application running until the JVM is terminated (ctrl + c or sigterm)
        main.run(args);
    }

}
