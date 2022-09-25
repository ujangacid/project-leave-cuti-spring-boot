package com.example.api.reason.apireason.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.reason.apireason.model.LeaveRequest;
import com.example.api.reason.apireason.service.LeaveRequestService;

@Controller
@RequestMapping("api/leave-request")
public class LeaveRequestController {
    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/")
    public ResponseEntity<LeaveRequest> create
    (
        @RequestBody LeaveRequest data
    )
    {
        return ResponseEntity.ok().body(leaveRequestService.create(data));
    }

    @GetMapping("/")
    public ResponseEntity<List<LeaveRequest>> list() {
        return ResponseEntity.ok().body(leaveRequestService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequest> getById( @PathVariable("id") int id){
        return ResponseEntity.ok().body(leaveRequestService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        String message = "message: id with "+id+" not found";
        for (LeaveRequest leaveRequest : leaveRequestService.list()) {
            if (leaveRequest.getId() == (id)) {
                message = "message: id with "+id+" deleted";
            }
        }
        leaveRequestService.delete(id);
        return ResponseEntity.ok().body(message);
    }
}
