package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.AppInstanceDetails;
import com.services.dashboard.ServicesDashBoard.services.AppInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.List;

@RequestMapping("/appInstanceDetails")
@RestController
@CrossOrigin

public class AppInstanceController {

    @Autowired
    AppInstanceService appInstanceService;

    @GetMapping("/getAllAppNames")
    public List<AppInstanceDetails> getAppInstanceDetails(){
        return appInstanceService.findAllAppInstances();
    }

    @PostMapping("/createAppInstance")
    public AppInstanceDetails createAppInstance( @RequestBody AppInstanceDetails appInstanceDetails){
            return appInstanceService.createAppInstance(appInstanceDetails);
    }
}
