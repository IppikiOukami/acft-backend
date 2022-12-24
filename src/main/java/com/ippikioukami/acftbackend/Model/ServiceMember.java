package com.ippikioukami.acftbackend.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Setter
@Getter
@Entity
public class ServiceMember {
    @Id
    private int DoD_ID;
    private int Age;
    private int NoTests;
    private String DoA;
    private String DoB;
    private String FirstName;
    private String LastName;
    private String MOS;
}
