package com.example.first_application;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private final DependencyBean dependencyBean;

    @Autowired
    public MyBean(DependencyBean dependencyBean) {
        this.dependencyBean = dependencyBean;
    }
    @PostConstruct
    public void init() {
        System.out.println("MyBean is initialized");
        dependencyBean.printDependency();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("MyBean is destroyed");
    }

    public void printMessage() {
        System.out.println("MyBean is alive!");
    }
}
