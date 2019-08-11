package com.apollo.controller;

import com.apollo.bean.User;
import com.apollo.config.JavaConfigBean;
import com.apollo.config.SampleRedisConfig;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class TestController {
    @RequestMapping("/index")
    public String index() {
        return "hello 2019！";
    }
    // 1.Java Config方式
    @Autowired
    JavaConfigBean javaConfigBean;

    @RequestMapping("/index1")
    public String index1() {
        return "timeout：" + javaConfigBean.getTimeout();
    }
    // 2. ConfigurationProperties使用方式
    @Autowired
    SampleRedisConfig sampleRedisConfig;

    @RequestMapping("/index2")
    public String index2() {
        return sampleRedisConfig.getCommandTimeout() + "--" + sampleRedisConfig.getExpireSeconds();
    }
    // 3. @ApolloConfig使用
    @ApolloConfig
    private Config config;

    @RequestMapping("/index3")
    public String index3() {
        Set<String> propertyNames = config.getPropertyNames();
        propertyNames.forEach(key -> {
            System.err.println(key + "=" + config.getIntProperty(key, 0));
        });
        return propertyNames.toString();
    }
    @ApolloConfigChangeListener
    private void someOnChange(ConfigChangeEvent changeEvent) {
        // update injected value of batch if it is changed in Apollo
        if (changeEvent.isChanged("timeout")) {
            System.out.println(config.getIntProperty("timeout", 0));
        }
    }
    // 4. @ApolloJsonValue使用
    @ApolloJsonValue("${jsonBeanProperty:[]}")
    private List<User> anotherJsonBeans;

    @RequestMapping("/index4")
    public void hello4() {
        anotherJsonBeans.forEach(item -> {
            System.err.println(item.getUsername() + "--" + item.getPassword());
        });
    }

}
