package com.services.dashboard.ServicesDashBoard.repository;


import com.services.dashboard.ServicesDashBoard.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
}
