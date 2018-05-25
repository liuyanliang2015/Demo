/**
 * 
 */
package com.test.reflect.demo2;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author LiuYanliang
 *
 */
public class Test {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		//arrayList.add("hello"); error
		arrayList.add(10);
		//ͨ����add()Դ�룬���Կ�������ʵ�ײ���Ҫ������E��Ĭ����Object
		//����ֻ�Ǹ�����������,ͨ�������룬���Կ����������е�ʱ����ʵ��û�з��͵�
		
		//ͨ��������洢�ַ���
		Class c = arrayList.getClass();
		Method addMethod = c.getMethod("add", Object.class);
		addMethod.invoke(arrayList, "hello");
		System.out.println(arrayList); //[10, hello]
	}
}
