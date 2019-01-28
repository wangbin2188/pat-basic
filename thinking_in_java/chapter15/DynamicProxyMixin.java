package thinking_in_java.chapter15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * Created by wangbin10 on 2019/1/28.
 * 动态代理实现混型
 */
public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(new TwoTuple(new BasicImp(), Basic.class),
                new TwoTuple(new TimeStampedImp(), TimeStamped.class),
                new TwoTuple(new SerialNumberedImp(), SerialNumbered.class));
        Basic b= (Basic) mixin;
        TimeStamped t= (TimeStamped) mixin;
        SerialNumbered s= (SerialNumbered) mixin;
        b.set("hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
    }
}

class MixinProxy implements InvocationHandler {
    Map<String,Object> delegatesByMethod;

    public MixinProxy(TwoTuple<Object,Class<?>>...pairs) {
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                if (!delegatesByMethod.containsKey(methodName)) {
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate,args);
    }

    public static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class)pairs[i].second;
        }
        ClassLoader cl = pairs[0].getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}