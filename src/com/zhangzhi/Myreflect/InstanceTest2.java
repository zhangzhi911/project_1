package com.zhangzhi.Myreflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InstanceTest2 {

	public static void main(String[] args) throws Exception {

//		三种获取类的方法
		
//		Class cl=Class.forName("com.zhangzhi.Student");  （“包+类名”）   
		
		//第二种，创建对象getClass（）方法   实例对象.getClass();
//		Class c2=new Student.getClass();
		
		//第三种方式，类名.class
//		new Student.class;
		Student student = new Student();
		Class stuCls = Class.forName("com.zhangzhi.Myreflect.Student");
		


		Method method = stuCls.getDeclaredMethod("setName", String.class);
		method.setAccessible(true);//暴力破解方法
		
		
//		属性和方法都是带着Declared是所有的不带Declared是public
//		本人打一般喜欢Declared 下面在暴力破解（不会报错）
		Field field = stuCls.getDeclaredField("name");
		field.setAccessible(true);//暴力破解
		System.out.println(field.get(student));
//		以上是获取属性
		
		
		Student stu = (Student) stuCls.newInstance();
//		newInstance   是类对象
		method.invoke(stu, "你好兄弟");//invoke是传值
//		以上是方法
		
		
		Constructor cst2 = stuCls.getConstructor();
		Student obj2 = (Student) cst2.newInstance();
		System.out.println(obj2);
//		以上是构造

		Class[] interfaces = stuCls.getInterfaces();
		for (Class class1 : interfaces) {
			System.out.println(class1);
		}
//		以上是获取接口
		
		String name = stuCls.getName(); 
		Package package1 = stuCls.getPackage();
		Student mystu = (Student) stuCls.newInstance();
//		newInstance   是类对象上面有
		 System.out.println("全额限定名"+name+"bao名"+package1);
		
		
		
	}
}