package com.services.dashboard.ServicesDashBoard.repository;

import com.services.dashboard.ServicesDashBoard.model.ConsumerClientApiDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerClientRepository extends JpaRepository<ConsumerClientApiDetails, Long> {
}
