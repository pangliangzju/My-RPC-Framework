package top.pangliang.test;

import top.pangliang.rpc.annotation.Service;
import top.pangliang.rpc.api.ByeService;

/**
 * @author pangliang
 */
@Service
public class ByeServiceImpl implements ByeService {

    @Override
    public String bye(String name) {
        return "bye, " + name;
    }
}
