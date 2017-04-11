package com.bruce.design.DynamicProxy.principle;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
    public static Object newProxyInstance(Class[] interfaces, InvocationHandler h) throws Exception {
        String methodStr = "";
        String rt = "\r\n";

        StringBuilder interfaceStr = new StringBuilder();
        for (Class itemInterf : interfaces) {
            interfaceStr.append(itemInterf.getName()).append(" , ");
            Method[] methods = itemInterf.getMethods();
            for (Method m : methods) {
                methodStr += "  @Override" + rt +
                        "   public void " + m.getName() + "() {" + rt +
                        "       try {" + rt +
                        "           Method md = " + itemInterf.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
                        "           h.invoke(this, md);" + rt +
                        "       }catch(Exception e) {e.printStackTrace();}" + rt +

                        "   }" + rt + rt;
            }
        }

        String src =
                "package com.bruce.design.DynamicProxy.principle;" + rt + rt +
                        "import java.lang.reflect.Method;" + rt + rt +
                        "public class $Proxy1 implements " + interfaceStr.substring(0, interfaceStr.lastIndexOf(",")) + " {" + rt + rt +
                        "    public $Proxy1(InvocationHandler h) {" + rt +
                        "        this.h = h;" + rt +
                        "    }" + rt + rt +
                        "    com.bruce.design.DynamicProxy.principle.InvocationHandler h;" + rt + rt +

                        methodStr + rt +
                        "}";

        //这里可以不写的，只是为了直观的显示出来过程
        String fileName =
                "/Users/qizhenghao/Documents/Daily/JAVA_Knowledges/src/com/bruce/design/DynamicProxy/principle/$Proxy1.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //compile
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        CompilationTask compilationTask = compiler.getTask(null, fileMgr, null, null, null, units);
        compilationTask.call();
        fileMgr.close();

        //load into memory and create an instance
        URL[] urls = new URL[]{new URL("file://Users/qizhenghao/Documents/Daily/JAVA_Knowledges/src/")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("com.bruce.design.DynamicProxy.principle.$Proxy1");

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        Object object = ctr.newInstance(h);

        ClassLoader classLoader = h.getClass().getClassLoader();
//        classLoader.lo


        return object;
    }
}
