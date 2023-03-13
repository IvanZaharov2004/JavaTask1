import java.util.*;

class Trie {
    private final Node root;

    public Trie() {
        root = new Node(' ');
    }
    // Добавление слова
    public void insert(String str) {
        if (search(str))
            return;
        Node current = root;
        for (char c : str.toCharArray()) {
            Node children = current.Sub(c);
            if (children != null)
                current = children;
            else {
                current.listOfChild.add(new Node(c));
                current = current.Sub(c);
            }
            current.count++;
        }
        current.isEnd = true;
    }
    // Поиск слова
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
    // Удаление слова
    public void remove(String str) {
       Node current = root;
       for (char c : str.toCharArray()) {
           Node children = current.Sub(c);
           if (children.count == 1) {
               current.listOfChild.remove(children);
               return;
           }   else {
               current = children;
               children.count--;
           }
       }
       current.isEnd = false;
    }
    // Начинается ли дерево с данного знака
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

class Node {
    boolean isEnd;
    char ch;
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