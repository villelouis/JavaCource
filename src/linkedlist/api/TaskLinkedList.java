package linkedlist.api;

import java.util.Collection;
import java.util.Iterator;

public interface TaskLinkedList<E> {
    void add(E e);

    void add(int index, E element);

    E get(int index);

    E remove(int index);

    Iterator<E> iterator();

    boolean addAll(Collection<? extends E> c);

}
