package com.hcl.Junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataTest {

	@Test
	public void testSayHello() {
		Data obj = new Data();
		assertEquals("Welcome to Junit",obj.hello());
	}
	@Test
	public void testSum(){
		Data obj = new Data();
		assertEquals(2,obj.sum(1, 1));
	}
	@Test
	public void testMax(){
		Data obj = new Data();
		assertEquals(3,obj.max(1, 2, 3));
		assertEquals(3,obj.max(3, 1, 2));
		assertEquals(3,obj.max(2, 3, 1));
	}
	@Test
	public void testMin(){
		Data obj = new Data();
		int[]x = {1,2,3,4,5,6,7,8};
		assertEquals(1,obj.minArray(x));
	}
	@Test
	public void testEven(){
		Data obj = new Data();
		assertEquals(false,obj.even(9));
		assertEquals(true,obj.even(12));
	}
	@Test (expected = ArithmeticException.class)
	public void testDiv(){
		Data obj = new Data();
		assertEquals(2,obj.div(8,4));
		assertEquals(0,obj.div(4,8));
		assertEquals(0,obj.div(8,0));
	}

}
