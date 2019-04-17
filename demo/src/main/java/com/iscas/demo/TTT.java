package com.iscas.demo;

import com.alipay.jarslink.api.Action;
import com.alipay.jarslink.api.ModuleConfig;
import com.iscas.test.base.TTInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * //TODO
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2019/4/16 11:24
 * @since jdk1.8
 */
@Component
public class TTT implements Action<ModuleConfig, String>, TTInterface {
    @Autowired
    private Use use;
    public TTT() {
        /*System.out.println("2.5");*/

    }
    @Override
    public void ttt() {
        use.t();
    }

    @Override
    public String execute(ModuleConfig actionRequest) {
        ttt();
        return "success";
    }

    @Override
    public String getActionName() {
        return "ttt";
    }
}
