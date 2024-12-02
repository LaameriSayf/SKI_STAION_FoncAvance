package com.example.demo.Controller;

import com.example.demo.Service.CourseService;
import com.example.demo.entity.Course;
import com.example.demo.entity.Piste;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Course")
@Tag(name = "Gestion Course")
public class CourseControler {
    @Autowired
    CourseService cs;

    @GetMapping("/getall")
    public List<Course>getall(){
        return cs.getall();
    }
    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Course c){
        try {
            cs.add(c);
            return ResponseEntity.ok(200+"L ajout est effectuer avec succes");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Ereure dan l'ajout de Course");
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Course c, @PathVariable @NonNull Long id) {
        List<Course> l = getall();
        for (Course cc : l) {
            if (cc.getNumCourse()==id) {
                try {
                    cs.update(c);
                    return ResponseEntity.status(200).body("Modification avec succès");
                } catch (Exception e) {
                    return ResponseEntity.status(500).body("La modification a échoué");
                }
            }
        }
        return ResponseEntity.status(404).body("Piste non trouvée");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable @NonNull Long id){
        cs.delete(id);
        try {
            return ResponseEntity.ok(200+"Suppresion avec succes");

        }catch (Exception e){
            e.getCause().getMessage();
            return ResponseEntity.status(500).body("Suppresion failed");
        }

    }


}
