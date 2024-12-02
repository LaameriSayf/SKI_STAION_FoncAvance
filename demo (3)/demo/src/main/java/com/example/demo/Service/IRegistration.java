package com.example.demo.Service;

import java.util.List;

public interface IRegistration <T> {
    List<T>getall();
    void add(T t);
    T  update(T t);
    void delete(Long id);
}
