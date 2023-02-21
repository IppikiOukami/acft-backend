package com.ippikioukami.acftbackend.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class ServiceMember {
    @Id
    private int DoD_ID;
    private int NoTests;
    private int platoon;
    private String DoA;
    private String DoB;
    private String FirstName;
    private String Gender;
    private String LastName;
    private String MOS;
}
