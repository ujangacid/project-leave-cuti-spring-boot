package com.example.api.reason.apireason.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.api.reason.apireason.model.Leave;
import com.example.api.reason.apireason.model.LeaveRequest;
import com.example.api.reason.apireason.model.People;
import com.example.api.reason.apireason.utils.query;

@Repository
public class LeaveRequestRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public LeaveRequest create(LeaveRequest data){
        MapSqlParameterSource map = new MapSqlParameterSource();
        // map.addValue("id", data.getId());
        map.addValue("people_id", data.getPeople());
        map.addValue("leave_id", data.getLeave());
        map.addValue("start_date", data.getstartDate());
        map.addValue("end_date", data.getEndDate());
        map.addValue("reason", data.getReason());
        jdbcTemplate.update(query.createLeaveRequest, map);
        return data;
    }

    public List<LeaveRequest> list(){
        MapSqlParameterSource map = new MapSqlParameterSource();
        return jdbcTemplate.query(query.listLeaveRequest, map, new RowMapper<LeaveRequest>() {
            @Override
            public LeaveRequest mapRow(ResultSet resultSet, int i) throws SQLException {
                
                LeaveRequest leaveRequest = new LeaveRequest();
                leaveRequest.setId(resultSet.getInt("id"));
                leaveRequest.setPeopleId(resultSet.getInt("people_id"));
                leaveRequest.setLeaveId(resultSet.getInt("leave_id"));
                leaveRequest.setStartDate(resultSet.getDate("start_date"));
                leaveRequest.setEndDate(resultSet.getDate("end_date"));
                leaveRequest.setReason(resultSet.getString("reason"));

                People people = new People();
                people.setId(resultSet.getInt("id"));
                people.setName(resultSet.getString("name"));
                people.setAddress(resultSet.getString("address"));
                people.setPosition(resultSet.getString("position"));
                people.setNip(resultSet.getString("nip"));
                leaveRequest.setPeople(people);

                Leave leave = new Leave();
                leave.setId(resultSet.getInt("id"));
                leave.setType(resultSet.getString("type"));
                leave.setCuti(resultSet.getString("cuti"));
                leaveRequest.setLeave(leave);

                return leaveRequest;
            }
        });
    }

    public LeaveRequest getById(int id) {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(query.getLeaveRequestById, map, new RowMapper<LeaveRequest>() {
            @Override
            public LeaveRequest mapRow(ResultSet resultSet, int i) throws SQLException {
                
                LeaveRequest leaveRequest = new LeaveRequest();
                leaveRequest.setId(resultSet.getInt("id"));
                leaveRequest.setPeopleId(resultSet.getInt("people_id"));
                leaveRequest.setLeaveId(resultSet.getInt("leave_id"));
                leaveRequest.setStartDate(resultSet.getDate("start_date"));
                leaveRequest.setEndDate(resultSet.getDate("end_date"));
                leaveRequest.setReason(resultSet.getString("reason"));

                People people = new People();
                people.setId(resultSet.getInt("id"));
                people.setName(resultSet.getString("name"));
                people.setAddress(resultSet.getString("address"));
                people.setPosition(resultSet.getString("position"));
                people.setNip(resultSet.getString("nip"));
                leaveRequest.setPeople(people);

                Leave leave = new Leave();
                leave.setId(resultSet.getInt("id"));
                leave.setType(resultSet.getString("type"));
                leave.setCuti(resultSet.getString("cuti"));
                leaveRequest.setLeave(leave);

                return leaveRequest;
            }
        });
    }

    public void delete(int id){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query.deleteLeaveRequest, map);
    }
}
