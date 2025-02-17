package org.example.service;

import java.util.List;

// Creating a generic interface and using generics for solution
// to be more extensible and flexible
public interface DataWriter<T> {
    public int write(String filePath, List<T> data);
}
