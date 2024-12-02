package com.example.demo.Service;

import com.example.demo.Repository.SubscriptionRepository;
import com.example.demo.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubscriptionService implements ISubscription<Subscription>{

    @Autowired
    SubscriptionRepository sr;
    @Override
    public List<Subscription> getall() {
        return sr.findAll();
    }

    @Override
    public void add(Subscription subscription) {
        sr.save(subscription);

    }

    @Override
    public Subscription update(Subscription subscription) {
        return sr.save(subscription);
    }

    @Override
    public void delete(Long id) {
        sr.deleteById(id);
    }
}
