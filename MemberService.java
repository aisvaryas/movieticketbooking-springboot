package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Entity.Member;
import com.example.demo.Repository.MemberRepo;

@Service
public class MemberService {
    @Autowired
    MemberRepo mr;

    public Member add(Member m) {
        Member m1  = mr.save(m);
        
        return m1;
        
    }

    public List<Member> showall() {
        List<Member> l= mr.findAll();
        return l;
    }

    public Member search(int id) {
        Member m = mr.findById(id).orElse(null);
        if(m!=null){
            return m;
        }
        return null;
    }

    public String updatemem(int id, Member m) {
        Member x = mr.findById(id).orElse(null);
        if(x!=null){
            x.setName(m.getName());
            x.setEmail(m.getEmail());
            x.setMobileNo(m.getMobileNo());
            x.setCity(m.getCity());
            x.setPassword(m.getPassword());
            mr.save(m);
            return "updated";

        }
        return "not found";
       
    }

    public String remove(int id) {
         Member x = mr.findById(id).orElse(null);
        if(x!=null){
            mr.deleteById(id);
            return "deleted";
        }
        return "not found";
    }





    

    
}
