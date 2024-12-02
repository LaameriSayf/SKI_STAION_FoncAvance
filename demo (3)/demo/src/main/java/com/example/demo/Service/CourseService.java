package com.example.demo.Service;

import com.example.demo.Repository.CourseRepository;
import com.example.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService implements ICourse<Course>{

    @Autowired
    CourseRepository cr;
    @Override
    public List<Course> getall() {
        return cr.findAll();
    }

    @Override
    public void add(Course course) {
    cr.save(course);
    }

    @Override
    public Course update(Course course) {
        return cr.save(course);
    }

    @Override
    public void delete(Long id) {
        cr.deleteById(id);
    }
}
