/*
* Original code from Joshua Bloch effectivejava item 18
* package effectivejava.chapter4.item18;
* modified to forward Map interface adding and changing the necessary methods 
*/
import java.util.*;

// Reusable forwarding class (Page 90)
public class ForwardingMap<K,V> implements Map<K,V> {
    private final Map<K,V> s;
    public ForwardingMap(Map<K,V> s) { this.s = s; }

public void  clear(){s.clear();}

// code with comments is code that is not needed to implement a Map 

//V compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction){}
//V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction){}
//V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction){}
public boolean containsKey(Object key){return s.containsKey(key);}
public boolean containsValue(Object value){return s.containsValue(value);}
public Set<Map.Entry<K,V>> entrySet(){return s.entrySet();}
public boolean equals(Object o){return s.equals(o);}
public V get(Object key){return s.get(key);}
public V getOrDefault(Object key, V defaultValue){return s.getOrDefault(key,defaultValue);}
public int hashCode(){return s.hashCode();}
public boolean isEmpty(){return s.isEmpty();}
public Set<K>  keySet(){return s.keySet();}
//V merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction){}
public V put(K key, V value){return s.put(key,value);}
public void  putAll(Map<? extends K,? extends V> m){s.putAll(m);}
public V putIfAbsent(K key, V value){return s.putIfAbsent(key,value);}
public V remove(Object key){return s.remove(key);}
public boolean remove(Object key, Object value){return s.remove(key,value);}
public V replace(K key, V value){return s.replace(key,value);}
public boolean replace(K key, V oldValue, V newValue){return s.replace(key,oldValue,newValue);}
//void  replaceAll(BiFunction<? super K,? super V,? extends V> function){}
public int size(){return s.size();}
public Collection<V> values(){return s.values();}

}