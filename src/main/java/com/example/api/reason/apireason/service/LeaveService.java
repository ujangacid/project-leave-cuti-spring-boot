package com.example.api.reason.apireason.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.reason.apireason.model.Leave;
import com.example.api.reason.apireason.repository.LeaveRepository;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    public Leave create(Leave data) {
        return leaveRepository.create(data);
    }

    public List<Leave> list() {
        return leaveRepository.list();
    }

    public Leave getById(int id){
        return leaveRepository.getLeaveById(id);
    }

    public Leave getLeaveByName(String cuti){
        return leaveRepository.getLeaveByName(cuti);
    }

    public Leave update(Leave data) {
        return leaveRepository.update(data);
    }

    public void delete(int id){
        leaveRepository.delete(id);
    }
}
