package org.example.service;

import java.util.*;

// Creating a generic interface and using generics for solution
// to be more extensible and flexible
public interface DataReader<T> {
    List<T> read(String filepath);
}
