package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.ConsumerDetails;

import java.util.List;
import java.util.Optional;

public interface ConsumerDetailsService {
    Optional<ConsumerDetails> findByConsumerID(Long consumerDetailsID);

    List<ConsumerDetails> getAllConsumerList();

    ConsumerDetails save(ConsumerDetails consumerDetails);

    void deleteConsumerDetails(Long consumerId);
}
