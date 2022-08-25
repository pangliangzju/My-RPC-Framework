package top.pangliang.rpc.loadbalancer;

import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmoothWeightLoadBalancer implements LoadBalancer {

    /**
     * key:服务value:当前权重
     */
    private static final Map<String, Double> map = new HashMap<>();

    @Override
    public synchronized Instance select(List<Instance> instances) {
        instances.forEach(instance ->
                map.computeIfAbsent(instance.toString(), key -> instance.getWeight())
        );
        Instance maxWeightServer = null;
        double allWeight = instances.stream().mapToDouble(Instance::getWeight).sum();
        for (Instance instance : instances) {
            Double currentWeight = map.get(instance.toString());
            if (maxWeightServer == null || currentWeight > map.get(maxWeightServer.toString())) {
                maxWeightServer = instance;
            }
        }

        assert maxWeightServer != null;

        map.put(maxWeightServer.toString(), map.get(maxWeightServer.toString()) - allWeight);

        for (Instance instance : instances) {
            Double currentWeight = map.get(instance.toString());
            map.put(instance.toString(), currentWeight + instance.getWeight());
        }
        return maxWeightServer;
    }
}
