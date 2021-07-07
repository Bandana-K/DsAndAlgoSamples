package RingCentral;

public class StaticMethodReferenceWithObject {

	static void print() {
		System.out.println("Inside print method");
	}

	public static void main(String args[]) {
		StaticMethodReferenceWithObject obj = null;
		obj.print();		//no NPE, static methods can be referenced even with null
	}
}
