package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import com.services.dashboard.ServicesDashBoard.model.AppInstanceDetails;
import com.services.dashboard.ServicesDashBoard.model.ConsumerClientApiDetails;
import com.services.dashboard.ServicesDashBoard.model.TeamMember;
import com.services.dashboard.ServicesDashBoard.services.ApiService;
import com.services.dashboard.ServicesDashBoard.services.AppInstanceService;
import com.services.dashboard.ServicesDashBoard.services.ConsumerClientService;
import com.services.dashboard.ServicesDashBoard.services.TeamMemberService;
import com.services.dashboard.ServicesDashBoard.util.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/apiDetails")
@RestController
@CrossOrigin
@Slf4j
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private AppInstanceService appInstanceService;

    @Autowired
    private TeamMemberService teamMemberService;

    @Autowired
    private ConsumerClientService consumerClientService;

    @PostMapping("/{apiInstanceId}/{memberId}/createApi")
    public ResponseEntity createApiDetails(@PathVariable(value = "apiInstanceId") Long apiInstanceId, @PathVariable(value = "memberId") Long memberId, @RequestBody ApiDetails apiDetails) throws Exception {

        log.info("createApiDetails...", apiInstanceId, apiDetails);

        Optional<AppInstanceDetails> byAppInstanceID = appInstanceService.findByAppInstanceID(apiInstanceId);
        if (byAppInstanceID.isPresent()) {
            Optional<TeamMember> teamMemberById = teamMemberService.findTeamMemberById(memberId);
            if (teamMemberById.isPresent()) {
                apiDetails.setAppInstanceDetails(byAppInstanceID.get());
                apiDetails.setDeveloperDetails(teamMemberById.get());
                ApiDetails save = apiService.save(apiDetails);
                return new ResponseEntity(save, HttpStatus.OK);
            } else {
                return new ResponseEntity(new ErrorDetails("API_SERVICE_ERROR", "Please select valid member"), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(new ErrorDetails("API_SERVICE_ERROR", "Please select valid app instance"), HttpStatus.BAD_REQUEST);
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

    @DeleteMapping("/deleteApiDetails/{apiId}")
    public ResponseEntity deleteApiDetails(@PathVariable Long apiId) {
        List<ConsumerClientApiDetails> allConsumerClientDetailsWithApiID = consumerClientService.getAllConsumerClientDetailsWithApiID(apiId);
        if (allConsumerClientDetailsWithApiID != null && allConsumerClientDetailsWithApiID.size() > 0) {
            return new ResponseEntity(new ErrorDetails("API_SERVICE_ERROR", "Cannot Delete api, there are consumers for this api"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        apiService.deleteAPiDetails(apiId);

        return new ResponseEntity("API Deleted SuccessFully", HttpStatus.OK);
    }

    @GetMapping("/getAllApiDetails/appInstanceId/{appNameId}")
    public ResponseEntity getApiDetailsWithAppId(@PathVariable Long appNameId) {
        try {
            List<ApiDetails> allApiDetailsWithAppInstanceId = apiService.getAllApiDetailsWithAppInstanceId(appNameId);
            return new ResponseEntity(allApiDetailsWithAppInstanceId, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception in getApiDetailsWithAppName ", e.getMessage());
        }
        return new ResponseEntity(new ErrorDetails("API_SERVICE_ERROR", "Cannot get api Details with app Id"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getAllApiDetails/developerId/{developerId}")
    public ResponseEntity getApiDetailsWithDeveloperId(@PathVariable Long developerId) {

        try {
            List<ApiDetails> allApiDetailsWithTeamMemberId = apiService.getAllApiDetailsWithTeamMemberId(developerId);
            return new ResponseEntity(allApiDetailsWithTeamMemberId, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception in getApiDetailsWithDeveloperId ", e.getMessage());

        }
        return new ResponseEntity(new ErrorDetails("API_SERVICE_ERROR", "Cannot get api Details with developer Id"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
