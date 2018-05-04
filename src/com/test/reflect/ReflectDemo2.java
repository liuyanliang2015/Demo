/**
 * 
 */
package com.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author LiuYanliang
 *
 */
public class ReflectDemo2 {
	public static void main(String[] args) throws Exception {
		//(1)��ȡ�ֽ����ļ�����
		Class c  = Class.forName("com.test.reflect.Person");
		//��ȡpublic������Ա����
		//Field[] fields = c.getFields();
		//��ȡ���г�Ա����
		/*Field[] fields = c.getDeclaredFields();
		for(Field f :fields){
			System.out.println(f);
		}*/
		//(2)��ȡ����public��Ա����
		Field addressField = c.getField("address");
		System.out.println(addressField);
		
		Field nameField = c.getDeclaredField("name");
		System.out.println(nameField);
		
		Field ageField = c.getDeclaredField("age");
		System.out.println(ageField);
		
		//(3)ͨ���޲ι��췽����������
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		//(4)���÷�pulic��Ա�����ɷ���:��ָ����������ϴ� Field �����ʾ���ֶ�����Ϊָ������ֵ
		nameField.setAccessible(true);
		//(5)���ó�Ա������ֵ
		nameField.set(obj, "����ϼ");
		ageField.set(obj, 27);
		addressField.set(obj, "����");
		//��֤
		System.out.println(obj);
	}

}
