package com.ippikioukami.acftbackend.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Test {
    @Id
    @GeneratedValue
    private int TestNo;
    private int DoD_ID;

    //Age of SM at time of test
    private int Age;

    //Test number for given service member
    private int SMTestNo;

    //3 repetition maximum deadlift
    private int rawMDL;

    //Standing power throw
    private int rawSPT;

    //Hand release push up arm extension
    private int rawHRP;

    //Sprint drag carry
    private int rawSDC;

    //Plank
    private int rawPLK;

    //2 mile run
    private int raw2MR;

    //Date when test was taken
    private String DoT;
}
