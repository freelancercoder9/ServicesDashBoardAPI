package com.services.dashboard.ServicesDashBoard.controller;

import com.services.dashboard.ServicesDashBoard.model.TeamMember;
import com.services.dashboard.ServicesDashBoard.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/members")
@RestController
@CrossOrigin
public class TeamMemberController {

    @Autowired
    TeamMemberService teamMemberService;

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
}
