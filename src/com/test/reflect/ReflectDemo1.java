/**
 * 
 */
package com.test.reflect;

import java.lang.reflect.Constructor;

/**
 * @author LiuYanliang
 *
 */
public class ReflectDemo1 {
		public static void main(String[] args) throws Exception {
			//(1)��ȡClass���󣬱����ȫ·����������
			Class c4 = Class.forName("com.test.reflect.Person");
			//(2)��ȡ���췽������
			Constructor  c = c4.getDeclaredConstructor(String.class,int.class);
			System.out.println(c);//public com.test.reflect.Person(java.lang.String,int,java.lang.String)
			//��������˽�й�������ֵΪtrue��ָʾ����Ķ�����ʹ��ʱӦ��ȡ��Java���Է��ʼ��
			c.setAccessible(true);
			//ʹ�ù��췽������ķ���,��������
			Object obj  = c.newInstance("����ϼ",27);
			System.out.println(obj);
		}

}
