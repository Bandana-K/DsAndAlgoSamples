package basicLinkedList;
public class LinkedList {
	
	Node head;
	
	LinkedList(Node head){
		this.head = head;
	}
	
	LinkedList(){
		this.head = null;
	}
	
	public void insertNode(Node n) {
		if(head == null) {
			head = n;
		}
		else {
			Node traverse = head;
			while(traverse.next != null) {
				traverse= traverse.next;
			}
			traverse.next = n;
		}
	}
	
		
	// 2->3->4->5->6 insert node 9 at position 2 mean => 2->9->3->4->5->6	
	public void insertNodeAtPosition(Node n, int position) {
		
		if(position<1) {
			throw new IllegalStateException("Not possible to put node at");
		}

		else if(position == 1) {
			n.next = head;
			head = n;
		}
		else {
			
			Node traverse = head;
			int count = 1;
			while(count < position-1 && traverse != null) {
				traverse= traverse.next;
				count++;
			}
			
			if(count == position-1) {
				n.next = traverse.next;
				traverse.next = n;
			} else {
				throw new IllegalStateException("Not possible to put node at");
			}
			
		}
	}
	

}