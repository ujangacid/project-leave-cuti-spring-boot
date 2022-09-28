package com.example.api.reason.apireason.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.reason.apireason.model.LeaveRequest;
import com.example.api.reason.apireason.repository.LeaveRequestRepository;


@Service
public class LeaveRequestService {
    @Autowired
    LeaveRequestRepository leaveRequestRepository;

    public LeaveRequest create(LeaveRequest data){
        return leaveRequestRepository.create(data);
        // LeaveRequest leaveRequest = leaveRequestRepository.create(data);
        // return getById(data.getId());
    }

    public List<LeaveRequest> list(){
        return leaveRequestRepository.list();
    }

    public LeaveRequest getById(int id){
        return leaveRequestRepository.getById(id);
    }

    public void delete(int id){
       leaveRequestRepository.delete(id);
    }
}
