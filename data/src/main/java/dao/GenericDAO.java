package dao;

import entity.Course;
import entity.Group;

import java.util.List;

public interface GenericDAO<T> {

        void create(T course);
        List<T> findAll();
        T findById(Integer id);
        void deleteAll();
    }

