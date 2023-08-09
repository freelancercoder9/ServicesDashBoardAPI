package com.services.dashboard.ServicesDashBoard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "APP_INSTANCE_DETAILS")
@NoArgsConstructor
@Getter
@Setter
public class AppInstanceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "APP_INSTANCE_NAME", unique = true)
    private String appInstanceName;
    private String appInstanceType;
    private String uatDeployedEnv;
    private Date lastUatDeployedDate;
    private String prodDeployedEnv;
    private Date lastProdDeployedDate;



}
