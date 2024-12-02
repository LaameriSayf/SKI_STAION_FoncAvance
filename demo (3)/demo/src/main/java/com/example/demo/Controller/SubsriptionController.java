package com.example.demo.Controller;

import com.example.demo.Repository.SubscriptionRepository;
import com.example.demo.Service.SubscriptionService;
import com.example.demo.entity.Subscription;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Subscription")
@Tag(name="Gestion Subscription")
public class SubsriptionController {
    @Autowired
    SubscriptionService ss;

    @GetMapping("/getall")
    public List<Subscription>getall(){
        return ss.getall();
    }

    @PostMapping("/add")
    public ResponseEntity<?>add(@RequestBody Subscription s){
        try {
             ss.add(s);
             return ResponseEntity.ok(200+"ajou avec succes");
        }catch (Exception e){
            e.getCause().getMessage();
            return ResponseEntity.status(500).body("Failed dajouter subscription");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@RequestBody Subscription s,
                                   @PathVariable @NonNull Long id)
    {
        List<Subscription> l=getall();
        for (Subscription sss:l) {
            if (sss.getNumSub()==id)ss.update(s);
            return ResponseEntity.ok(200+"update success");
        }
        return ResponseEntity.status(500).body("failed in update subscrition");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable @NonNull Long id){
        try {
            ss.delete(id);
            return ResponseEntity.ok(200+"Delete succes");
        }catch (Exception e){
            e.getCause().getMessage();
            return ResponseEntity.status(200).body("failed in delete subscription");
        }

    }
}
