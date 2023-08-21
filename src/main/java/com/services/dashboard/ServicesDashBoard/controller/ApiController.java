package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import com.services.dashboard.ServicesDashBoard.model.AppInstanceDetails;
import com.services.dashboard.ServicesDashBoard.model.TeamMember;
import com.services.dashboard.ServicesDashBoard.services.ApiService;
import com.services.dashboard.ServicesDashBoard.services.AppInstanceService;
import com.services.dashboard.ServicesDashBoard.services.TeamMemberService;
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

    @Autowired
    private TeamMemberService teamMemberService;

    @PostMapping("/{apiInstanceId}/{memberId}/createApi")
    public Long createApiDetails(@PathVariable(value = "apiInstanceId") Long apiInstanceId, @PathVariable(value = "memberId") Long memberId, @RequestBody ApiDetails apiDetails) throws Exception {
        System.out.println("Data is " + apiInstanceId + apiDetails);
        Optional<AppInstanceDetails> byAppInstanceID = appInstanceService.findByAppInstanceID(apiInstanceId);
        if (byAppInstanceID.isPresent()) {
            Optional<TeamMember> teamMemberById = teamMemberService.findTeamMemberById(memberId);
            if (teamMemberById.isPresent()) {
                apiDetails.setAppInstanceDetails(byAppInstanceID.get());
                apiDetails.setDeveloperDetails(teamMemberById.get());
                Long apiId = apiService.save(apiDetails);
                System.out.println("value is " + apiId);
                return apiId;
            } else {
                throw new Exception("Team Member not found");
            }

        } else {
            throw new Exception("APP Instance details not found");

        }
    }

    @GetMapping("/getAllApiDetails")
    public List<ApiDetails> getAllApiDetailsList() {
        return apiService.getAllApiDetails();
    }


    @GetMapping("/getAllApiDetailsList")
    public List<ApiDetails> getAllApiDetailsWithTps() {
        return apiService.getAllApiDetailsWithTps();
    }
}
