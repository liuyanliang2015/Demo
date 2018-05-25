/**
 * 
 */
package com.test.reflect.demo;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 *�����������Ǳ仯�ģ���ʱ����Ҫִ��ѧ����love��������ʱ����Ҫִ�н�ʦ��love�����������������˹��ˣ���ô����?
 *����ı仯������Ա���ܿ��ƣ��������Ǿ�������Ƹ�������չ�ԡ�
 *������Ҫ��������ļ�ʹ�ã�������reflect.txt���������ļ�
 */
public class Test {
	public static void main(String[] args) throws Exception {
		/*Student s = new Student();
		s.love();
		
		Teacher t = new Teacher();
		t.love();*/
		
		Properties pros = new Properties();
		FileReader fr = new FileReader("reflect.txt");
		pros.load(fr);
		fr.close();
		
		String className = (String)pros.getProperty("className");
		String methodName = (String)pros.getProperty("methodName");
		System.out.println(className);
		System.out.println(methodName);
		
		//���䣺
		//��ȡclass�ֽ����ļ�����
		Class c = Class.forName(className);
		Method method = c.getMethod(methodName);
		
		//��ȡ����
		Object obj = c.newInstance();
		method.invoke(obj);
		
	}
}
