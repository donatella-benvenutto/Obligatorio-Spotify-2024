package uy.edu.um.adt.linkedlist;

import java.util.List;

public interface MyList<T> {

    void add(T value);

    T get(int position);

    boolean contains(T value);

    void remove(T value);

    int size();

    void addToPosition(T value, int position);

    public String parseMylisttoString();

    public MyList<T> parseFromJavaList(List<T> list);
}
