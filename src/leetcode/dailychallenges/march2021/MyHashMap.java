package leetcode.dailychallenges.march2021;

public class MyHashMap<K, V> {

	int capacity = 4;
	MyEntry<K, V>[] entry;

	public MyHashMap() {
		entry = new MyEntry[capacity];
	}

	public MyHashMap(int capacity) {
		this.capacity = capacity;
		entry = new MyEntry[capacity];
	}
	
	public void put(K key, V value) {
		// null can't be a key
		if(key == null)
			return;
		int hash = hash(key);
		if(entry[hash] == null) {
			entry[hash] = new MyEntry<>(key, value, null);
		} else {
			MyEntry<K, V> prev = null;
			MyEntry<K, V> current = entry[hash];
			while(current != null) {
				if(entry[hash].key.equals(key)) {
					entry[hash].value = value;
					return;
				}

			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.valueOf(4).hashCode());
		System.out.println(Math.abs(Integer.valueOf(4).hashCode()));
	}
	

	static class MyEntry<K, V> {
		K key;
		V value;
		MyEntry<K, V> next;
		
		public MyEntry(K key, V value, MyEntry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}
}