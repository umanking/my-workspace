package com.example.basicjava.reflection.diframework;

public class HelloController {

    @InjectAnnotation
    private HelloService helloService;

    public void sayHello() {
        helloService.sayHello();
    }
}
