package top.pangliang.test;

import top.pangliang.rpc.api.ByeService;
import top.pangliang.rpc.api.HelloObject;
import top.pangliang.rpc.api.HelloService;
import top.pangliang.rpc.serializer.CommonSerializer;
import top.pangliang.rpc.transport.RpcClient;
import top.pangliang.rpc.transport.RpcClientProxy;
import top.pangliang.rpc.transport.netty.client.NettyClient;

/**
 * 测试用Netty消费者
 *
 * @author pangliang
 */
public class NettyTestClient {

    public static void main(String[] args) {
        RpcClient client = new NettyClient(CommonSerializer.PROTOBUF_SERIALIZER);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        //HelloService是接口，客户端本地也有信息，可以生成代理
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
        ByeService byeService = rpcClientProxy.getProxy(ByeService.class);
        System.out.println(byeService.bye("Netty"));
    }

}
