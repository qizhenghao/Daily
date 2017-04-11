package com.bruce.design.DynamicProxy.principle;

import java.lang.reflect.Method;

public class $Proxy1 implements com.bruce.design.DynamicProxy.principle.IShoot  {

    public $Proxy1(InvocationHandler h) {
        this.h = h;
    }

    com.bruce.design.DynamicProxy.principle.InvocationHandler h;

  @Override
   public void shoot() {
       try {
           Method md = com.bruce.design.DynamicProxy.principle.IShoot.class.getMethod("shoot");
           h.invoke(this, md);
       }catch(Exception e) {e.printStackTrace();}
   }


}