package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.AppInstanceDetails;
import com.services.dashboard.ServicesDashBoard.repository.AppInstanceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppInstanceServiceImpl implements  AppInstanceService{


    @Autowired
    AppInstanceDetailsRepository appInstanceDetailsRepository;
    @Override
    public Optional<AppInstanceDetails> findByAppInstanceID(Long apiInstanceId) {
        return appInstanceDetailsRepository.findById(apiInstanceId);
    }

    @Override
    public List<AppInstanceDetails> findAllAppInstances() {
        List<AppInstanceDetails> allAppNames = appInstanceDetailsRepository.findAll();
        return allAppNames;
    }
}
