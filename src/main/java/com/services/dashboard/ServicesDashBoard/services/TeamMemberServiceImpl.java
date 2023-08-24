package com.services.dashboard.ServicesDashBoard.services;

import com.services.dashboard.ServicesDashBoard.model.TeamMember;
import com.services.dashboard.ServicesDashBoard.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    @Autowired
    TeamMemberRepository teamMemberRepository;

    @Override
    public TeamMember createUpdateTeamMember(TeamMember teamMember) {
        TeamMember teamMemberReturn = teamMemberRepository.save(teamMember);
        return teamMemberReturn;
    }

    @Override
    public Optional<TeamMember> findTeamMemberById(Long teamMemberId) {
        Optional<TeamMember> byId = teamMemberRepository.findById(teamMemberId);
        return byId;
    }

    @Override
    public List<TeamMember> getAllTeamMembers() {
        List<TeamMember> all = teamMemberRepository.findAll();
        return all;
    }

    @Override
    public void deleteMemberDetails(Long memberId) {
        teamMemberRepository.deleteById(memberId);
    }
}
