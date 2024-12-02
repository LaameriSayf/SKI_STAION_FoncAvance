package com.example.demo.Controller;

import com.example.demo.Service.InstructorService;
import com.example.demo.entity.Instructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@Tag(name="Gestion Instructor")
public class InstructorController {

    @Autowired
    InstructorService is;
    @GetMapping("/getall")
    public List<Instructor> getall(){
        return is.getall();
    }


    @PutMapping("/update/{id}")
    @Operation(description = "Update response  json ")
    public ResponseEntity<?> update(@PathVariable @NonNull Long id, @RequestBody Instructor i){
        List<Instructor>l =getall();
        for (Instructor ii:l) {
            if (ii.getNumInstructor()==id)is.update(i);
            return ResponseEntity.ok(200+"Update succes");

        }
        return ResponseEntity.status(500).body("faillaure in update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable @NonNull Long id){
        try {
            is.delete(id);
                return ResponseEntity.ok(200+"Succes delete Instructor");
        }catch (Exception e){
            e.getCause().getMessage();
            return ResponseEntity.status(500).body("ereure delelte INstructor");

        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Instructor i){
        try {
            is.add(i);
            ResponseEntity.ok(200+"Ajou Instructor avec succes");
        }catch (Exception e){
            e.getCause().getMessage();
            return ResponseEntity.status(500).body("failaure dans ajout instructor");
        }
        return null;
    }

    @PutMapping("/AffecterInstrucTorCourse/{numcourse}")
    @Operation(description = "Affecter Instructor au Course")
    public Instructor affecterInstructorToCourse(@PathVariable Long numcourse,@RequestBody Instructor ins){
        return is.addInstructorToCourse(ins,numcourse);
    }
}
