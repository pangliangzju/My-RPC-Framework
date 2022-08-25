package top.pangliang.rpc.loadbalancer;

import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

public class WeightLoadBalancer implements LoadBalancer {

    private static int index;

    @Override
    public Instance select(List<Instance> instances) {
        double allWeight = instances.stream().mapToDouble(Instance::getWeight).sum();
        double number = (index++) % allWeight;
        for (Instance instance : instances) {
            if (instance.getWeight() > number) {
                return instance;
            }
            number -= instance.getWeight();
        }
        return null;
    }
}
