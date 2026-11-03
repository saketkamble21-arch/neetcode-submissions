class LRUCache {

    private class Node {

        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private final int capacity;
    private final Map<Integer,Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
		this.map = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertAtBeginning(node);
        return node.value;

    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value=value;
            remove(node);
            insertAtBeginning(node);
        }else{
            if(map.size()==capacity){
                //evict

                Node node = tail.prev;
                remove(node);
                map.remove(node.key);
            }
            Node node = new Node(key,value);
            insertAtBeginning(node);
            map.put(key, node);
        }

    }

    public void remove(Node node){

        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void insertAtBeginning(Node node){
        node.prev=head;
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
    }
    

}
