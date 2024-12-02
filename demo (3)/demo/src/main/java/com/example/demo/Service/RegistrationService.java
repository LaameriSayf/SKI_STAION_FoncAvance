package com.example.demo.Service;

import com.example.demo.Repository.RegistrationRepository;
import com.example.demo.entity.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegistrationService implements IRegistration<Registration> {

    @Autowired
    RegistrationRepository rr;
    @Override
    public List<Registration> getall() {
        return  rr.findAll();
    }

    @Override
    public void add(Registration registration) {
    rr.save(registration);
    }

    @Override
    public Registration update(Registration registration) {
        return rr.save(registration);
    }

    @Override
    public void delete(Long id) {
        rr.deleteById(id);
    }
}
