package RingCentral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnArrayList {
	
	public static void main(String args[]) {
		
		
		CopyOnWriteArrayList<Integer> copyOnWrite = new CopyOnWriteArrayList<>();
		copyOnWrite.add(1);
		copyOnWrite.add(2);
		
		Iterator<Integer> itr = copyOnWrite.iterator();
		copyOnWrite.add(3);
		while(itr.hasNext())
			System.out.println(itr.next());			// prints 1, 2, WONT print 3, as it was added after the snap was taken from list
				
		
		
		List<Integer> numList = new ArrayList<>();
		numList.add(1);
		numList.add(2);
		
		Iterator<Integer> listItr = numList.iterator();
		numList.add(3);
		while(listItr.hasNext())
			System.out.println(listItr.next());		// Will throw concurrentModificationException, Adding is allowed, its the iterator.next method which throws error of modification
		
		
		
		//Modify the below code to allow me to remove any element less than 2
		Iterator<Integer> newItr = numList.iterator();
		while(newItr.hasNext()) {
			Integer test = itr.next();
			if(test<2)
				numList.remove(test);				//replace this line with newItr.remove();
		}

	}

}
