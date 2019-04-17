package com.iscas.jarslinkdemo.config;

import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.impl.ModuleLoaderImpl;
import com.alipay.jarslink.api.impl.ModuleManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * //TODO
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2019/4/16 10:51
 * @since jdk1.8
 */
@Configuration
public class BeanConfig {

    @Bean
    public ModuleLoader moduleLoader() {
        return new ModuleLoaderImpl();
    }
    @Bean
    public ModuleManager moduleManager() {
        return new ModuleManagerImpl();
    }

    @Bean
    public ModuleRefreshSchedulerImpl moduleRefreshScheduler() {
        ModuleRefreshSchedulerImpl moduleRefreshScheduler = new ModuleRefreshSchedulerImpl();
        ModuleManager moduleManager = moduleManager();
        ModuleLoader moduleLoader = moduleLoader();
        moduleRefreshScheduler.setModuleLoader(moduleLoader);
        moduleRefreshScheduler.setModuleManager(moduleManager);
        return moduleRefreshScheduler;
    }
}
