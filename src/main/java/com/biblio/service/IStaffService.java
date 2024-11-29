package com.biblio.service;

import com.biblio.dto.request.StaffRequest;
import com.biblio.dto.response.NotificationGetResponse;
import com.biblio.dto.response.StaffResponse;

import java.util.List;

public interface IStaffService {
    List<StaffResponse> findAll();
    StaffResponse findById(Long id);
    void addStaff(StaffRequest staffRequest);
    void updateStaff(StaffRequest staffRequest);
    void deleteStaff(Long id);
    void activateStaff(Long id);
    void deactivateStaff(Long id);

    List<NotificationGetResponse> getAllNotificationByStaffId(Long id);
}
