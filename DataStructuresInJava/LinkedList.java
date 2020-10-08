import java.util.Iterator;

public class LinkedList <T> implements Iterable<T>{
	Node<T> head;
	Node<T> tail;
	int size;
	public  LinkedList() {
		head = tail = null;
	}
	
	@SuppressWarnings("hiding")
	private class Node<T>{
		T data;
		
		Node<T> next;
		Node<T> prev;
		
	  public Node(T data) {
		  this.data = data;
		  this.next = null;
		  this.prev = null;
	  }
		
	}
	public T removeHead() {
		if(head == null) 
			return null;
		T value = head.data;
		head = head.next;
		head.prev = null;
		size--;
		return value;
	}
	
	
	public void addFront(T data) {
		Node<T> newNode = new Node<>(data);
		if(head == null) {
			head = tail = newNode;
			head.next = null;
			head.prev = null;
			
			
			
		}
		else {
			Node<T> temp = head;
			head = newNode;
			temp.prev = head;
			head.next = temp;
			size++;
			
		}
	}
	public void addEnd(T data) {
		Node<T> newNode = new Node<>(data);
		if(head == null) {
			head = newNode;
			head.next = null;
			head.prev = null;
			
		}
		
		else {
			Node<T> temp = head;
			while(temp.next != null) {
				temp = temp.next;
				
			}
			temp.next = newNode;
			newNode.prev = temp;
			newNode.next = null;
			tail = newNode;
		}
		size++;
	}
	public void reverse() {
		Node<T> temp = tail;
		head = null;
		while(temp != null) {
			addEnd(temp.data);
			temp = temp.prev;
		}
	}
	
	public T get(int index) {
		T value = null;
		if(head == null) {
			throw new NullPointerException();
		}
		Node<T> temp = head;
		int i  = 0;
		while(i != index) {
			temp = temp.next;
			i++;
		}
		value = temp.data;
		
		return value;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return size;
	}
	public T remove(T data) {
	    T value = null;
	    Node<T> temp = head;
	    
	    if(size == 0) {
	    	System.out.println("The list is empty");
	    }
	    
	    else if(head.data.equals(data)) {
	    	value = head.data;
	    	head = head.next;
	    	head.prev = null;
	    }
	    else if(tail.data.equals(data)) {
	    	value = head.data;
	    	tail = tail.prev;
	    	tail.next = null;
	    }
	    else {
			while(temp != null && !temp.data.equals(data) ) {
				
				temp = temp.next;
			}
		    value = temp.data;
		    temp.prev.next = temp.next;
		    temp.next.prev = temp.prev;
		    temp.next = null;
		    temp.prev= null;
		   
	    }
	    size--;
	    return value;
	 }
	
	public T peekFirst() {
		if(head == null) {
			throw new NullPointerException();
		}
		return head.data;
	}
		
	public T peekLast() {
		if(head == null) {
			throw new NullPointerException();
		}
		return tail.data;
	}
	
	public boolean removeAt(int index) {
		if (head == null) return false;
		boolean found = false;
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			int i = 0;
			Node<T> temp = head;
			while(i != index) {
			    temp = temp.next;
			    i++;
			}
			remove(temp.data);
			found = true;
		}
		return found;
	}
	
	public void clear() {
		
		head = tail = null;
		
	}
	
	public void print(LinkedList<T> list) {
		Iterator<T> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			
		}
	}
	@Override
	  public Iterator<T> iterator() {
	    return new Iterator<T>() {
	      Node<T> current = head;
	      @Override
	      public boolean hasNext() {
	    	  
	        return current != null;
	      }

	      @Override
	      public T next() {
	    	 T value = current.data ;
	    	 current = current.next;
	        return value;
	      }

	      @Override
	      public void remove() {
	        throw new UnsupportedOperationException();
	      }
	      
	    };
	    }
	
	
	
	
	

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
	
		list.addEnd(1);
		list.addEnd(2);
		list.addEnd(3);
		
	
		//System.out.println("The size of the list "+ list.size());
		//System.out.println("After the linked list is reversed");
		//list.clear();
		System.out.println(list.get(1));
		
		
		
		
		
		

	}

}
