package com.patika.webApi;

import com.patika.business.abstracts.MemberAccountService;
import com.patika.business.requests.MemberAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memberaccount")
public class MemberAccountController {
    private MemberAccountService _memberAccountService;

    @Autowired
    public MemberAccountController(MemberAccountService _memberAccountService) {
        this._memberAccountService = _memberAccountService;
    }

    @PostMapping(name="/add")
    public ResponseEntity<Object> add(MemberAccountRequest memberAccountRequest){
        return  ResponseEntity.ok(this._memberAccountService.add(memberAccountRequest));
    }
}
