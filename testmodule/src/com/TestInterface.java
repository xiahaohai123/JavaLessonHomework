package com;

public interface TestInterface {
    default public void foo() {
        System.out.println("default foo");
    }

    public void foo(int a);
}
