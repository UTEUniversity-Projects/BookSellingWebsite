package com.biblio.service;

import com.biblio.dto.request.SupportRequest;
import com.biblio.entity.Support;

import java.sql.SQLException;
import java.util.List;

public interface ISupportService {
    List<Support> getAllSupportRequests();
    Support getSupportRequestById(long id);
    void respondToSupportRequest(SupportRequest request) throws SQLException;
}
