package com.example.api.reason.apireason.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.reason.apireason.model.People;
import com.example.api.reason.apireason.repository.PeopleRepository;


@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public People create(People data) {
        return peopleRepository.create(data);
    }

    public List<People> list() {
        return peopleRepository.list();
    }

    public People getById(int id){
        return peopleRepository.getPeopleById(id);
    }

    public People getByNip(String nip){
        return peopleRepository.getPeopleByNip(nip);
    }

    public People update(People data) {
        return peopleRepository.update(data);
    }

    public void delete(int id){
        peopleRepository.delete(id);
    }

}
