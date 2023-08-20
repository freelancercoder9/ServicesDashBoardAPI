package com.services.dashboard.ServicesDashBoard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TEAM_MEMBERS")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "MEMBER_NAME", unique = true)
    private String memberName;
    private LocationName locationName;
    private String contactNumber;
}
