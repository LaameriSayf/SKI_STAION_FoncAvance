package com.example.demo.Service;


import java.util.List;

public interface ISkier<T> {
    List<T> getall();
    void addskier(T t);

    T updateSkier(T t);

   void delete(Long id);

}
