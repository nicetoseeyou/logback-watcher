package lab.orz.logging.agent;

import lab.orz.logging.other.Hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Agent {
    private static final Logger LOGGER = LoggerFactory.getLogger(Agent.class);

    public static void main(String[] args) {
        Hello hello = new Hello();
        while (true) {
            LOGGER.info("Hello, this is Agent! Do you copy?");
            hello.sayHi();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                LOGGER.error("Something wrong!", e);
            }
        }
    }
}
