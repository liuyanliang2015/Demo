/**
 * 
 */
package com.test.reflect.demo4;

/**
 * @author LiuYanliang
 */
public class UserDaoImpl implements UserDao {

	@Override
	public boolean login() {
		System.out.println("��¼����");
		return false;
	}

	@Override
	public void register() {
		System.out.println("ע�Ṧ��");
	}

}
