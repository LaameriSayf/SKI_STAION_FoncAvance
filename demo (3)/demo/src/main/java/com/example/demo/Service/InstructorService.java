package com.example.demo.Service;

import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.InstructorRepository;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class InstructorService implements IInstructor<Instructor> {

    @Autowired
    InstructorRepository ir;
    @Autowired
    CourseRepository cr;

    @Override
    public List<Instructor> getall() {

        return ir.findAll() ;
    }

    @Override
    public void add(Instructor instructor) {
        ir.save(instructor);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return ir.save(instructor);
    }

    @Override
    public void delete(Long id) {
        ir.deleteById(id);
    }

    public Instructor addInstructorToCourse(Instructor instructor,Long numcCourse){
            Instructor ins=ir.findById(instructor.getNumInstructor()).get();
            Course c=cr.findCourseByNumCourse(numcCourse);
            ins.getCourses().add(c);
            return ir.save(ins);
    }
}
