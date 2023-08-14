package com.services.dashboard.ServicesDashBoard.repository;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ApiDetailsRepository extends JpaRepository<ApiDetails, Long> {

}
