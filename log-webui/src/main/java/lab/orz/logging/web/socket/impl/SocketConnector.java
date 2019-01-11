package lab.orz.logging.web.socket.impl;

import lab.orz.logging.web.socket.IDataRouter;
import lab.orz.logging.web.socket.ISocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class SocketConnector implements ISocketConnector {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketConnector.class);
    private final AtomicInteger counter = new AtomicInteger(0);
    private final String host;
    private final Integer port;
    private final String name;

    private Socket socket;

    public SocketConnector(String host, Integer port, String name) {
        this.host = host;
        this.port = port;
        this.name = name;
    }


    @Override
    public String name() {
        return this.name;
    }

    @Override
    public void open() {
        if (counter.getAndIncrement() == 0) {
            try {
                socket = new Socket(host, port);
            } catch (IOException e) {
                LOGGER.error("Failed to construct Socket with host={} port={}", host, port, e);
                //handle
            }
        }

    }

    @Override
    public void process() {

    }

    @Override
    public void close() {

    }

    @Override
    public void run() {

    }
}
