package com.bruce.design.DynamicProxy.principle;

import java.lang.reflect.Method;

public interface InvocationHandler {
    void invoke(Object o, Method m);
}
