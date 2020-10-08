
public class SimpleHash<T> {


	
	private int current_size = 0;
	

	private Object[] hashTable = new Object[11];

	
	
	public boolean add(T value) {
		
		if (value == null) {

			return false;
		} else {
			int temp = value.hashCode() % hashTable.length;
			int index = Math.abs(temp);

			do {

				if (hashTable[index] == null) {
					hashTable[index] = value;
					current_size++;
					if (getLoad() > 0.7) {
						rehash(nextPrime(2 * hashTable.length));
					}
					return true;
				}

				else if (hashTable[index].equals(value)) {
					return false;

				}

				index = (index + 1) % hashTable.length;

			} while (index != temp);
		}

		return false;
	}

	

	public boolean remove(T value) {

		if (get(value) == null) {
			return false;

		} else if (!contains(value)) {
			return false;

		} else if (get(value).equals(value) || contains(value)) {
			int hash = value.hashCode() % hashTable.length;

			hashTable[hash] = null;
			current_size--;
			return true;

		}
		rehash(nextPrime(2 * hashTable.length));

		return false;
	}

	
	@SuppressWarnings("unchecked")
	public T get(T value) {

		T result = null;
		for (int i = 0; i < hashTable.length; i++) {
			if (value.equals(hashTable[i])) {

				result = (T) hashTable[i];
			}
		}
		return result;
	}
	@SuppressWarnings("unchecked")

	public T get(int index) {

		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		T result = (T) hashTable[index];
		
		return result;
	}

	public boolean contains(T value) {
		return get(value) != null;
	}


	@SuppressWarnings("unchecked")
	public boolean rehash(int newCapacity) {
		boolean result = false;
		if (newCapacity <= current_size || newCapacity <= 0 || ((current_size) / hashTable.length) > 0.7) {
			result = false;
		}
		Object[] removeValue = valuesToArray();
		hashTable = new Object[newCapacity];
		for (int index = 0; index < removeValue.length; index++) {
			current_size--;
			add((T) removeValue[index]);
			result = true;
		}

		return result;
	}

	/**
	 * return the number of items in the table
	 * 
	 * @return
	 */
	public int size() {

		return current_size;
	}

	/**
	 * return the load on the table
	 * 
	 * @return
	 */
	public double getLoad() {

		return (double) (current_size) / hashTable.length;
	}


	@SuppressWarnings("unchecked")
	public Object[] valuesToArray() {

		Object[] newArray = new Object[size()];
		int i = 0;
		for (int index = 0; index < hashTable.length; index++) {
			if (hashTable[index] != null) {
				newArray[i] = hashTable[index];
				i++;
			}

		}

		return newArray;
	}


	public int nextPrime(int x) {
		while (true) {
			boolean isPrime = true;
			for (int i = 2; i < Math.sqrt(x); i++) {
				if (x % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				return x;
			x++;
		}
	}


}



