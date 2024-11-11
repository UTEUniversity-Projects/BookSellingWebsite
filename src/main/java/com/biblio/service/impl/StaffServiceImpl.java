package com.biblio.service.impl;

import com.biblio.dao.IStaffDAO;
import com.biblio.dto.request.StaffRequest;
import com.biblio.dto.response.StaffResponse;
import com.biblio.entity.Staff;
import com.biblio.enumeration.EAccountStatus;
import com.biblio.mapper.StaffMapper;
import com.biblio.service.IStaffService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class StaffServiceImpl implements IStaffService {
    @Inject
    IStaffDAO staffDAO;

    @Override
    @Transactional
    public List<StaffResponse> findAll() {
        List<StaffResponse> list = new ArrayList<StaffResponse>();
        for (Staff staff : staffDAO.findAll()) {
            list.add(StaffMapper.toStaffResponse(staff));
        }
        return list;
    }

    @Override
    public StaffResponse findById(Long id) {
        return StaffMapper.toStaffResponse(staffDAO.findById(id));
    }

    @Override
    public void addStaff(StaffRequest staffRequest) {
        staffDAO.addStaff(StaffMapper.toStaffEntity(staffRequest));
    }

    @Override
    public void updateStaff(StaffRequest staffRequest) {

    }

    @Override
    public void deleteStaff(Long id) {

    }

    @Override
    public void activateStaff(Long id) {
        Staff staff = staffDAO.findById(id);
        staff.getAccount().setStatus(EAccountStatus.ACTIVE);
        staffDAO.activateStaff(staff);
    }

    @Override
    public void deactivateStaff(Long id) {
        Staff staff = staffDAO.findById(id);
        staff.getAccount().setStatus(EAccountStatus.INACTIVE);
        staffDAO.deactivateStaff(staff);
    }
}
