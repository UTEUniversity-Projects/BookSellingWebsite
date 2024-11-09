package com.biblio.service;

import com.biblio.dto.response.PromotionGetResponse;

import java.util.List;

public interface IPromotionService {
    List<PromotionGetResponse> findAll();
}
