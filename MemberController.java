package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Member;
import com.example.demo.Service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberservice;

    @PostMapping("/add")
    public Member add(@RequestBody Member m){
         Member x=memberservice.add(m);
         return x;
        
    }

    @GetMapping("/all")
    public List<Member> show(){
        List<Member> l= memberservice.showall();
        return l;
    }

    @GetMapping("/search/{id}")
    public Member search(@PathVariable int id){
        Member m= memberservice.search(id);
        return m;
    }

    @PutMapping("/update/{id}")
    public String updatemember(@PathVariable int id,@RequestBody Member m){
        return memberservice.updatemem(id,m);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return memberservice.remove(id);
    }



    
}
