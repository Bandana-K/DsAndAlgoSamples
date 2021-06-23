package basicLinkedList;

public class DriverClass {

	public static void main(String[] args) {

		Node head = new Node(3, null);
		LinkedList list = new LinkedList(head);
		
		print(list);
		list.insertNodeAtPosition(new Node(2, null), 1);
		
		print(list);
		list.insertNodeAtPosition(new Node(4, null), 3);
		
		print(list);
		list.insertNodeAtPosition(new Node(5, null), 1);
		
		print(list);
		list.insertNodeAtPosition(new Node(6, null), 2);

		// 2->3->4->5->6 insert node 9 at position 2 mean => 2->9->3->4->5->6


		print(list);
	}
	
	
	
	static void print(LinkedList list) {
		
		Node traverse = list.head;
		while(traverse != null) {
			System.out.print(traverse.data + " ");
			traverse= traverse.next;
		}	
		System.out.println();
	}

}
