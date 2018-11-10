/*
* Original code from Joshua Bloch effectivejava item 18
* package effectivejava.chapter4.item18;
*/
import java.util.*;

// Wrapper class - uses composition in place of inheritance  (Page 90)
public class InstrumentedMap<K,V> extends ForwardingMap<K,V> {
    private int addCount = 0;

    public InstrumentedMap(Map<K,V> s) {
        super(s);
    }

    @Override public V put(K key, V value){
        addCount++;
        return super.put(key,value);
    }


    @Override public void putAll(Map<? extends K,? extends V> m) {
        addCount += m.size();
        super.putAll(m);
    }
    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }
}