package com.xiaoxian.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author 小贤
 * @PackageName:util
 * @ClassName:ApplicationUtil
 * @Description:
 * @date 2021/1/26 22:31
 */
@Component
public class ApplicationUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    //获取工厂对象
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //提供在工厂中获取对象的方法
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
