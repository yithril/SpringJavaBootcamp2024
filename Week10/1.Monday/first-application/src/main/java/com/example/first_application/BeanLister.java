package com.example.first_application;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BeanLister {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void listBeans() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        System.out.println("All beans that Spring Framework manages:");
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
