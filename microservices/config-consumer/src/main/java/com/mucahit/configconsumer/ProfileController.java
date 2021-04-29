package com.mucahit.configconsumer;

import com.mucahit.configconsumer.model.MemberProfileConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    MemberProfileConfig memberProfileConfig;

    @GetMapping("/profile")
    public MemberProfileConfig getConfig(){
        return memberProfileConfig;
    }
}
