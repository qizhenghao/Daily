package com.bruce.java.abstrac_interface;

import sun.jvm.hotspot.oops.Klass;
import sun.jvm.hotspot.ui.ObjectHistogramPanel;

/**
 * Created by qizhenghao on 16/11/25.
 */
public class AbstractTestImpl extends  AbstractTest implements InterfaceTest, ObjectHistogramPanel.Listener{

    protected AbstractTestImpl(int i, int i1) {
        super(i, i1);
    }

    public static void main(String[] args) {
//        System.out.println(i);//ambiguous
        AbstractTestImpl impl = new AbstractTestImpl(1, 1);
        impl.test();
    }

    @Override
    public void test() {
        System.out.println("InterfaceTest: i = " + InterfaceTest.i);
        System.out.println("AbstractTest : i = " + AbstractTest.i);
    }

    @Override
    public void showObjectsOfType(Klass klass) {

    }
}
