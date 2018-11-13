/*
* Original code from Joshua Bloch effectivejava item 18
* modified to InstrumentedList 
* package effectivejava.chapter4.item18;
*/
import java.util.*;

// Wrapper class - uses composition in place of inheritance  (Page 90)
public class InstrumentedList<E> extends ForwardingList<E> {
    private int addCount = 0;

    public InstrumentedList(List<E> s) {
        super(s);
    }

    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }
    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
    public int getAddCount() {
        return addCount;
    }

}