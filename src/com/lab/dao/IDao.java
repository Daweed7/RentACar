package com.lab.dao;

import java.util.List;

public interface IDao<T> {
    List<T> getAll();

}