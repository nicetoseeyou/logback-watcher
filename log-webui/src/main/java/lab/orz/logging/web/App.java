package lab.orz.logging.web;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class App {
    private static final String DEFAULT_LOG_PATTERN = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{32} - %msg%n";
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.reset();

        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(context);
        encoder.setPattern(DEFAULT_LOG_PATTERN);
        encoder.start();

        Socket socket = new Socket("localhost", 9090);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        while (true) {
            ILoggingEvent loggingEvent = (ILoggingEvent) ois.readObject();
            System.out.print(encoder.getLayout().doLayout(loggingEvent));
        }
    }

}
