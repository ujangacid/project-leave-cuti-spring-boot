package com.example.api.reason.apireason.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.api.reason.apireason.model.Leave;
import com.example.api.reason.apireason.utils.query;

@Repository
public class LeaveRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Leave create(Leave data){
        MapSqlParameterSource map = new MapSqlParameterSource();
        // map.addValue("id", data.getId());
        map.addValue("type", data.getType());
        map.addValue("cuti", data.getCuti());
        jdbcTemplate.update(query.createLeave, map);
        return data;
    }

    public List<Leave> list(){
        MapSqlParameterSource map = new MapSqlParameterSource();
        return jdbcTemplate.query(query.listLeave, map, new BeanPropertyRowMapper<>(Leave.class));
    }
    
    public Leave getLeaveById(int id){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(query.getLeaveById,map,new BeanPropertyRowMapper<>(Leave.class));
    }

    public Leave getLeaveByName(String cuti){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("cuti", cuti);
        return jdbcTemplate.queryForObject(query.getLeaveByName,map,new BeanPropertyRowMapper<>(Leave.class));
    }

    public Leave update(Leave data){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("type", data.getType());
        map.addValue("cuti", data.getCuti());
        map.addValue("id", data.getId());
        jdbcTemplate.update(query.updateLeave, map);
        return data;
    }

    public void delete(int id){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query.deleteLeave, map);
    }



}
