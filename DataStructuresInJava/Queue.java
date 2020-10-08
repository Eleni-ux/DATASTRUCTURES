
import java.util.Iterator;
import java.util.NoSuchElementException;



public class Queue<T> implements Iterable<T>{
	
	
	LinkedList<T> queue;
	public Queue() {
		queue = new LinkedList<>();
	}

	
	public void add(T data) {
		queue.addEnd(data);
		
		
	}
	public T peek() {
		return queue.get(0);
		
	}
	public T poll() {
		return queue.removeHead();
		
	}
	public T remove() {
		T value =  queue.removeHead();
		if (value == null) throw new NoSuchElementException();
		return value;
		
	}
	public void print(Queue<T> list) {
		Iterator<T> itr = list.queue.iterator();
		while(itr.hasNext()) {
			System.out.print(" | "+itr.next()+" | ");
			
		}
		
	}
	
		@Override
		  public Iterator<T> iterator() {
		    return new Iterator<T>() {
		   
		      @Override
		      public boolean hasNext() {
		    	  
		        return queue.iterator().hasNext();
		      }

		      @Override
		      public T next() {
		    	 return queue.iterator().next();
		      }

		      @Override
		      public void remove() {
		        throw new UnsupportedOperationException();
		      }
		      
		    };
		    }
		

	      
	
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println("Print the queue");
		queue.print(queue);
		System.out.println("\n\nAfter peeking the first element: ");
		queue.peek();
		queue.print(queue);
		System.out.println("\n\nAfter polling the first element: ");
		queue.poll();
		queue.print(queue);
		System.out.println("\n\nAfter removing the fisrt element: ");
		queue.remove();
		queue.print(queue);
		
		
		
		

	}

}
