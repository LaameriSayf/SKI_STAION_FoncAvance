package com.example.demo.Controller;

import com.example.demo.Service.PisteService;
import com.example.demo.entity.Piste;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("piste")
@Tag(name="Gestion Piste")
public class PisteController {

    @Autowired
    PisteService ps;

    @GetMapping("/getall")
    public List<Piste> getall(){
       return ps.getall();
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Piste p){
        try {
            ps.add(p);
            return ResponseEntity.ok(200+"L ajout est effectuer avec succes");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Ereure dan l'ajout de Piste");
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Piste p, @PathVariable @NonNull Long id) {
        List<Piste> l = getall();
        for (Piste pp : l) {
            if (pp.getNumPiste()==id) {
                try {
                    ps.update(p);
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
        ps.delete(id);
        try {
            return ResponseEntity.ok(200+"Suppresion avec succes");

        }catch (Exception e){
            e.getCause().getMessage();
            return ResponseEntity.status(500).body("Suppresion failed");
        }

    }

}
