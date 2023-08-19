package com.services.dashboard.ServicesDashBoard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "CONSUMER_CLIENT_API_DETAILS")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ConsumerClientApiDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CONSUMER_DETAILS_ID", referencedColumnName = "id", nullable = false)
    private ConsumerDetails consumerDetails;
    private String clientId;
    @ManyToOne
    @JoinColumn(name = "API_NAME_ID", referencedColumnName = "id", nullable = false)
    private ApiDetails apiDetails;
    private String contactName;
    private String uatStatus;
    private Date uatStatusDate;
    private String prodStatus;
    private Date prodStatusDate;
    private Long tpsValue;
}
