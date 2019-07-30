package com.example.datastructure.trie;

public class TrieMain {
    public static void main(String[] args) {
        final Trie trie = new Trie();
        trie.insert("alok");
        trie.insert("alokita");
        trie.insert("ankita");



        trie.printTrie();
    }

}
