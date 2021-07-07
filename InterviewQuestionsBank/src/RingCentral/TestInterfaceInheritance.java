package RingCentral;

import java.util.Collection;
import java.util.Set;

public class TestInterfaceInheritance implements I1, I2{

//	How to implement the below message in 1 line, such that the one implementation works for both the interfaces
//	Based on the returnType declaration and exception that can be thrown from a sub class
//	@Override
//	public _______ foo() ________ {
//		return null;
//	}
	
	@Override
	public Set foo() {
		return null;
	}

}

interface I1{
	Collection foo() throws Exception1;
}

interface I2{
	Set foo() throws Exception2;
}

class Exception1 extends Exception{
	
}

class Exception2 extends Exception{
	
}