public class HashMap<K, V>{
	   
		private SimpleHash<Pair<K, V>> set = new SimpleHash<>();

		public boolean put(K key, V value) {
			Pair<K, V> pair = new Pair<>(key, value);
			return set.add(pair);
		}

		public boolean update(K key, V value) {
			Pair<K, V> pair = new Pair<>(key, value);
			if (!remove(key)) {
				return false;
			}
			return set.add(pair);
		}

	
		public boolean remove(K key) {
			Pair<K, V> pair = new Pair<>(key, null);
			return set.remove(pair);
		}

		
		public V getValue(K key) {
			Pair<K, V> pair = new Pair<>(key, null);
			return set.get(pair).getValue();
		}


		public boolean rehash(int newCapacity) {
			return set.rehash(newCapacity);
		}

		public int size() {
			return set.size();
		}

		public double getLoad() {
			return set.getLoad();
		}

		@SuppressWarnings("unchecked")
		public Object[] valuesToArray() {
			Object[] setValues = set.valuesToArray();
			Object[] arr = new Object[setValues.length];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = ((Pair<K, V>) setValues[i]).getValue();
			}

			return arr;
		}
		private static class Pair<K, V> {
			/**
			 * Key
			 */
			private K key;
			/**
			 * Value
			 */
			private V value;

			/**
			 * Constractor
			 * 
			 * @param key
			 * @param value
			 */

			public Pair(K key, V value) {

				this.key = key;
				this.value = value;
			}

			/**
			 * Returns true if two keys are equal
			 */
			@SuppressWarnings("unchecked")
			public boolean equals(Object o) {

				if (o == null && this.getKey() == null) {
					return false;

				}
				if (o instanceof Pair) {
					Pair<K, V> key1 = (Pair<K, V>) o;
					if (key1.key != null && key1.value != null) {
						return this.key.equals(key1.key);
					}

				}

				return false;
			}

			
			@Override
			public int hashCode() {
				int hash = 17;
				hash = 31 * hash + getKey().hashCode();
				return hash;
			}

			public String toString() {

				return "<" + getKey() + "," + getValue() + ">";
			}

			
			public K getKey() {

				return this.key;
			}

			
			public V getValue() {
				return this.value;
			}
		}

		
		public void print() {
			for(int i = 0; i < set.size(); i++) {
				System.out.println(set.get(i).toString());
			}
		}


	public static void main(String[] args) {
	    HashMap<Integer, String> employee = new HashMap<>();
	    employee.put(1, "John");
	    employee.put(2, "Thomas");
	    employee.put(3, "Johan");
	    employee.put(4, "Alex");
	    System.out.println("HashMap before remove ");
	    employee.print();
	    employee.remove(4);
	    System.out.println("\n\nHashMap after remove ");
	    employee.print();
	    

	}

}
