package com.ippikioukami.acftbackend.Controller;

import com.ippikioukami.acftbackend.Model.ServiceMember;
import com.ippikioukami.acftbackend.Repositories.SMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@CrossOrigin
@RequestMapping(path = "/SMs")
public class SMController {
    @Autowired
    private SMRepository smrepo;

    @PostMapping(path = "/addSMs")
    public @ResponseBody String[][] addNewSMs(
            @RequestParam String SMs,
            @RequestParam int len
    ){
        String[] arr = SMs.split(":");
        String[][] personnel = new String [len][1];
        for(int i = 0; i < len; i++){
            personnel[i] = arr[i].split(",");
            System.out.println(personnel[i]);
        }
        String[][] errors = new String[len][1];
        for(String[] member : personnel) {
            System.out.println(member);
            ServiceMember createSM = new ServiceMember();
            try{
                createSM.setDoD_ID(Integer.parseInt(member[0]));
                createSM.setPlatoon(Integer.parseInt(member[1]));
                createSM.setNoTests(Integer.parseInt(member[2]));
            }catch (NumberFormatException e){
                errors[--len] = member;
                continue;
            }
            createSM.setDoA(member[3]);
            createSM.setDoB(member[4]);
            createSM.setFirstName(member[5]);
            createSM.setLastName(member[6]);
            createSM.setGender(member[7]);
            createSM.setMOS(member[8]);
            smrepo.save(createSM);
        }
        return errors;
    }

    @GetMapping(path = "/getAllSMs")
    public @ResponseBody ArrayList<ServiceMember> getAllSMs(){
        return (ArrayList<ServiceMember>) smrepo.findAll();
    }

    @GetMapping(path = "/getPlatoonSMs")
    public @ResponseBody ArrayList<ServiceMember> getPlatoonSMs(
            @RequestParam int platoon
    ){
        ArrayList<ServiceMember> members = (ArrayList<ServiceMember>) smrepo.findAll();
        ArrayList<ServiceMember> PMembers = new ArrayList<ServiceMember>();
        for(ServiceMember candidate : members){
            if(candidate.getPlatoon() == platoon){
                PMembers.add(candidate);
            }
        }
        return PMembers;
    }
}
