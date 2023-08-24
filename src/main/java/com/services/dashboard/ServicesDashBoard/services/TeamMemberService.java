package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.TeamMember;

import java.util.List;
import java.util.Optional;

public interface TeamMemberService {
    TeamMember createUpdateTeamMember(TeamMember teamMember);

    Optional<TeamMember> findTeamMemberById(Long teamMemberId);

    List<TeamMember> getAllTeamMembers();

    void deleteMemberDetails(Long memberId);
}
