package generics;

public class KeyValuePair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public void print(){
        System.out.println(key +"= "+value);
    }
}
