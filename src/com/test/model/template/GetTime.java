/**
 * 
 */
package com.test.model.template;

/**
 * @author LiuYanliang
 * 
 */
public abstract class GetTime {
	
	/**
	 * ģ�巽������������ִ��ʱ��
	 * @return
	 */
	public long getTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		return (end - start);
	}

	public abstract void code();

}
