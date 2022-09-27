package com.example.api.reason.apireason.model;


import org.springframework.data.annotation.Id;


public class People {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String position;
    private String nip;

    public People(int id,String name,String address,String position,String nip) {
        // this.id = id;
        this.name = name;
        this.address = address;
        this.position = position;
        this.nip = nip;
    }

    public People(){}

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getNip(){
        return nip;
    }

    public void setNip(String nip){
        this.nip = nip;
    }


}
