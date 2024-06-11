package com.example.first_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DependencyBean {
    @Autowired
    private SecondLayerDependencyBean secondLayerDependencyBean;
    public void printDependency() {
        System.out.println("DependencyBean is injected!");
        secondLayerDependencyBean.printSecondDependency();
    }
}
