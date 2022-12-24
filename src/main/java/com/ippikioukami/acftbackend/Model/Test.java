package com.ippikioukami.acftbackend.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Test {
    @Id
    @GeneratedValue
    private int TestNo;
    private int DoD_ID;

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
}
