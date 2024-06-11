package com.example.first_application;

import org.springframework.stereotype.Component;

@Component
public class SecondLayerDependencyBean {
    public void printSecondDependency(){
        System.out.println("Second layer of dependency!");
    }
}
