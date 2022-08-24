package top.pangliang.test;

import top.pangliang.rpc.annotation.ServiceScan;
import top.pangliang.rpc.serializer.CommonSerializer;
import top.pangliang.rpc.transport.RpcServer;
import top.pangliang.rpc.transport.socket.server.SocketServer;

/**
 * 测试用服务提供方（服务端）
 *
 * @author pangliang
 */
@ServiceScan
public class SocketTestServer {

    public static void main(String[] args) {
        RpcServer server = new SocketServer("127.0.0.1", 9998, CommonSerializer.HESSIAN_SERIALIZER);
        server.start();
    }

}
