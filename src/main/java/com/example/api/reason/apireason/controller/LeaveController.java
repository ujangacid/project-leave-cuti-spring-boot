package com.example.api.reason.apireason.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.reason.apireason.model.Leave;
import com.example.api.reason.apireason.service.LeaveService;

@Controller
@RequestMapping("api/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @PostMapping("/")
    public ResponseEntity<Leave> create(
        @RequestBody Leave data
    ){
        // String message = "name aleready exist";
        // for(Leave leave:leaveService.list()){
        //     if (leave.getCuti() == data.getCuti()) {
        //         return ResponseEntity.ok().body(message);
        //     }
        // }
        return ResponseEntity.ok().body(leaveService.create(data));
    }

    @GetMapping("/")
    public ResponseEntity<List<Leave>> list(){
        return ResponseEntity.ok().body(leaveService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leave> getById(
        @PathVariable("id") int id
    ){
        return ResponseEntity.ok().body(leaveService.getById(id));
    }

    @PutMapping("/")
    public ResponseEntity<Leave> update(
        @RequestBody Leave data
    ){
                // String message = "name aleready exist";
        // for(Leave leave:leaveService.list()){
        //     if (leave.getCuti() == data.getCuti()) {
        //         return ResponseEntity.ok().body(message);
        //     }
        // }
        return ResponseEntity.ok().body(leaveService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
        @PathVariable("id") int id
    ){
        String message = "message: id "+id+" not found";
        for (Leave leave : leaveService.list()) {
            if (leave.getId() == (id)) {
                message = "message: id "+id+" deleted";
            }
        }
        leaveService.delete(id);
        return ResponseEntity.ok().body(message);
    }
    
}
