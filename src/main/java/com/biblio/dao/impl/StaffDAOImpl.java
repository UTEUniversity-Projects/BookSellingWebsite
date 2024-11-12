package com.biblio.dao.impl;

import com.biblio.dao.IStaffDAO;
import com.biblio.entity.Staff;

import java.util.List;

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
        return super.findById(id);
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
