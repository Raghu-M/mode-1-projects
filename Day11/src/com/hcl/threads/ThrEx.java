package com.hcl.threads;

public class ThrEx {
	public static void main(String[] args) {
		Even ev = new Even();
		Odd od = new Odd();
		Fact ft = new Fact();
		Thread t1 = new Thread(ev);
		Thread t2 = new Thread(od);
		Thread t3 = new Thread(ft);
		t1.start();
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
	}
	

}
class Even extends Thread{
	@Override
	public void run(){
		for(int i=0;i<20;i+=2){
			System.out.println("Even  "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Odd extends Thread{
	@Override
	public void run(){
		for(int i=1;i<20;i+=2){
			System.out.println("Odd  "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Fact extends Thread{
	@Override
	public void run(){
		int f=1;
		for(int i=1;i<8;i++){
			f*=i;
			System.out.println(" Fact  " + f);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}