import java.util.*;

class Node{
    char ch;
    boolean isEnd;
    int count;
    LinkedList<Node> listOfChild;

    public Node(char letter) {
        listOfChild = new LinkedList<>();
        ch = letter;
        count = 0;
        isEnd = false;
    }
    public Node Sub(char letter) {
        if (listOfChild != null)
            for (Node children : listOfChild)
                if(children.ch == letter)
                    return children;
        return null;
    }
}

class Trie {
    private final Node root;

    public Trie() {
        root = new Node(' ');
    }
    public void insert(String str) {
        if (search(str))
            return;
        Node current = root;
        for (char c : str.toCharArray()) {
            Node child = current.Sub(c);
            if (child != null)
                current = child;
            else {
                current.listOfChild.add(new Node(c));
                current = current.Sub(c);
            }
            current.count++;
        }
        current.isEnd = true;
    }
    public boolean search(String str) {
        Node current = root;
        for (char c : str.toCharArray()) {
            if (current.Sub(c) == null)
                return false;
            else
                current = current.Sub(c);
        }
        return current.isEnd;
    }
    public void remove(String str) {
       Node current = root;
       for (char c : str.toCharArray()) {
           Node child = current.Sub(c);
           if (child.count == 1) {
               current.listOfChild.remove(child);
               return;
           }    else {
               child.count--;
               current = child;
           }
       }
       current.isEnd = false;
    }
    public boolean startsWith(String str) {
        Node current = root;
        for (char c : str.toCharArray()) {
            if (current.Sub(c) == null)
                return false;
            else
                current = current.Sub(c);
        }
        return true;
    }
}