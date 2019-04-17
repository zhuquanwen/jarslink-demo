package com.iscas.jarslinkdemo.config;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * //TODO
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2019/4/16 9:52
 * @since jdk1.8
 */
public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {
    @Override
    public List<ModuleConfig> queryModuleConfigs() {
        return ImmutableList.of(buildModuleConfig()/*, buildModuleConfig2()*/);
    }

    public static ModuleConfig buildModuleConfig() {
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource("META-INF/demo-2.8-RELEASE.jar");
        ModuleConfig moduleConfig = new ModuleConfig();
        //通过该方法构建的配置都是使用注解形式扫描bean的
//        String scanBase = "com.alipay.jarslink.main";
        moduleConfig.setOverridePackages(Arrays.asList("com.iscas.demo"));
        moduleConfig.setName("demo");
        moduleConfig.setEnabled(true);
        moduleConfig.setVersion("2.8");
//        moduleConfig.setProperties(ImmutableMap.of("lalala", new Object()));
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        return moduleConfig;
    }

    public static ModuleConfig buildModuleConfig2() {
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource("META-INF/demo-2.9-RELEASE.jar");

        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("demo");
        moduleConfig.setEnabled(true);
        moduleConfig.setVersion("2.9");
//        moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        return moduleConfig;
    }
}