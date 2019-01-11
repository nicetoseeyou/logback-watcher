package lab.orz.logging.web.socket;

public interface IDataRouter<T> {
    void transmit(T t, String... target);
}
