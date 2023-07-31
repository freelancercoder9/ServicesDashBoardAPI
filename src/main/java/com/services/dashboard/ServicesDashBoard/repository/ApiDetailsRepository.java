package com.services.dashboard.ServicesDashBoard.repository;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApiDetailsRepository extends MongoRepository<ApiDetails, String> {

}
