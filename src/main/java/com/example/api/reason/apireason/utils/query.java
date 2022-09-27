package com.example.api.reason.apireason.utils;

public interface query {
    //people
    String createPeople="insert into people (name,address,position,nip) values (:name,:address,:position,:nip)";
    String listPeople = "select id,name,address,position,nip from people order by id asc";
    String getPeopleById = "select id,name,address,position,nip from people where id = :id order by id asc";
    String getPeopleByNip = "select nip,password from people where nip= :nip";
    String updatePeople = "update people set name=:name,address=:address,position=:position,nip=:nip where id=:id";
    String deletePeople = "delete from people where id=:id";
    // String searchPeople = "select name,address,position,nip from people where name ilike $1 and address ilike $2 and position ilike $3";

    //leave
    String createLeave = "insert into leave (type,cuti) values (:type,:cuti)";
    String listLeave = "select id,type,cuti from leave order by id asc";
    String getLeaveByName = "select type,cuti from leave where cuti = :cuti order by id asc";
    String getLeaveById = "select id,type,cuti from leave where id = :id order by id asc";
    String updateLeave = "update leave set type = :type, cuti = :cuti where id = :id";
    String deleteLeave = "delete from leave where id = :id";

    //leave request
    String createLeaveRequest = "insert into leave_request (people_id,leave_id,start_date,end_date,reason) values :people_id,:leave_id,:start_date,:end_date,:reason)";
    String listLeaveRequest = "select lr.id,lr.people_id,lr.leave_id,lr.start_date,lr.end_date,lr.reason,p.id,p.name,p.address,p.position,p.nip,l.id,l.type,l.cuti from leave_request lr join people p on lr.people_id = p.id join leave l on lr.leave_id = l.id order by lr.id asc";
    String getLeaveRequestById = "select lr.id,lr.people_id,lr.leave_id,lr.start_date,lr.end_date,lr.reason,p.id,p.name,p.address,p.position,p.nip,l.id,l.type,l.cuti from leave_request lr join people p on lr.people_id = p.id join leave l on lr.leave_id = l.id where lr.id = :id order by lr.id asc";
    String deleteLeaveRequest = "delete from leave_request where id = :id";

}
