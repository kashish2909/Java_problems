class LRUCache 
{
    static class DllNode
    {
        int val;
        DllNode left;
        DllNode right;
        
        public DllNode(int val)
        {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    DllNode head = null;
    DllNode tail = null;
    private int capacity;
    
    private HashMap<Integer, DllNode> KeyToNodeRefMap;
    private HashMap<DllNode, Integer> NodeRefToKeyMap;
    
    public LRUCache(int capacity) 
    {
        KeyToNodeRefMap = new HashMap<>(capacity);
        NodeRefToKeyMap = new HashMap<>(capacity);
        
        this.capacity = capacity;
    }
    
    public int get(int key) 
    {
        if(!KeyToNodeRefMap.containsKey(key))
            return -1;
        
        DllNode dllNode = KeyToNodeRefMap.get(key);
        
        removeNode(dllNode);
        appendNodeAtHead(dllNode);
        
        return dllNode.val;
    }
    
    public void put(int key, int value) 
    {
        DllNode dllNode;
        
        if(KeyToNodeRefMap.containsKey(key))
        {
            dllNode = KeyToNodeRefMap.get(key);
            dllNode.val = value;
            removeNode(dllNode);
        }
        else
        {
            cleanUpIfMaxCapacityReached();
            dllNode = new DllNode(value);
        }
        
        KeyToNodeRefMap.put(key, dllNode);
        NodeRefToKeyMap.put(dllNode, key);
        
        appendNodeAtHead(dllNode);
    }
    
    private void appendNodeAtHead(DllNode dllNode)
    {
        if(head == null)
        {
             head = dllNode;
             tail = head;
        }
        else
        {
            head.left = dllNode;
            dllNode.right = head;
            head = dllNode;
        }
    }
    
    private void removeNode(DllNode dllNode)
    {
         if(head == dllNode)
            head = head.right;
        
        if(tail == dllNode)
            tail = tail.left;
        
        if(dllNode.left != null)
            dllNode.left.right = dllNode.right;
        
        if(dllNode.right != null)
            dllNode.right.left = dllNode.left;
        
        dllNode.left = null;
        dllNode.right = null;
    }
    
    private void cleanUpIfMaxCapacityReached()
    {
        if(KeyToNodeRefMap.size() == capacity)
        {
            Integer keyToBeRemoved = NodeRefToKeyMap.get(tail);
            KeyToNodeRefMap.remove(keyToBeRemoved);
            NodeRefToKeyMap.remove(tail);
            
            removeNode(tail);
        }
    }
}