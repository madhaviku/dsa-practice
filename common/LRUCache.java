Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
  If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

  class LRUCache {
    int capacity;
    HashMap<Integer, Integer> cache;
    LinkedList<Integer> usageQueue;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        usageQueue = new LinkedList<>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            usageQueue.remove(Integer.valueOf(key));
            usageQueue.addLast(key);
            return cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key, value);
            usageQueue.remove(Integer.valueOf(key));
            usageQueue.addLast(key);
        }else{
            if(cache.size() == capacity){
               int lruKey = usageQueue.removeFirst();
               cache.remove(lruKey); 
            }
            cache.put(key, value);
            usageQueue.addLast(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
