package com.blueknight.demo.proxy.cglib;




import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


/**
 * Created by liuyang on 2017/10/25.
 */
public class CGLIBFactory implements MethodInterceptor {
    Object targetObject;// 目标对象
    Object proxyObject;
    public Object createCglibIntenc(Object targetObject) {
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();//通过类Enhancer创建代理对象
        enhancer.setSuperclass(this.targetObject.getClass());//传入创建代理对象的类
        enhancer.setCallback(this);//设置回调
        return enhancer.create();//创建代理对象

    }

    @Override
    public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
        PersonserviceBean bean = (PersonserviceBean) targetObject;// 因为在程序里targetObject为PersonServiceBean
        Object result = null;
        if (bean.getUser() != null) {// 判断user是否为空
            Annotation[] anas = method.getAnnotations();
            Annotation[] ans = method.getDeclaredAnnotations();
            boolean flag = false;
            for(Annotation an :ans){
                if(an.annotationType().getName().equals(SlefProxy.class.getName())){
                    flag = true;
                }

            }
            result = method.invoke(proxyObject, args);// 如果不为空交给目标对象进行处理.
//            if(flag){
//                result = method.invoke(proxyObject, args);// 如果不为空交给目标对象进行处理.
//            }else {
//                result = method.invoke(targetObject, args);// 如果不为空交给目标对象进行处理.
//            }
        }
        // TODO Auto-generated method stub
        System.out.println("+++++TEST++++");
        return result;
    }
    public void setProxyObject(Object proxyObject){
        this.proxyObject = proxyObject;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Person person = new Person();
        person.setName("liuy");
        person.setId(1L);
        PersonserviceBean bean = new PersonserviceBean();
        Class clazz = bean.getClass();
       Method m = clazz.getMethod("save", new Class[]{Person.class}) ;

        Annotation[] a1=m.getAnnotations();
        Annotation[] a2=m.getDeclaredAnnotations();
        Annotation a3=m.getAnnotation(SlefProxy.class);
        bean.setTest("ABC");
        bean.setUser("liuyBean");
        bean.save(person);
        CGLIBFactory factory = new CGLIBFactory();
        PersonserviceBean proxyObj= (PersonserviceBean) factory.createCglibIntenc(bean);
        factory.setProxyObject(proxyObj);
        System.out.println(proxyObj);

        proxyObj.setTest("HELLO");
        proxyObj.save(person);
    }
}
