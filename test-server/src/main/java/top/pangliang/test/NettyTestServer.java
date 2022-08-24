package top.pangliang.test;

import top.pangliang.rpc.annotation.ServiceScan;
import top.pangliang.rpc.serializer.CommonSerializer;
import top.pangliang.rpc.transport.RpcServer;
import top.pangliang.rpc.transport.netty.server.NettyServer;

/**
 * 测试用Netty服务提供者（服务端）
 *
 * @author pangliang
 */
@ServiceScan
public class NettyTestServer {

    public static void main(String[] args) {
        RpcServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
        server.start();
    }

}
