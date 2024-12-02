package com.example.demo.Controller;

import com.example.demo.Service.RegistrationService;
import com.example.demo.entity.Registration;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Registration")
@Tag(name = "Gestion Registration")
public class RegistrationController {

    @Autowired
    RegistrationService rs;


    @GetMapping("/getall")
    @Operation(description = "Afficher tous registration")
    public List<Registration> getall(){
        return rs.getall();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Registration r){
        try {
            rs.add(r);
            return ResponseEntity.ok(200+"Ajout Registration effectuer avec succes");
        }catch (Exception e){
            e.getCause().getMessage();
            return ResponseEntity.status(500).body("Failed in add registration");

        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Registration r){
        try {
            List<Registration> l=getall();
            for (Registration rr: l) {
                if (rr.getNumRegistration()==id)rs.update(r);
                return ResponseEntity.ok(200+"Modification avec succes");

            }

        }catch (Exception e){
            e.getCause().getMessage();
            return ResponseEntity.status(500).body("FAiled in modification registration");
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            rs.delete(id);
            return ResponseEntity.ok(200+"Delete avec succes Registration");
        }catch (Exception e){
            e.getCause().getMessage();
            return ResponseEntity.status(500).body("Failed avec delete registration");
        }
    }


}
