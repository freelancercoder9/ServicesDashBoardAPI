package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.ConsumerClientApiDetails;
import com.services.dashboard.ServicesDashBoard.repository.ConsumerClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerClientServiceImpl implements ConsumerClientService {

    @Autowired
    ConsumerClientRepository consumerClientRepository;

    @Override
    public List<ConsumerClientApiDetails> getAllApisForAllConsumers() {
        List<ConsumerClientApiDetails> all = consumerClientRepository.findAll();
        return all;
    }

    @Override
    public ConsumerClientApiDetails saveConsumerClientApiDetails(ConsumerClientApiDetails consumerClientApiDetails) {
        ConsumerClientApiDetails saveData = consumerClientRepository.save(consumerClientApiDetails);
        return saveData;
    }

    @Override
    public List<ConsumerClientApiDetails> validateExistingClientAPIMapping(String clientId, Long apiID, Long consumerId) {
        List<ConsumerClientApiDetails> existingClientAPiDetails = consumerClientRepository.findExistingClientAPiDetails(clientId, apiID, consumerId);
        return existingClientAPiDetails;
    }

    @Override
    public void deleteConsumerClientDetails(Long consumerClientId) {
        consumerClientRepository.deleteById(consumerClientId);
    }

    @Override
    public List<ConsumerClientApiDetails> getAllConsumerClientDetailsWithApiID(Long apiId) {
        List<ConsumerClientApiDetails> allConsumerClientDetailsWithApiId = consumerClientRepository.findAllConsumerClientDetailsWithApiId(apiId);
        return allConsumerClientDetailsWithApiId;
    }

    @Override
    public List<ConsumerClientApiDetails> getAllConsumerClientDetailsWithConsumerID(Long consumerId) {
        List<ConsumerClientApiDetails> allConsumerClientDetailsWithConsumerID = consumerClientRepository.findAllConsumerClientDetailsWithConsumerID(consumerId);
        return allConsumerClientDetailsWithConsumerID;
    }
}
