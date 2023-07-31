package com.services.dashboard.ServicesDashBoard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "API_DETAILS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiDetails {

    @Id
    private String apiID;
    private String apiName;
    private String apiRequestType;
    private Long totalTps;
    private ApiStatus uatStatus;
    private ApiStatus prodStatus;
}
