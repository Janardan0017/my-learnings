import java.util.Arrays;

public class LinkedList {

	ListNode head;
	int length;

	// return the first node of list
	public synchronized ListNode getHead(){
		return head;
	}

	public synchronized void insertAtBegin(int data){
		ListNode node = new ListNode(data);
		node.next = head;
		head = node;
		length++;
	}

	public synchronized void insertAtEnd(int data){
		ListNode node = new ListNode(data);
		if(head == null){
			head = node;
		}else {
			ListNode temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;	
		}
		length++;
	}

	public synchronized void insert(int data, int position){
		if(position < 0){
			position = 0;
		}
		if(position > length){
			position = length;
		}
		ListNode node = new ListNode(data);
		if(head == null){
			head = node;
		}else if(position < 2){
			node.next = head;
			head = node;
		}else {
			ListNode temp = head;
			while(position > 2){
				temp = temp.next;
				position--;
			}
			node.next = temp.next;
			temp.next = node;
		}
		length++;
	}

	public synchronized ListNode removeFromBegin(){
		ListNode temp = head;
		if(head != null){
			head = head.next;
			temp = null;
		}
		length--;
		return head;
	}

	public synchronized ListNode removeFromEnd(){
		if(head == null){
			return null;
		}
		if(head.next == null){
			head = null;
			return null;
		}
		ListNode prev = head, current = head.next;
		while(current.next != null){
			prev = current;
			current = current.next;
		}
		current = null;
		length--;
		return head;
	}

	public synchronized void removeMatchingNode(int data){
		if(head == null){
			return;
		}
		if(head.data == data){
			head = head.next;
			return;
		}
		ListNode prev = head, current = head.next;
		while(current != null){
			if(current.data == data){
				prev.next = current.next;
				current = null;
				length--;
				return;
			}
			prev = current;
			current = current.next;
		}
		return;
	}

	@Override
	public String toString(){
		int[] ar = new int[length];
		ListNode temp = head;
		for(int i=0; i<length; i++){
			ar[i] = temp.data;
			temp = temp.next;
		}
		return Arrays.toString(ar);
	}
}