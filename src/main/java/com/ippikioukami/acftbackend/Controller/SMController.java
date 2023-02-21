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
    public @ResponseBody String addNewSMs(
            @RequestParam String SMString
    ){
        SMString = SMString.substring(1, SMString.length()-1).replaceAll("\\[","");
        String[][] personnel = new String[][]{SMString.split("]")};
        ArrayList<String> errors = new ArrayList<String>();
        for(String member : personnel[0]) {
            ServiceMember createSM = new ServiceMember();
            String[] memberData = member.split(",");
            try{
                createSM.setDoD_ID(Integer.parseInt(memberData[0]));
                createSM.setPlatoon(Integer.parseInt(memberData[1]));
                createSM.setNoTests(Integer.parseInt(memberData[2]));
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
                errors.add(Arrays.toString(memberData));
                continue;
            }
            createSM.setDoA(memberData[3]);
            createSM.setDoB(memberData[4]);
            createSM.setFirstName(memberData[5]);
            createSM.setLastName(memberData[6]);
            createSM.setGender(memberData[7]);
            createSM.setMOS(memberData[8]);
            smrepo.save(createSM);
        }
        return errors.toString();
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
