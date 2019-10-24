package com.hcl.threads;

class TableShow {
	synchronized void show(int n){
		int p;
		for(int i = 1;i<=10;i++){
			p=n*i;
			System.out.println(n + " * " + i + " = " + p);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}strictfp
class Tab1 extends Thread{
	TableShow t;
	Tab1(TableShow t){
		this.t = t;
	}
	@Override
	public void run(){
		t.show(2);
	}
}

class Tab2 extends Thread{
	TableShow t;
	Tab2(TableShow t){
		this.t = t;
	}
	@Override
	public void run(){
		t.show(7);
	}
}

public class MTabDemo {
	public static strictfp void main(String[] args) {
		
		TableShow t = new TableShow();
		Thread t1 = new Thread(new Tab1(t));
		Thread t2 = new Thread(new Tab2(t));
		t1.start();
		t2.start();
	}
}
