package com.services.dashboard.ServicesDashBoard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;

import java.util.Date;



@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "API_DETAILS")
@NoArgsConstructor
@Getter
@Setter
public class ApiDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String apiName;
    @ManyToOne
    @JoinColumn(name = "APP_INSTANCE_NAME", referencedColumnName = "APP_INSTANCE_NAME", nullable = false )
    private AppInstanceDetails appInstanceDetails;
    private String apiRequestType;
    private Long totalTPS;
    private Status devStatus;
    private String developerName;
    private Date devCompletedDate;
    private Status uatStatus;
    private Date uatCompletedDate;
    private Status prodStatus;
    private Date prodCompletedDate;
}
