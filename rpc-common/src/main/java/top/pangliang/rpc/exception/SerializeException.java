package top.pangliang.rpc.exception;

/**
 * 序列化异常
 *
 * @author pangliang
 */
public class SerializeException extends RuntimeException {
    public SerializeException(String msg) {
        super(msg);
    }
}
