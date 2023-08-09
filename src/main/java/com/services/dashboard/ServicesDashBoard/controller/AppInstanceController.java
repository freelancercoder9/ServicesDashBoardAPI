package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.AppInstanceDetails;
import com.services.dashboard.ServicesDashBoard.services.AppInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/appInstanceDetails")
@RestController
public class AppInstanceController {

    @Autowired
    AppInstanceService appInstanceService;

    @GetMapping("/getAllAppNames")
    public List<AppInstanceDetails> getAppInstanceDetails(){
        return appInstanceService.findAllAppInstances();
    }
}
