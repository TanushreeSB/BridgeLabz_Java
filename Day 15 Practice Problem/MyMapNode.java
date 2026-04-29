class MyMapNode<K, V> {
    K key;
    V value;
    MyMapNode<K, V> next;

    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashTable<K, V> {
    private int numBuckets;
    private MyMapNode<K, V>[] bucketArray;

    public MyHashTable(int numBuckets) {
        this.numBuckets = numBuckets;
        this.bucketArray = new MyMapNode[numBuckets];
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % numBuckets;
    }

    // UC 1 & 2: Add or Update Frequency
    public void add(K key, V value) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = bucketArray[index];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        MyMapNode<Integer, Integer> newNode = new MyMapNode(key, value);
        newNode.next = bucketArray[index];
        bucketArray[index] = (MyMapNode<K, V>) newNode;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = bucketArray[index];
        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    // UC 3: Remove a specific word
    public void remove(K key) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = bucketArray[index];
        MyMapNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) bucketArray[index] = head.next;
                else prev.next = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}