package com.hcl.threads;

class TimeDemo implements Runnable{
	@Override
	public void run(){
		for(int i=0;i<500;i++){
			System.out.print(i + "\b");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Time {
	public static void main(String[] args) {
		new Thread(new TimeDemo()).start();
		
	}

}
