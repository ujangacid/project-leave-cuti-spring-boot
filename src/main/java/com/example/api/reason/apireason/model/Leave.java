package com.example.api.reason.apireason.model;

// import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
// import org.springframework.data.relational.core.mapping.Table;

// @EntityScan
// @Table(name = "leave")
public class Leave {
    private int id;
    private String type;
    private String cuti;
    
    public Leave(String type, String cuti){
        // this.id = id;
        this.type = type;
        this.cuti = cuti;
    }

    public Leave(){}

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY);
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
