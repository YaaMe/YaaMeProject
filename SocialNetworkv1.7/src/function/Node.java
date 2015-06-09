package function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import pojo.*;

public class Node {  
    private User me;  
    private Map<Node,Integer> child=new HashMap<Node,Integer>();
    public Node(User me){  
        this.me=me;
    }  
    public User getUser() {  
        return me;  
    }  
    public void setUser(User me) {  
        this.me = me;  
    }  
    public Map<Node, Integer> getChild() {  
        return child;  
    }  
    public void setChild(Map<Node, Integer> child) {  
        this.child = child;  
    }  
}  