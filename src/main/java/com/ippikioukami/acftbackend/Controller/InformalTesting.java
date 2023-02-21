package com.ippikioukami.acftbackend.Controller;

public class InformalTesting {

    public void main(String[] args){
        SMController testSM = new SMController();
        String SMString = "" +
                "[[1542772348,1,0,20230220,19950908,Mario,Macias,M,25S]" +
                "[1542772349,2,0,20230220,20000724,Jazmin,Macias,F,25S]" +
                "[1542772350,3,0,20230220,20030507,Jesus,Macias,M,25S]]";
        System.out.println(testSM.addNewSMs(SMString));
    }
}
