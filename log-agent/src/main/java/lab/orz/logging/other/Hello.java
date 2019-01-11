package lab.orz.logging.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hello.class);
    public void sayHi(){
        LOGGER.info("Hello World!");
    }
}
