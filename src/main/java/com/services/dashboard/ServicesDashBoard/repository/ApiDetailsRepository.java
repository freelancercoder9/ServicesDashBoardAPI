package com.services.dashboard.ServicesDashBoard.repository;

import com.services.dashboard.ServicesDashBoard.model.ApiDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApiDetailsRepository extends JpaRepository<ApiDetails, Long> {

    @Query(value = "select ad.id , ad.api_name ,ad.app_instance_id , ad.api_request_type ,ad.dev_status_date ,ad.dev_status ,ad.developer_details ,ad.prod_status_date ,ad.prod_status ,ad.uat_status_date ,ad.uat_status,\n" +
            "sum(ccad.tps_value)  as total_tps from api_details ad, consumer_client_api_details ccad  \n" +
            "where ad.id = ccad.api_name_id  group  by ad.id ", nativeQuery = true)
    List<ApiDetails> getAllApiDetailsWithTpsValue();
}
