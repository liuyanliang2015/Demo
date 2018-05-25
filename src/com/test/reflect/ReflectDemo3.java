/**
 * 
 */
package com.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author LiuYanliang
 *
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
		//(1)��ȡ�ֽ����ļ�����
		Class c  = Class.forName("com.test.reflect.Person");
		//��ȡpublic������Ա����(���������еķ���)
		//Method[] methods = c.getMethods();
		//��ȡ���еĳ�Ա����(����������)
		/*Method[] methods = c.getDeclaredMethods();
		for(Method m : methods){
			System.out.println(m);
		}*/
		
		//(2)��ȡ��Ա��������
		Method showMethod = c.getMethod("show");
		Method meMethod = c.getDeclaredMethod("method", String.class);
		Method functionMethod = c.getDeclaredMethod("function");
		functionMethod.setAccessible(true);
		
		Method getStringMethod = c.getDeclaredMethod("getString", String.class,int.class);
		//(3)ͨ���޲ι��췽����������
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		//(4)ִ�з���
		showMethod.invoke(obj);
		meMethod.invoke(obj, "hello");
		functionMethod.invoke(obj);
		String result = (String)getStringMethod.invoke(obj,"hello",5);
		System.out.println("result:"+result);
	}

}
