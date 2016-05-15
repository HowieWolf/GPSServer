package com.test;

public class TestBean {

	
	public void test(){
		System.out.println("测试");
	}
	
	public static void main(String[] args) {
		B b = new B();
		b.show();
	}
	
	

}

class A {
	protected String a;
}

class B extends A {
	
	public B() {
		// TODO Auto-generated constructor stub
		this.a = "9";
	}
	
	public void show(){
		System.out.println(super.a);
		System.out.println(this.a);
	}
	
}