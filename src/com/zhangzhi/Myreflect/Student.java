package com.zhangzhi.Myreflect;


public class Student implements Myinterface {
// 接口没用只是让演示一下获取
	
	private String name="4";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("来了老弟");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
	
}