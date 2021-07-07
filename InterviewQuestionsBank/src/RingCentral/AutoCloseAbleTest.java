package RingCentral;

public class AutoCloseAbleTest {

	public static void main(String args[]) {

		try (Walk W1 = new Walk(); Walk W2 = new Walk();) {
			throw new RuntimeException("Running... ");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "   " + e.getSuppressed().length);
		}
	}
}

class Walk implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new RuntimeException("Walking... ");
	}
}