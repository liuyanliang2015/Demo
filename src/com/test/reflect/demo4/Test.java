/**
 * 
 */
package com.test.reflect.demo4;

import java.lang.reflect.Proxy;

/**
 * @author LiuYanliang
 *
 */
public class Test {
	public static void main(String[] args) {
		UserDao ud = new UserDaoImpl();
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler(ud);
		//����ud�Ķ�̬�������
		UserDao proxy = (UserDao)Proxy.newProxyInstance(ud.getClass().getClassLoader(), ud.getClass().getInterfaces(), myInvocationHandler);
		proxy.login();
	}
}
