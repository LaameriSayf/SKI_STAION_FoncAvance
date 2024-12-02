package com.example.demo.Repository;

import com.example.demo.entity.Skier;
import com.example.demo.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkierRepository extends JpaRepository<Skier,Long> {
    List<Skier> findSkierByNumSkier(Long numskier);
    List<Skier> findSkierBySubscription(Subscription subscription);
}
