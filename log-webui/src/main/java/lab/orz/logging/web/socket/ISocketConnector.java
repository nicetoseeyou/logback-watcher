package lab.orz.logging.web.socket;

public interface ISocketConnector extends Runnable {
    String name();
    void open();
    void process();
    void close();
}
