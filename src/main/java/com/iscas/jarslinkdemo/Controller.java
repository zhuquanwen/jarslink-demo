package com.iscas.jarslinkdemo;

import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.iscas.jarslinkdemo.config.ModuleRefreshSchedulerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * //TODO
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2019/4/16 11:02
 * @since jdk1.8
 */
@RestController
public class Controller {
    @Autowired
    private ModuleRefreshSchedulerImpl moduleRefreshScheduler;
    @Autowired
    private ModuleManager moduleManager;
    @Autowired
    private ModuleLoader moduleLoader;

    @GetMapping("/test/{version}")
    public String test(@PathVariable String version) {
        List<ModuleConfig> moduleConfigs = moduleRefreshScheduler.queryModuleConfigs();
        Module runModule = moduleManager.find("demo");
        if (runModule == null || runModule.getActions().size() == 0 || !Objects.equals(version, runModule.getVersion())) {
            if (Objects.equals("2.8", version)) {
                runModule = moduleLoader.load(ModuleRefreshSchedulerImpl.buildModuleConfig());
                Module removedModule = moduleManager.register(runModule);
            } else if (Objects.equals("2.9", version)) {
                runModule = moduleLoader.load(ModuleRefreshSchedulerImpl.buildModuleConfig2());
                Module removedModule = moduleManager.register(runModule);
            } else {
                throw new RuntimeException("版本错误");
            }
        }
        String result = runModule.doAction("ttt", new ModuleConfig());
        return result;
    }
}
