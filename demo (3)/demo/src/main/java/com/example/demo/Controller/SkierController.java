package com.example.demo.Controller;

import com.example.demo.Service.SkierService;
import com.example.demo.entity.Skier;
import com.example.demo.entity.Subscription;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/skier")
@Tag(name="Gestion Skier ")

public class SkierController {

    @Autowired
    SkierService ss;
//lki yabvda andi double imlementation ala nafes interfaces nesta3ml @Primary
    @Operation(description = "Ajouter nouveau skier")
    @PostMapping("/add")
    @Transactional
    /*L'annotation @Transactional en Spring Boot est utilisée pour gérer les transactions dans une application.
    Elle garantit que toutes les opérations effectuées dans une méthode annotée sont traitées dans une seule transaction.
     Si une exception se produit pendant l'exécution, la transaction sera annulée (rollback) pour empêcher que des changements
     partiels soient enregistrés dans la base de données.
    * */
    public ResponseEntity<?> addskier(@RequestBody Skier s){
        try{
            ss.addskier(s);
            return ResponseEntity.ok("l'ajout est effectuer avec succes");
        }catch (Exception e){
            return ResponseEntity.status(400).body("Probléme avec l'ajout");
        }

    }

    @GetMapping("/getall")
    public List<Skier> getall(){
        List ll=ss.getall();

        return ll;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteSkier(@PathVariable Long id){
        if (id==null){
            System.out.println("id n'est pas saisir");
        }
        try {
            ss.delete(id);
            return ResponseEntity.ok("Le skier est supprimer avec succes");
        }catch (Exception e){
            return ResponseEntity.status(400).body("la suppresion est echouer");
        }
    }

    @PutMapping("/update/{id}")
    public Skier UpdateSkier(@PathVariable @NonNull long id,@RequestBody Skier s){
      List<Skier> l=getall();
        for (Skier b:l) {
            if (b.getNumSkier()==id)return s;
        }
        return ss.updateSkier(s);
    }

    @PutMapping("/AffecterSkierToSubscription/{idsubscription}")
    @Operation(description="Affectaion Skier To SUbscribtion")
    public Skier AffecterSkierToSubscribtion(@PathVariable @NonNull Long idsubscription,@RequestBody Skier skier){
        try{
            ss.AffecterSkierToSubscription(skier,idsubscription);
            System.out.println("Affectation relezed");
        }catch (Exception e){
            e.printStackTrace();
            e.getCause().getMessage();

        }
      return null;
    }

    @GetMapping("/GetSkierBySubscriptionType")
    public List<Skier> getSkierBySubscribtion(@RequestBody Subscription subscription){
        try {
         return    ss.retrieveSkiersBySubscriptionType(subscription);
        }catch (Exception e){
            e.getCause().getMessage();
        }
      return null;
    }

 /*   @GetMapping("test/{GainJours}")
    public ResponseEntity<?> stock(@PathVariable int GainJours){

        int przemierjours=10;
        int TotalParJours=0;
        for (int i=0;i<=30;i++){
            TotalParJours+=GainJours;
         return ResponseEntity.status(200).body(GainJours*=przemierjours*2);
            }
        return null;
    }
    @GetMapping("/Somme/{i}")

    public ResponseEntity<?> somme(@PathVariable @NonNull long i){

        int total=0;
       int  GainJours=10;

        for (i=0;i<=30;i++){
           total=GainJours*2;

            return ResponseEntity.status(200).body("Montant gane le jour"+i+""+GainJours);
        }
        return null;
    }

*/



}
