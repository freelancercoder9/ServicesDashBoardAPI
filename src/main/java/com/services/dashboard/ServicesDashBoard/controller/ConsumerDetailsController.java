package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.ConsumerDetails;
import com.services.dashboard.ServicesDashBoard.services.ConsumerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/consumerDetails")
@RestController
@CrossOrigin
public class ConsumerDetailsController {

    @Autowired
    ConsumerDetailsService consumerDetailsService;

    @GetMapping("/getAllConsumers")
    public List<ConsumerDetails> getAllApiDetailsList() {
        return consumerDetailsService.getAllConsumerList();
    }

    @PostMapping("/createConsumerDetails")
    public ConsumerDetails createConsumer(@RequestBody ConsumerDetails consumerDetails) {
        ConsumerDetails save = consumerDetailsService.save(consumerDetails);
        return save;
    }

}
