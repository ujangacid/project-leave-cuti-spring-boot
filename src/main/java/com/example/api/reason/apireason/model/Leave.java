package com.example.api.reason.apireason.model;

import org.springframework.data.annotation.Id;

public class Leave {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String type;
    private String cuti;
    
    public Leave(int id,String type, String cuti){
        this.id = id;
        this.type = type;
        this.cuti = cuti;
    }

    public Leave(){}

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCuti(){
        return cuti;
    }

    public void setCuti(String cuti) {
        this.cuti = cuti;
    }
}
