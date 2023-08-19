package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import com.services.dashboard.ServicesDashBoard.repository.ApiDetailsRepository;
import com.services.dashboard.ServicesDashBoard.util.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiDetailsRepository apiDetailsRepository;

    @Override
    public Long save(ApiDetails apiDetails) {
        try {
            ApiDetails savedData = apiDetailsRepository.saveAndFlush(apiDetails);
            return savedData.getId();
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
        return allApiDetailsWithTpsValue;
    }


}
