package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.AppInstanceDetails;

import java.util.List;
import java.util.Optional;

public interface AppInstanceService {


    Optional<AppInstanceDetails> findByAppInstanceID(Long apiInstanceId);

    List<AppInstanceDetails> findAllAppInstances();
}
