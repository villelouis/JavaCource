package linkedlist.impl;

import linkedlist.api.TaskLinkedList;

import java.util.Collection;
import java.util.Iterator;

public class CustomLinkedList<E> implements TaskLinkedList<E> {
    private Entity<E> start = null;
    private Entity<E> end = null;
    private int size = 0;

    @Override
    public void add(E e) {
        Entity<E> local = new Entity<>(e);
        if (end != null) {
            local.previous = end;
            end.next = local;
        }
        end = local;
        if (start == null) start = local;
        size++;
    }

    @Override
    public void add(int index, E e) {
        Entity<E> current = getEntityByIndex(index);
        Entity<E> local = new Entity<>(e);
        local.previous = current;
        local.next = current.next;
        current.next = local;
        if (current == end) end = local;
        size++;
    }

    @Override
    public E get(int index) {
        return getEntityByIndex(index).info;
    }

    @Override
    public E remove(int index) {
        Entity<E> current = getEntityByIndex(index);
        if (current.next == null) {
            end = current.previous;
            end.next = null;
        }
        if (current.previous == null) {
            start = current.next;
            start.previous = null;
        }
        return current.info;
    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.size() == 0) return false;
        Iterator<? extends E> iterator = c.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    public int size() {
        return size;
    }

    public String toString() {
        Entity<E> current = start;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (result.length() != 0) result.append(";");
            result.append(current.toString());
            current = current.next;
        }
        return result.toString();
    }

    private Entity<E> getEntityByIndex(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Entity<E> current = start;
        for (int i = 0; i <= index - 1; i++) {
            current = current.next;
        }
        return current;
    }

    private class Entity<E> {
        Entity<E> next;
        Entity<E> previous;
        E info;

        Entity(E info) {
            this.info = info;
        }

        public String toString() {
            return info.toString();
        }
    }

    private class InnerIterator implements Iterator<E> {
        private Entity<E> current = start;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E result = current.info;
            current = current.next;
            return result;
        }
    }


}

