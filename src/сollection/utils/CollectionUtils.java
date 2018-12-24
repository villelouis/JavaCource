package сollection.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<? extends T> limit(List<? extends T> source, int size) {
        int toIndex = source.size();
        if (size < toIndex) toIndex = size;
        return source.subList(0, toIndex - 1);
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T c2Element : c2) {
            if (c1.contains(c2Element)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<? super T>> List<? extends T> range(List<? extends T> list, T min, T max) {
        List<T> listResult = new ArrayList<>();
        for (T o : list) {
            if (o.compareTo(min) >= 0 && o.compareTo(max) <= 0) {
                listResult.add(o);
            }
        }
        return listResult;
    }

    public static <T> List<? extends T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> listResult = new ArrayList<>();
        for (T o : list) {
            if (comparator.compare(o, min) >= 0 && comparator.compare(o, max) <= 0) {
                listResult.add(o);
            }
        }
        return listResult;
    }

}
