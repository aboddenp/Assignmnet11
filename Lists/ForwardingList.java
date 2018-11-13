/*
* Original code from Joshua Bloch effectivejava item 18
* modified to forward a collection 
* package effectivejava.chapter4.item18;
*/
import java.util.*;

// Reusable forwarding class (Page 90) in bloch 
public class ForwardingList<E> implements List<E> {
    private final List<E> s;
    public ForwardingList(List<E> s) { this.s = s; }

    public void clear()               { s.clear();            }
    public boolean contains(Object o) { return s.contains(o); }
    public boolean isEmpty()          { return s.isEmpty();   }
    public int size()                 { return s.size();      }
    public Iterator<E> iterator()     { return s.iterator();  }
    public boolean add(E e)           { return s.add(e);      }
    public boolean remove(Object o)   { return s.remove(o);   }
    public boolean containsAll(Collection<?> c)
                                   { return s.containsAll(c); }
    public boolean addAll(Collection<? extends E> c)
                                   { return s.addAll(c);      }
    public boolean removeAll(Collection<?> c)
                                   { return s.removeAll(c);   }
    public boolean retainAll(Collection<?> c)
                                   { return s.retainAll(c);   }
    public Object[] toArray()          { return s.toArray();  }
    public <T> T[] toArray(T[] a)      { return s.toArray(a); }
    @Override public boolean equals(Object o)
                                       { return s.equals(o);  }
    @Override public int hashCode()    { return s.hashCode(); }
    @Override public String toString() { return s.toString(); }

    // methods exclusive for List forwarded to the Composition variable 
    // Aster Bodden 
    public List<E> subList(int fromIndex, int toIndex){return s.subList(fromIndex,toIndex);}
    public ListIterator<E> listIterator(int index){return s.listIterator(index);}
    public ListIterator<E> listIterator(){return s.listIterator();}
    public E set(int index, E element) {return s.set(index,element);}
    public int lastIndexOf(Object o){return s.lastIndexOf(o);}
    public int indexOf(Object o) {return s.indexOf(o);}
    public E remove(int index)   { return s.remove(index);   }
    public void  add(int index, E element){s.add(index,element);}
    public boolean addAll(int index, Collection<? extends E> c){return s.addAll(index,c);}
    public E get(int index){return s.get(index);}



}