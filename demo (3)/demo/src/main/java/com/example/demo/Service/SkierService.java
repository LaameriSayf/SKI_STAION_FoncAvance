package com.example.demo.Service;

import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.SkierRepository;
import com.example.demo.Repository.SubscriptionRepository;
import com.example.demo.entity.Skier;
import com.example.demo.entity.Subscription;
import lombok.NonNull;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SkierService implements ISkier<Skier> {

    //@autowired ta3ml cablage entre interface et classe

    @Autowired
    SkierRepository sr;
    @Autowired
    CourseRepository cr;
    @Autowired
    SubscriptionRepository ss;

    @Override
    public void addskier(@NonNull Skier s){
        sr.save(s);
    }

    @Override
    public List<Skier> getall(){
        return sr.findAll();
    }
    @Override
    public void delete(Long id){sr.deleteById(id);}
    @Override
    public Skier updateSkier(Skier s){
       return sr.save(s);
    }


    public Skier AffecterSkierToSubscription(Skier skier,Long idSubscription){
        Skier sk=sr.findById(skier.getNumSkier()).orElseThrow(()->new RuntimeException("SkiernOt found"+skier.getNumSkier()));
        Subscription subscription=ss.findById(idSubscription).orElseThrow(()-> new RuntimeException("Subscription not found"+idSubscription));
        sk.setSubscription(subscription);
       return sr.save(sk);
    }

    public List<Skier> retrieveSkiersBySubscriptionType(Subscription subscription) {
        if (subscription == null) {
            throw new IllegalArgumentException("Le paramètre subscription ne doit pas être null.");
        }

        Subscription sub = ss.findById(subscription.getNumSub())
                .orElseThrow(() -> new RuntimeException("Subscription not found with ID: " + subscription.getNumSub()));

        return sr.findSkierBySubscription(sub);
    }

    

}
