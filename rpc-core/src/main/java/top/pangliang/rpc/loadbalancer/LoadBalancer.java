package top.pangliang.rpc.loadbalancer;

import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

/**
 * @author pangliang
 */
public interface LoadBalancer {

    Instance select(List<Instance> instances);

}
