package com.test.code.ds.trie;

public class TrieUtils {

    private static TrieNode root = new TrieNode();


    public static void main(String[] args) {
        insert("pratik");
        insert("abcde");
        insert("prateek");

//        System.out.println(search("prastik"));
        System.out.println(search("pratik"));
//        System.out.println(search("prateek"));
//        System.out.println(search("abc"));
//        System.out.println(search("abcdee"));
//        System.out.println(search("abcde"));

        System.out.println("DELETED " + delete("pratik"));

        System.out.println(search("pratik"));

    }


    private static void insert(String value) {

        TrieNode trieNode = root;

        for (int i = 0; i < value.length(); i++) {
            Character character = value.charAt(i);
            if (trieNode.getChildNode().containsKey(character)) {
                trieNode = trieNode.getChildNode().get(character);
            } else {
                TrieNode node = new TrieNode();
                trieNode.getChildNode().put(character, node);
                trieNode = node;
            }
        }
        trieNode.setEndOfString(true);
    }


    private static boolean search(String value) {
        TrieNode trieNode = root;
        for (int i = 0; i < value.length(); i++) {
            Character character = value.charAt(i);
            if (trieNode == null) {
                break;
            }
            trieNode = trieNode.getChildNode().get(character);
        }
        return trieNode != null && trieNode.isEndOfString();
    }


    private static boolean delete(String value) {
        TrieNode trieNode = root;
        int i = 0;
        return delete(value, i, trieNode);
    }

    private static boolean delete(String value, int i, TrieNode trieNode) {
        if (i >= value.length()) {
            return true;
        }
        Character character = value.charAt(i);
        if (trieNode.getChildNode() != null && !trieNode.getChildNode().isEmpty()) {
            TrieNode prevNode = trieNode;
            trieNode = trieNode.getChildNode().get(character);
            boolean deleted = delete(value, i + 1, trieNode);
            if (deleted) {
                prevNode.getChildNode().remove(character);
                return prevNode.getChildNode().size() == 0;
            }
        } else {
            return trieNode.isEndOfString();
        }
        return false;
    }

}
