package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import com.services.dashboard.ServicesDashBoard.model.AppInstanceDetails;
import com.services.dashboard.ServicesDashBoard.services.ApiService;
import com.services.dashboard.ServicesDashBoard.services.AppInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/apiDetails")
@RestController
@CrossOrigin

public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private AppInstanceService appInstanceService;

    @PostMapping("/{apiInstanceId}/createApi")
    public Long createApiDetails(@PathVariable(value = "apiInstanceId") Long apiInstanceId, @RequestBody ApiDetails apiDetails) throws Exception {
        System.out.println("Data is " + apiInstanceId + apiDetails);
        Optional<AppInstanceDetails> byAppInstanceID = appInstanceService.findByAppInstanceID(apiInstanceId);
        if (byAppInstanceID.isPresent()) {
            apiDetails.setAppInstanceDetails(byAppInstanceID.get());
            Long apiId = apiService.save(apiDetails);
            System.out.println("value is " + apiId);
            return apiId;
        } else {
            throw new Exception("APP Instance details not found");

        }
    }

    @GetMapping("/getAllApiDetails")
    public List<ApiDetails> getAllApiDetailsList() {
        return apiService.getAllApiDetails();
    }
}
