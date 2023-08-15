package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import com.services.dashboard.ServicesDashBoard.model.ConsumerClientApiDetails;
import com.services.dashboard.ServicesDashBoard.model.ConsumerDetails;
import com.services.dashboard.ServicesDashBoard.services.ApiService;
import com.services.dashboard.ServicesDashBoard.services.ConsumerClientService;
import com.services.dashboard.ServicesDashBoard.services.ConsumerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/ConsumerClient")
@RestController
@CrossOrigin

public class ConsumerClientController {

    @Autowired
    ConsumerClientService consumerClientService;

    @Autowired
    ApiService apiService;

    @Autowired
    ConsumerDetailsService consumerDetailsService;


    @GetMapping("/allClientAPiDetails")
    public List<ConsumerClientApiDetails> getAllConsumerClientApiList() {
        List<ConsumerClientApiDetails> allApisForAllConsumers = consumerClientService.getAllApisForAllConsumers();
        return allApisForAllConsumers;
    }

    @PostMapping("{consumerId}/{apiId}/createConsumerClientAPi")
    public ConsumerClientApiDetails saveConsumerClientApiDetails(@PathVariable Long consumerId, @PathVariable Long apiId, @RequestBody ConsumerClientApiDetails consumerClientApiDetails) throws Exception {
        Optional<ConsumerDetails> byConsumerID = consumerDetailsService.findByConsumerID(consumerId);
        if (byConsumerID.isPresent()) {
            System.out.println("Consumer Details : " + byConsumerID.get());
            Optional<ApiDetails> apiDetailsById = apiService.getApiDetailsById(apiId);
            if (apiDetailsById.isPresent()) {
                System.out.println("APi Details Details : " + apiDetailsById.get());
                consumerClientApiDetails.setConsumerDetails(byConsumerID.get());
                consumerClientApiDetails.setApiDetails(apiDetailsById.get());
                consumerClientService.saveConsumerClientApiDetails(consumerClientApiDetails);
            } else {
                throw new Exception("Invalid Api Details");
            }
        } else {
            throw new Exception("Invalid AppCode Details");
        }

        return null;
    }
}
