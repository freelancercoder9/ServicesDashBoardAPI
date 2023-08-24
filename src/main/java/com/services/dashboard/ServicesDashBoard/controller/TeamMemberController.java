package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import com.services.dashboard.ServicesDashBoard.model.TeamMember;
import com.services.dashboard.ServicesDashBoard.services.ApiService;
import com.services.dashboard.ServicesDashBoard.services.TeamMemberService;
import com.services.dashboard.ServicesDashBoard.util.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/members")
@RestController
@CrossOrigin
public class TeamMemberController {

    @Autowired
    TeamMemberService teamMemberService;

    @Autowired
    ApiService apiService;

    @PostMapping("createUpdateMember")
    public TeamMember createUpdateTeamMember(@RequestBody TeamMember teamMember) {
        System.out.println("Request Data  : " + teamMember);
        TeamMember updateTeamMember = teamMemberService.createUpdateTeamMember(teamMember);
        System.out.println("Return Data  : " + updateTeamMember);
        return updateTeamMember;
    }

    @GetMapping("/getAllMembers")
    public List<TeamMember> getAllTeamMembers() {
        List<TeamMember> allTeamMembers = teamMemberService.getAllTeamMembers();
        return allTeamMembers;
    }

    @DeleteMapping("/deleteMemBerDetails/{memberId}")
    public ResponseEntity deleteMemberDetails(@PathVariable Long memberId) {
        List<ApiDetails> allApiDetailsWithTeamMemberId = apiService.getAllApiDetailsWithTeamMemberId(memberId);
        if (allApiDetailsWithTeamMemberId != null && allApiDetailsWithTeamMemberId.size() > 0) {
            return new ResponseEntity(new ErrorDetails("TEAM_MEMBER_ERROR", "Cannot delete member, please check api"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        teamMemberService.deleteMemberDetails(memberId);
        return new ResponseEntity("Team member deleted SuccessFully", HttpStatus.OK);
    }
}
