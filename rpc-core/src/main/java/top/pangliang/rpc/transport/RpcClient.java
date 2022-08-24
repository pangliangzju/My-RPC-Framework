package top.pangliang.rpc.transport;

import top.pangliang.rpc.entity.RpcRequest;
import top.pangliang.rpc.serializer.CommonSerializer;

/**
 * 客户端类通用接口
 *
 * @author pangliang
 */
public interface RpcClient {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    Object sendRequest(RpcRequest rpcRequest);

}
