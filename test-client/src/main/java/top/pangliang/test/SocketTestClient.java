package top.pangliang.test;

import top.pangliang.rpc.api.ByeService;
import top.pangliang.rpc.api.HelloObject;
import top.pangliang.rpc.api.HelloService;
import top.pangliang.rpc.serializer.CommonSerializer;
import top.pangliang.rpc.transport.RpcClientProxy;
import top.pangliang.rpc.transport.socket.client.SocketClient;

/**
 * 测试用消费者（客户端）
 *
 * @author pangliang
 */
public class SocketTestClient {

    public static void main(String[] args) {
        SocketClient client = new SocketClient(CommonSerializer.KRYO_SERIALIZER);
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
        ByeService byeService = proxy.getProxy(ByeService.class);
        System.out.println(byeService.bye("Netty"));
    }

}
