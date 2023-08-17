package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.AppInstanceDetails;
import com.services.dashboard.ServicesDashBoard.repository.AppInstanceDetailsRepository;
import com.services.dashboard.ServicesDashBoard.util.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppInstanceServiceImpl implements AppInstanceService {


    @Autowired
    AppInstanceDetailsRepository appInstanceDetailsRepository;

    @Override
    public Optional<AppInstanceDetails> findByAppInstanceID(Long apiInstanceId) {
        Optional<AppInstanceDetails> byId = appInstanceDetailsRepository.findById(apiInstanceId);
        if (byId.isEmpty()) {
            throw new ErrorDetails("API_INSTANCE_ERROR_100", "App instance not found");
        }
        return appInstanceDetailsRepository.findById(apiInstanceId);
    }

    @Override
    public List<AppInstanceDetails> findAllAppInstances() {
        List<AppInstanceDetails> allAppNames = appInstanceDetailsRepository.findAll();
        return allAppNames;
    }

    @Override
    public AppInstanceDetails createAppInstance(AppInstanceDetails appInstanceDetails) {
        try {
            AppInstanceDetails save = appInstanceDetailsRepository.save(appInstanceDetails);
            return save;
        } catch (Exception e) {
            throw new ErrorDetails("API_INSTANCE_ERROR_200", "Failed to save App instance Details");
        }
    }
}
