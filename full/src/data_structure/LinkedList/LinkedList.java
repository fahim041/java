package data_structure.LinkedList;

import java.util.NoSuchElementException;

public class LinkedList{
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item){
        var node = new Node(item);
        if(first == null){
            first = last =  node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item){
        var node = new Node(item);
        if(first == null){
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void removeFirst(){
        if(first == null) throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            size = 0;
            return;
        }
        var temp = first.next;
        first.next = null;
        first = temp;
        size--;
    }

    public void removeLast(){
        if(first == null) throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            size = 0;
            return;
        }
        var current = first;
//        5->2->7
        while(current.next.next != null){
            current = current.next;
        }

        current.next = null;
        last = current;
        size--;
    }

    public void print(){
        var current = first;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        };
    }

    public int indexOf(int item){
        var current = first;
        int index = 0;
        while(current != null){
            if(current.value == item){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = first;
        int index = 0;
        while(current != null){
            array[index++] = current.value;
            current = current.next;
        };
        return array;
    }

    public void reverse(){
        if(first == null) return;
        var prev = first;
        var current = first.next;
        while(current != null){
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = prev;

    }

    public int getKthFromTheEnd(int k){
        var a = first;
        var b = first;
        for(int i = 0; i < k - 1; i++){
            b = b.next;
            if(b == null){
                throw new IllegalArgumentException();
            }
        };
        while(b != last){
            a = a.next;
            b = b.next;
        }
        return a.value;
    }
}
