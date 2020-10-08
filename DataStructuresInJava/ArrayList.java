import java.util.Iterator;

public class ArrayList<T>  implements Iterable<T>{
	int size;
	int capacity = 10;
	T [] array;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		array = (T[]) new Object[this.capacity];
		
	}
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		//this.capacity = capacity;
		array = (T[]) new Object[capacity];
		
	}
	
	public int size() {
		return this.size;
	}
	public int capacity() {
		return this.capacity;
	}
	@SuppressWarnings("unchecked")
	
	public void add(T data) {
		//If the array is full, create a new array and copy all the elements from the old array
		if(size >= this.capacity) {
			T[] newArray = (T[]) new Object[this.capacity + (this.capacity) /2];
			for(int i = 0; i < size; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[size++] = data;
	}
	@SuppressWarnings("unchecked")
	
	public void insert(T data, int index) {
		//if the index is zero
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		T[] newArray = (T[]) new Object[size + 1];
		if(index == 0) {
			newArray[0] = data;
			int k = 1;
			for(int i = 0; i < size; i++) {
				newArray[k++] = array[i];
			}
			size++;
			
		}
		else if(index == size) {
			
			for(int i = 0; i < size; i++) {
				newArray[i] = array[i];
			}
			newArray[index] = data;
			size++;
			
		}
		else {
			
			for(int i = 0; i < index; i++) {
				newArray[i] = array[i];
			}
			newArray[index] = data;
			int k = index + 1;
			for(int i = index; i < size; i++) {
				newArray[k++] = array[i];
			}
			size++;
		}
		
		array = newArray;
		
		
		
	}
	public void set(int index, T data) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		array[index] = data;
		
	}
	
	public T get(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
			
		
		return array[index];
	}
	
	public T removeAt(int index) {
		T value = array[index];
		if(index >= size) throw new IndexOutOfBoundsException();
		else if(index == 0) {
			int k = 0;
			for(int i = index + 1;  i < size; i++) {
				array[k++] = array[i];
				
			}
			size--;
		}
		else if(index > 0 && index < size - 1) {
			int k = 0;
			for(int i = 0; i < index; i ++) {
				array[k++] = array[i];
			}
			for(int i = index + 1; i < size; i ++) {
				array[k++] = array[i];
			}
			size--;
		}
		else if(index == size -1) {
		
			for(int i = 0; i < size-1; i ++) {
				array[i] = array[i];
			}
			size--;
		}
		return value;
		
	}

	public boolean remove(T data) {
		int k = 0;
		boolean found = false;
		for(int i= 0; i < size; i++) {
			if(array[i].equals(data)) {
				k = i;
				found = true;
			}
			
		}
		removeAt(k);
		return found;
		
	}
	public void clear() {
		for(int i = 0; i < size; i++) {
			array[i]= null;
			
			
		}
		size=0;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}

	
	public void print(ArrayList<T> ary) {
		Iterator<T> itr = ary.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			
		}
	}
	

	
	@Override
	  public Iterator<T> iterator() {
	    return new Iterator<T>() {
	      int index = 0;

	      @Override
	      public boolean hasNext() {
	    	  
	        return index < size();
	      }

	      @Override
	      public T next() {
	        return array[index++];
	      }

	      @Override
	      public void remove() {
	        throw new UnsupportedOperationException();
	      }
	    };
	  }
	public static void main(String[] args) {
	    ArrayList<Integer> array = new ArrayList<Integer>();
	    array.add(1);
	    array.add(2);
	    array.add(3);
	    array.add(4);
	    array.add(5);
	    array.add(6);
	    array.add(7);
	    array.add(8);
	    array.add(9);
	    array.add(10);
	    array.add(11);
	    
	    
	    
	    array.print(array);
	    

	}
	

}
