package com.example.api.reason.apireason.repository;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.api.reason.apireason.model.People;
import com.example.api.reason.apireason.utils.query;

@Repository
public class PeopleRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    public People create(People data) {
        MapSqlParameterSource map = new MapSqlParameterSource();
        // map.addValue("id",data.getId());
        map.addValue("name",data.getName());
        map.addValue("address",data.getAddress());
        map.addValue("position",data.getPosition());
        map.addValue("nip",data.getNip());
        jdbcTemplate.update(query.createPeople,map);
        return data;
    }

    public List<People> list(){
        MapSqlParameterSource map = new MapSqlParameterSource();
        return jdbcTemplate.query(query.listPeople, map, new BeanPropertyRowMapper<>(People.class));
    }
    
    public People getPeopleById(int id){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(query.getPeopleById,map,new BeanPropertyRowMapper<>(People.class));
    }

    public People getPeopleByNip(String nip){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("nip", nip);
        return jdbcTemplate.queryForObject(query.getPeopleByNip,map,new BeanPropertyRowMapper<>(People.class));
    }

    public People update(People data){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name", data.getName());
        map.addValue("address", data.getAddress());
        map.addValue("position", data.getPosition());
        map.addValue("nip", data.getNip());
        map.addValue("id", data.getId());
        jdbcTemplate.update(query.updatePeople, map);
        return data;
    }

    public void delete(int id){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query.deletePeople, map);
    }
}

