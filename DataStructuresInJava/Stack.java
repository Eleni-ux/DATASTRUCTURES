import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
	
	int capacity = 10;
	ArrayList<T> stack;
	
	
	
	public Stack() {
		stack = new ArrayList<>();
		
	}
	
	public Stack(int capacity) {
		//this.capacity = capacity;
		stack = new ArrayList<>(capacity);
		
	}
	
	public boolean isEmpty() {
		return stack.size() == 0;
		
	}
    public T peek() {
    	return stack.get(stack.size() - 1);
    	
    }
    public T pop() {
    	return stack.removeAt(stack.size() - 1);
    	
    }
    public void push(T data) {
    	
    	stack.add(data);
    	
    }
    @Override
	  public Iterator<T> iterator() {
	    return new Iterator<T>() {
	      int index = 0;

	      @Override
	      public boolean hasNext() {
	    	  
	        return index < stack.size();
	      }

	      @Override
	      public T next() {
	    	T value = stack.get(index);
	    	index++;
	        return value;
	      }

	      @Override
	      public void remove() {
	        throw new UnsupportedOperationException();
	      }
	    };
	  }
    public void print(Stack<T> stack) {
		Iterator<T> itr = stack.iterator();
		while(itr.hasNext()) {
			System.out.println("___"+itr.next()+"___");
			
		}
	}
	
    public static void main(String[] args) {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(1);
    	stack.push(2);
    	stack.push(3);
      	stack.print(stack);
      	System.out.println("Pop : "+stack.pop());
    	System.out.println("Peek : "+stack.peek());
    	System.out.println("Is the stack empty?  "+stack.isEmpty());
      	stack.print(stack);
      	
      	
    	
    }
    
    
}
