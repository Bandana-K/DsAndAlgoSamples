package HotStar;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/keys-and-rooms/
public class RoomVisits {

	static boolean[] visited;
	
	public static void main(String arg[]) {

//		Input: [[1],[2],[3],[]]
//				Output: true
		
		List<Integer> room1 = new ArrayList<>();
		room1.add(1);
		List<Integer> room2 = new ArrayList<>();
		room1.add(2);
		List<Integer> room3 = new ArrayList<>();
		room1.add(3);
		List<Integer> room4 = new ArrayList<>();
		
		List<List<Integer>> rooms = new ArrayList<>();
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);

		System.out.println(canVisitAllRooms(rooms));

		
		
//		Input: [[1,3],[3,0,1],[2],[0]]
//				Output: false
		
		List<Integer> room11 = new ArrayList<>();
		room11.add(1);
		room11.add(3);
		List<Integer> room12 = new ArrayList<>();
		room12.add(3);
		room12.add(0);
		room12.add(1);
		List<Integer> room13 = new ArrayList<>();
		room13.add(2);
		List<Integer> room14 = new ArrayList<>();
		room14.add(0);
		
		List<List<Integer>> rooms1 = new ArrayList<>();
		rooms1.add(room11);
		rooms1.add(room12);
		rooms1.add(room13);
		rooms1.add(room14);
		System.out.println(canVisitAllRooms(rooms1));
				
	}
	

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
	    visited = new boolean[rooms.size()];     
	    
	    visitRoom(0, rooms);
	    
	    for(int i= 0; i<visited.length; i++)
	        if(!visited[i])
	            return false;
	            
	    return true;   
	}

	public static void visitRoom(int roomIndex, List<List<Integer>> rooms) {
	      if(!visited[roomIndex]){
	          visited[roomIndex] = true;
	          for(int i : rooms.get(roomIndex))
	              visitRoom(i, rooms);
	      }
	}
}



