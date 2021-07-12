package com.example.basicjava.reflection.diframework;

public class DiFrameworkEx {

    public static void main(String[] args) {
        HelloController helloController = Container.getObject(HelloController.class);
        helloController.sayHello();
    }

}
