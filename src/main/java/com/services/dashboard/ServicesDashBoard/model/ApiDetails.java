package com.services.dashboard.ServicesDashBoard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "API_DETAILS")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApiDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "API_NAME", nullable = false, unique = true)
    private String apiName;
    @ManyToOne()
    @JoinColumn(name = "APP_INSTANCE_ID", referencedColumnName = "id", nullable = false)
    private AppInstanceDetails appInstanceDetails;
    private String apiRequestType;
    private Long totalTps;
    @ManyToOne()
    @JoinColumn(name = "DEVELOPER_NAME", referencedColumnName = "id", nullable = false)
    private TeamMember developerName;
    private Status devStatus;
    private Date devStatusDate;
    private Status uatStatus;
    private Date uatStatusDate;
    private Status prodStatus;
    private Date prodStatusDate;
}
