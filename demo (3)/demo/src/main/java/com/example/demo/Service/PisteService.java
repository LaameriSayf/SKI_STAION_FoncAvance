package com.example.demo.Service;

import com.example.demo.Repository.PisteRepository;
import com.example.demo.entity.Piste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PisteService implements IPiste<Piste>{
    @Autowired
    PisteRepository pr;
    @Override
    public List<Piste> getall() {
        return pr.findAll();
    }

    @Override
    public void add(Piste piste) {
        pr.save(piste);
    }

    @Override
    public Piste update(Piste piste) {
        return pr.save(piste);
    }

    @Override
    public void delete(Long id) {
        pr.deleteById(id);
    }
}
