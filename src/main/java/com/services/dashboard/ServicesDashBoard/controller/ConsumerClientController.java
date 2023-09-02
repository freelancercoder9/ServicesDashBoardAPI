package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import com.services.dashboard.ServicesDashBoard.model.ConsumerClientApiDetails;
import com.services.dashboard.ServicesDashBoard.model.ConsumerDetails;
import com.services.dashboard.ServicesDashBoard.services.ApiService;
import com.services.dashboard.ServicesDashBoard.services.ConsumerClientService;
import com.services.dashboard.ServicesDashBoard.services.ConsumerDetailsService;
import com.services.dashboard.ServicesDashBoard.util.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/ConsumerClient")
@RestController
@CrossOrigin
@Slf4j
public class ConsumerClientController {

    @Autowired
    ConsumerClientService consumerClientService;

    @Autowired
    ApiService apiService;

    @Autowired
    ConsumerDetailsService consumerDetailsService;


    @GetMapping("/getAllClientAPiDetails")
    public List<ConsumerClientApiDetails> getAllConsumerClientApiList() {
        List<ConsumerClientApiDetails> allApisForAllConsumers = consumerClientService.getAllApisForAllConsumers();
        return allApisForAllConsumers;
    }

    @PostMapping("{consumerId}/{apiId}/createConsumerClientAPi")
    public ResponseEntity createConsumerClientApiDetails(@PathVariable Long consumerId, @PathVariable Long apiId, @RequestBody ConsumerClientApiDetails consumerClientApiDetails) throws ErrorDetails {

        Optional<ConsumerDetails> byConsumerID = consumerDetailsService.findByConsumerID(consumerId);
        if (byConsumerID.isPresent()) {
            System.out.println("Consumer Details : " + byConsumerID.get());
            Optional<ApiDetails> apiDetailsById = apiService.getApiDetailsById(apiId);
            if (apiDetailsById.isPresent()) {
                System.out.println("APi Details Details : " + apiDetailsById.get());
                consumerClientApiDetails.setConsumerDetails(byConsumerID.get());
                consumerClientApiDetails.setApiDetails(apiDetailsById.get());

                if (consumerClientApiDetails.getId() == null) {
                    List<ConsumerClientApiDetails> consumerClientApiDetailsExisting = consumerClientService.validateExistingClientAPIMapping(consumerClientApiDetails.getClientId(), apiId, consumerId);
                    if (consumerClientApiDetailsExisting != null && consumerClientApiDetailsExisting.size() > 0) {
                        System.out.println("Already exists " + consumerClientApiDetailsExisting);
                        //throw new ErrorDetails("API_CLIENT_MAPPING_100", "Already Mapping existing for given client Id and  API service", HttpStatus.INTERNAL_SERVER_ERROR);
                        return new ResponseEntity(new ErrorDetails("API_CLIENT_MAPPING_100", "Already Mapping existing for given client Id and  API service"), HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }
                ConsumerClientApiDetails consumerClientApiDetailsReturn = consumerClientService.saveConsumerClientApiDetails(consumerClientApiDetails);
                return new ResponseEntity(consumerClientApiDetailsReturn, HttpStatus.OK);
            } else {
                return new ResponseEntity(new ErrorDetails("API_CLIENT_MAPPING_101", "Please provide valid API name"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(new ErrorDetails("API_CLIENT_MAPPING_102", "Please provide valid APP Code"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteConsumerClientDetails/{consumerClientId}")
    public ResponseEntity deleteConsumerClientId(@PathVariable Long consumerClientId) {
        log.info("deleteConsumerClientId Request is : {}", consumerClientId);
        consumerClientService.deleteConsumerClientDetails(consumerClientId);

        return new ResponseEntity("API Deleted SuccessFully", HttpStatus.OK);
    }
}
