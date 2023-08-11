package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.ConsumerDetails;
import com.services.dashboard.ServicesDashBoard.repository.ConsumerDetailsRepository;
import com.services.dashboard.ServicesDashBoard.util.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerDetailsServiceImpl implements ConsumerDetailsService {

    @Autowired
    ConsumerDetailsRepository consumerDetailsRepository;

    @Override
    public Optional<ConsumerDetails> findByConsumerID(Long consumerDetailsID) {
        Optional<ConsumerDetails> byId = consumerDetailsRepository.findById(consumerDetailsID);
        if (byId.isEmpty()) {
            throw new ErrorDetails("API_CONSUMER_DETAILS_ERROR_100", "consumer details not found", HttpStatus.NOT_FOUND);
        } else {
            return byId;
        }
    }

    @Override
    public List<ConsumerDetails> getAllConsumerList() {
        return consumerDetailsRepository.findAll();
    }

    @Override
    public ConsumerDetails save(ConsumerDetails consumerDetails) {
        return consumerDetailsRepository.save(consumerDetails);
    }


}
