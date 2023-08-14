package com.services.dashboard.ServicesDashBoard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "CONSUMER_DETAILS")
@NoArgsConstructor
@Getter
@Setter
public class ConsumerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "APP_CODE", unique = true)
    private String appCode;
    private String primaryOwner;
    private String secondaryOwner;
}
