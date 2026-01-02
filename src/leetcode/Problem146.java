package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem146 {

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(1);
        // obj.put(1, 1);
        obj.put(2, 1);
        // System.out.println(obj.get(1));
        // obj.put(3, 3);
        System.out.println(obj.get(2));
    }

    static class LRUCache {

        private final int size;
        private final Map<Integer, ListNode> map;
        private ListNode head = null;
        private ListNode tail = null;

        public LRUCache(int capacity) {
            size = capacity;
            map = new HashMap<>();
        }

        public int get(int key) {
            ListNode node = map.get(key);
            if (node != null) {
                markAsRecentlyUsed(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            ListNode node = map.get(key);
            // if key already exists
            if (node != null) {
                // update node value
                node.value = value;
                markAsRecentlyUsed(node);
            } else {
                // remove tail and new element at head
                if (map.size() == size) {
                    map.remove(tail.key);
                    tail = tail.prev;
                    tail.next = null;
                }
                ListNode newNode = new ListNode(null, key, value, head);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    head.prev = newNode;
                    map.put(head.key, head);
                    head = newNode;
                }
                map.put(key, newNode);
            }
        }

        private void markAsRecentlyUsed(ListNode node) {
            if (node == head) {
                return;
            }
            if (node == tail) {
                ListNode temp = tail;
                tail = tail.prev;
                tail.next = null;
                temp.prev = null;
                temp.next = head;
                head.prev = temp;
                head = temp;
                return;
            }
            ListNode prevNode = node.prev;
            ListNode nextNode = node.next;
            prevNode.next = node.next;
            // map.put(prevNode.key, prevNode);
            nextNode.prev = node.prev;
            // map.put(nextNode.key, nextNode);
            head.prev = node;
            node.next = head;
            head = node;
        }

        private class ListNode {

            ListNode prev;
            int key;
            int value;
            ListNode next;

            public ListNode(ListNode prev, int key, int value, ListNode next) {
                this.prev = prev;
                this.next = next;
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                ListNode temp = this.prev;
                List<String> items = new ArrayList<>();
                while (temp != null) {
                    items.add(0, String.format("(%s,%s)", temp.key, temp.value));
                    temp = temp.prev;
                }
                items.add(String.format("[%s,%s]", this.key, this.value));
                temp = this.next;
                while (temp != null) {
                    items.add(String.format("(%s,%s)", temp.key, temp.value));
                    temp = temp.next;
                }
                return String.join("<=>", items);
            }
        }
    }
}
