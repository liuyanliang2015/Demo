/**
 * 
 */
package com.test.reflect.demo3;


/**
 * @author LiuYanliang
 *
 */
public class Test {
	public static void main(String[] args) throws Exception {
		Student s = new Student("����",40);
		Tool.setProperty(s, "name", "�ŷ�");
		System.out.println(s); //Student [name=�ŷ�, age=40]
	}

}
