package com.hcl.threads;

import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.LinkedList;

class ListDemo implements Runnable { 
	@Override
	public void run(){
		List lst = new ArrayList();
		lst.add("keerthana");
		lst.add("Maunika");
		lst.add("manjunath");
		lst.add("sandy");
		lst.add("Rajath");
		for(Object object : lst){
			System.out.println(object);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class LinkDemo implements Runnable{
	@Override
	public void run(){
		LinkedList lst = new LinkedList();
		lst.add("Raghu");
		lst.add("Varun");
		lst.add("Chandan");
		lst.add("Sunny");
		lst.add("kows");
		lst.addFirst("Gaurav");
		lst.addLast("Thejas");
		for(Object object : lst){
			System.out.println(object);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
}

class VectorDemo implements Runnable{
	@Override
	public void run(){
		Vector v = new Vector<>();
		v.addElement("Hemanth");
		v.addElement("Krishna");
		v.addElement("Vinay");
		v.addElement("Vikas");
		v.addElement("Pradumna");
		v.addElement("Abhishek");
		v.addElement("BornStar");
		for(Object object : v){
			System.out.println("Vector  " + object);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThrImp {
	public static void main(String[] args) {
		Thread t1 = new Thread(new ListDemo());
		Thread t2 = new Thread(new LinkDemo());
		Thread t3 = new Thread(new VectorDemo());
		t1.start();
		t2.start();
		t3.start();
	}

}
