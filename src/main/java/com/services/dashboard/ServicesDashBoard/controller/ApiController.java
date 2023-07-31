package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import com.services.dashboard.ServicesDashBoard.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/apiDetails")
@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping("/createApi")
    public String createApiDetails( @RequestBody ApiDetails apiDetails){
        String apiId = apiService.save(apiDetails);
        return apiId;
    }

    @GetMapping("/getAllApiDetails")
    public List<ApiDetails> getAllApiDetailsList(){
        return apiService.getAllApiDetails();
    }
}
