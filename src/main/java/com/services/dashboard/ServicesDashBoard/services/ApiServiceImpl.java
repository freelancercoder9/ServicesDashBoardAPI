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
    public String save(ApiDetails apiDetails) {
        System.out.println("Details : "+apiDetails.toString());
        ApiDetails apiDetailsOutput = apiDetailsRepository.save(apiDetails);
        return apiDetailsOutput.getApiID();
    }

    @Override
    public List<ApiDetails> getAllApiDetails() {

        return apiDetailsRepository.findAll();

    }
}
