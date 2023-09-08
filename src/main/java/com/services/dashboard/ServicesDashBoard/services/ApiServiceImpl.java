package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import com.services.dashboard.ServicesDashBoard.repository.ApiDetailsRepository;
import com.services.dashboard.ServicesDashBoard.util.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiDetailsRepository apiDetailsRepository;

    @Override
    public ApiDetails save(ApiDetails apiDetails) {
        try {
            ApiDetails savedData = apiDetailsRepository.saveAndFlush(apiDetails);
            return savedData;
        } catch (Exception e) {
            throw new ErrorDetails("API_SERVICE_ERROR_100", "Failed to save Api details");
        }
    }

    @Override
    public List<ApiDetails> getAllApiDetails() {
        return (List<ApiDetails>) apiDetailsRepository.findAll();
    }

    @Override
    public Optional<ApiDetails> getApiDetailsById(Long apiId) {
        Optional<ApiDetails> byId = apiDetailsRepository.findById(apiId);
        return byId;
    }

    @Override
    public List<ApiDetails> getAllApiDetailsWithTps() {
        List<ApiDetails> allApiDetailsWithTpsValue = apiDetailsRepository.getAllApiDetailsWithTpsValue();
        log.info("allApiDetailsWithTpsValue {}", allApiDetailsWithTpsValue);
        return allApiDetailsWithTpsValue;
    }

    @Override
    public void deleteAPiDetails(Long apiId) {
        apiDetailsRepository.deleteById(apiId);
    }

    @Override
    public List<ApiDetails> getAllApiDetailsWithAppInstanceId(Long appInstanceId) {
        return apiDetailsRepository.getAllApiDetailsWithInstanceId(appInstanceId);
    }

    @Override
    public List<ApiDetails> getAllApiDetailsWithTeamMemberId(Long teamMemberId) {
        return apiDetailsRepository.getAllApiDetailsWithTeamMemberId(teamMemberId);
    }
}
