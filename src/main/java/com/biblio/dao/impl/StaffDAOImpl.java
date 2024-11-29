package com.biblio.dao.impl;

import com.biblio.dao.IStaffDAO;
import com.biblio.entity.Staff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffDAOImpl extends GenericDAOImpl<Staff> implements IStaffDAO {

    public StaffDAOImpl() {
        super(Staff.class);
    }

    @Override
    public List<Staff> findAll() {
        return super.findAll();
    }

    @Override
    public Staff findById(Long id) {
        String jpql = "SELECT s FROM Staff s LEFT JOIN FETCH s.notifications WHERE s.id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return super.findSingleByJPQL(jpql, params);
    }


    @Override
    public void addStaff(Staff staff) {
        super.save(staff);
    }

    @Override
    public void updateStaff(Staff staff) {
        super.update(staff);
    }

    @Override
    public void deleteStaff(Long id) {
        super.delete(id);
    }

    @Override
    public void activateStaff(Staff staff) {
        super.update(staff);
    }

    @Override
    public void deactivateStaff(Staff staff) {
        super.update(staff);
    }

    public static void main(String[] args){
        StaffDAOImpl dao = new StaffDAOImpl();
        List<Staff> list = dao.findAll();
        for (Staff staff : list){
            System.out.println(staff.getFullName());
        }
    }
}
