package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;

import java.util.List;
import java.util.Optional;

public interface ApiService {

    Long save(ApiDetails apiDetails);

    List<ApiDetails> getAllApiDetails();

    Optional<ApiDetails> getApiDetailsById(Long apiId);

    List<ApiDetails> getAllApiDetailsWithTps();
}
