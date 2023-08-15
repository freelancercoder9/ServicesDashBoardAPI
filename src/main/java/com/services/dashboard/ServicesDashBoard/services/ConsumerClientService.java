package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.ConsumerClientApiDetails;

import java.util.List;

public interface ConsumerClientService {

    public List<ConsumerClientApiDetails> getAllApisForAllConsumers();

    ConsumerClientApiDetails saveConsumerClientApiDetails(ConsumerClientApiDetails consumerClientApiDetails);
}
