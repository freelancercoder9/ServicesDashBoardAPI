package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import com.services.dashboard.ServicesDashBoard.repository.ApiDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService{

    @Autowired
    private ApiDetailsRepository apiDetailsRepository;

    @Override
    public Long save(ApiDetails apiDetails) {
        ApiDetails savedData = apiDetailsRepository.saveAndFlush(apiDetails);
        return savedData.getId();
    }

    @Override
    public List<ApiDetails> getAllApiDetails() {
        return (List<ApiDetails>) apiDetailsRepository.findAll();
    }


}
