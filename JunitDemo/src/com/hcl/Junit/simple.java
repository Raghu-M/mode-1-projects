package com.hcl.Junit;

import java.util.Set;
import java.util.TreeSet;

interface hello{
	
}
interface hey extends hello{
	
}
class hi{
	
}

public class simple  extends hi implements hello{
	public static void main(String[] args) {
		Set<String> s = new TreeSet<>();
	}

}
