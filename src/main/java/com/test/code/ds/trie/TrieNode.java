package com.test.code.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private Map<Character, TrieNode> childNode = new HashMap<>();
    private boolean isEndOfString;

    public Map<Character, TrieNode> getChildNode() {
        return childNode;
    }

    public void setChildNode(Map<Character, TrieNode> childNode) {
        this.childNode = childNode;
    }

    public boolean isEndOfString() {
        return isEndOfString;
    }

    public void setEndOfString(boolean endOfString) {
        isEndOfString = endOfString;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "childNode=" + childNode +
                ", isEndOfString=" + isEndOfString +
                '}';
    }
}
