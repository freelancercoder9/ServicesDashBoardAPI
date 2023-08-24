package com.services.dashboard.ServicesDashBoard.repository;

import com.services.dashboard.ServicesDashBoard.model.ConsumerClientApiDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsumerClientRepository extends JpaRepository<ConsumerClientApiDetails, Long> {

    @Query(value = "select * from consumer_client_api_details where client_id =?1 and api_name_id =?2 and consumer_details_id =?3", nativeQuery = true)
    List<ConsumerClientApiDetails> findExistingClientAPiDetails(String clientId, Long apiId, Long consumerId);

    @Query(value = "select  * from consumer_client_api_details ccad  where ccad.api_name_id = ?", nativeQuery = true)
    List<ConsumerClientApiDetails> findAllConsumerClientDetailsWithApiId(Long apiId);

    @Query(value = "select  * from consumer_client_api_details ccad  where  ccad.consumer_details_id = ?1", nativeQuery = true)
    List<ConsumerClientApiDetails> findAllConsumerClientDetailsWithConsumerID(Long consumerId);

}
