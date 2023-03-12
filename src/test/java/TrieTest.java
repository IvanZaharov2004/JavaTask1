import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrieTest {
    Trie trie = new Trie();
    @BeforeEach
    public void Insert() {
        trie = new Trie();
        trie.insert("You");
        trie.insert("are");
        trie.insert("brilliant");
        trie.insert("programmer");
        trie.insert("and");
        trie.insert("good");
        trie.insert("student");
    }

    @Test
    public void testInsertSearch() {
        assertTrue(trie.search("You"));
        assertTrue(trie.search("are"));
        assertTrue(trie.search("brilliant"));
        assertTrue(trie.search("programmer"));
        assertFalse(trie.search("study"));
        assertFalse(trie.search("test"));
    }

    @Test
    public void testRemove() {
        assertTrue(trie.search("programmer"));
        assertTrue(trie.search("You"));
        assertTrue(trie.search("student"));
        assertTrue(trie.search("and"));
        trie.remove("programmer");
        trie.remove("You");
        trie.remove("student");
        trie.remove("and");
        assertFalse(trie.search("and"));
        assertFalse(trie.search("programmer"));
        assertFalse(trie.search("student"));
        assertFalse(trie.search("You"));
    }

    @Test
    public void testPrefix() {
        assertTrue(trie.startsWith("Y"));
        assertTrue(trie.startsWith("pro"));
        assertTrue(trie.startsWith("program"));
        assertTrue(trie.startsWith("stud"));
        assertFalse(trie.startsWith("gram"));
        assertFalse(trie.startsWith("ent"));
        assertFalse(trie.startsWith("ou"));
    }
}