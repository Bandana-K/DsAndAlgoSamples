package RingCentral;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestCustomKey {
	
	public static void main(String args[]) {
		
		Map<Key, Integer> map = new HashMap<>();
		Key k1 = new Key("one");
		map.put(k1, 1);
		
		k1.setName("two");
		
		Key k2 = new Key("one");
		map.put(k2, 2);
		
		System.out.println(map.size());
		System.out.println(map.get(k1));
		System.out.println(map.get(k2));
		
		Map<Key, Integer> tmap = new TreeMap<>(); 
		
//		Exception in thread "main" java.lang.ClassCastException: class RingCentral.TestCustomKey$Key cannot be cast to class java.lang.Comparable 
//		(RingCentral.TestCustomKey$Key is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
		tmap.put(k1, 1);
		
		
	}
	
	public static class Key{
		String name;
		
		
		Key(String name){
			this.name = name;			
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int hashCode() {
			return this.name.hashCode();
		}
		
		public boolean equals(Key k) {
			return this.name.equals(k.getName());
		}
	}

}
