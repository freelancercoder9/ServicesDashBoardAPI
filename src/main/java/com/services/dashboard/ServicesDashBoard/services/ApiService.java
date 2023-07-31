package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;

import java.util.List;

public interface ApiService {

    String save(ApiDetails apiDetails);
    List<ApiDetails> getAllApiDetails();
}
