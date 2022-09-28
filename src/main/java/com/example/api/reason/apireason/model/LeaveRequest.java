package com.example.api.reason.apireason.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LeaveRequest {

    private int id;
    
    private int people_id;
    private int leave_id;
    private String reason;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start_date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end_date;
    
    private People people;
    private Leave leave;

    public LeaveRequest(int people_id,int leave_id, Date start_date, Date end_date,String reason){
        // this.id = id;
        this.people_id = people_id;
        // this.people = people;
        this.leave_id = leave_id;
        // this.leave = leave;
        this.start_date = start_date;
        this.end_date = end_date;
        this.reason = reason;
    }

    public LeaveRequest(){}

    public People getPeople(){
        return people;
    }

    public void setPeople(People people){
        this.people = people;
    }

    
    public Leave getLeave(){
        return leave;
    }

    public void setLeave(Leave leave){
        this.leave = leave;
    }

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY);
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getPeopleId(){
        return people_id;
    }

    public void setPeopleId(int people_id){
        this.people_id = people_id;
    }

    public int getLeaveId(){
        return leave_id;
    }

    public void setLeaveId(int leave_id){
        this.leave_id = leave_id;
    }

    public Date getstartDate(){
        return start_date;
    }

    public void setStartDate(Date start_date){
        this.start_date = start_date;
    }

    public Date getEndDate(){
        return end_date;
    }

    public void setEndDate(Date end_date){
        this.end_date = end_date;
    }

    public String getReason(){
        return reason;
    }

    public void setReason(String reason){
        this.reason = reason;
    }


}
