package itmo.java_base.lesson10;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ArrayIterator<T> implements Iterable<T> {
    private final List<T> list;

    public ArrayIterator(T[] array) {
        this.list = new ArrayList<>();
        Collections.addAll(list, array);
    }

    public  ArrayIterator(T[][] array){
        this.list = new ArrayList<>();
        for(T[] ts : array)
            this.list.addAll(Arrays.asList(ts));
    }
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
