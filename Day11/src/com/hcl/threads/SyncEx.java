package com.hcl.threads;


class Data {
	synchronized void  dispMsg(String name){
		System.out.println(" Hello " + name);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("how are you...");
	}
}

class Uttam extends Thread{
	Data d ;
	Uttam(Data d){
		this.d = d;
	}
	@Override
	public void run(){
		d.dispMsg("Uttam");
	}
}

class Laksh extends Thread{
	Data d ;
	Laksh(Data d){
		this.d = d;
	}
	@Override
	public void run(){
		d.dispMsg("Laksh");
	}
}

class Raghu extends Thread{
	Data d ;
	Raghu(Data d){
		this.d = d;
	}
	@Override
	public void run(){
		d.dispMsg("Raghu");
	}
}



public class SyncEx {
	public static void main(String[] args) {
		Data d = new  Data();
		Thread t1 = new Thread(new Uttam(d));
		Thread t2 = new Thread(new Laksh(d));
		Thread t3 = new Thread(new Raghu(d));
		t1.start();
		t2.start();
		t3.start();
	}
}
