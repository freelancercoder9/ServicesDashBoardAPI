package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.ConsumerClientApiDetails;
import com.services.dashboard.ServicesDashBoard.model.ConsumerDetails;
import com.services.dashboard.ServicesDashBoard.services.ConsumerClientService;
import com.services.dashboard.ServicesDashBoard.services.ConsumerDetailsService;
import com.services.dashboard.ServicesDashBoard.util.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/consumerDetails")
@RestController
@CrossOrigin
public class ConsumerDetailsController {

    @Autowired
    ConsumerDetailsService consumerDetailsService;

    @Autowired
    ConsumerClientService consumerClientService;

    @GetMapping("/getAllConsumers")
    public List<ConsumerDetails> getAllApiDetailsList() {
        return consumerDetailsService.getAllConsumerList();
    }

    @PostMapping("/createConsumerDetails")
    public ConsumerDetails createConsumer(@RequestBody ConsumerDetails consumerDetails) {
        ConsumerDetails save = consumerDetailsService.save(consumerDetails);
        return save;
    }

    @DeleteMapping("/deleteConsumerDetails/{consumerId}")
    public ResponseEntity deleteConsumerDetails(@PathVariable Long consumerId) {
        List<ConsumerClientApiDetails> allConsumerClientDetailsWithConsumerID = consumerClientService.getAllConsumerClientDetailsWithConsumerID(consumerId);
        if (allConsumerClientDetailsWithConsumerID != null && allConsumerClientDetailsWithConsumerID.size() > 0) {
            return new ResponseEntity(new ErrorDetails("CONSUMER_DETAILS_ERROR", "Cannot Delete Consumer, please check consumer api mapping before deleting"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        consumerDetailsService.deleteConsumerDetails(consumerId);
        return new ResponseEntity("Consumer Deleted SuccessFully", HttpStatus.OK);
    }
}
