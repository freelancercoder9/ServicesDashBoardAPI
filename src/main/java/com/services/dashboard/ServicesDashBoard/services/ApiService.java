package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;

import java.util.List;
import java.util.Optional;

public interface ApiService {

    ApiDetails save(ApiDetails apiDetails);

    List<ApiDetails> getAllApiDetails();

    Optional<ApiDetails> getApiDetailsById(Long apiId);

    List<ApiDetails> getAllApiDetailsWithTps();

    void deleteAPiDetails(Long apiId);

    List<ApiDetails> getAllApiDetailsWithAppInstanceId(Long appInstanceId);

    List<ApiDetails> getAllApiDetailsWithTeamMemberId(Long teamMemberId);
}
