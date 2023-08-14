package com.services.dashboard.ServicesDashBoard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "CONSUMER_CLIENT_API_DETAILS")
@NoArgsConstructor
@Getter
@Setter
public class ConsumerClientApiDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APP_CODE", referencedColumnName = "APP_CODE", nullable = false)
    private ConsumerDetails consumerDetails;
    private String clientId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_NAME", referencedColumnName = "API_NAME", nullable = false)
    private ApiDetails apiName;
    private String contactName;
    private String uatStatus;
    private Date uatStatusDate;
    private String prodStatus;
    private String prodStatusDate;
    private Long tpsValue;
}
