package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import com.services.dashboard.ServicesDashBoard.model.AppInstanceDetails;
import com.services.dashboard.ServicesDashBoard.services.ApiService;
import com.services.dashboard.ServicesDashBoard.services.AppInstanceService;
import com.services.dashboard.ServicesDashBoard.util.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/appInstanceDetails")
@RestController
@CrossOrigin
@Slf4j
public class AppInstanceController {

    @Autowired
    AppInstanceService appInstanceService;

    @Autowired
    ApiService apiService;

    @GetMapping("/getAllAppNames")
    public List<AppInstanceDetails> getAppInstanceDetails() {
        return appInstanceService.findAllAppInstances();
    }

    @PostMapping("/createAppInstance")
    public AppInstanceDetails createAppInstance(@RequestBody AppInstanceDetails appInstanceDetails) {
        return appInstanceService.createAppInstance(appInstanceDetails);
    }

    @DeleteMapping("/deleteAppInstanceDetails/{appInstanceId}")
    public ResponseEntity deleteAppInstanceId(@PathVariable Long appInstanceId) {
        List<ApiDetails> allApiDetailsWithAppInstanceId = apiService.getAllApiDetailsWithAppInstanceId(appInstanceId);
        log.info(" allApiDetailsWithAppInstanceId {}", allApiDetailsWithAppInstanceId);
        if (allApiDetailsWithAppInstanceId != null && allApiDetailsWithAppInstanceId.size() > 0) {

            return new ResponseEntity(new ErrorDetails("APP_INSTANCE_ERROR_101", "Cannot Delete app, please delete all apis before deleting app"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        appInstanceService.deleteAppInstanceDetails(appInstanceId);
        return new ResponseEntity("Deleted SuccessFully", HttpStatus.OK);
    }
}
