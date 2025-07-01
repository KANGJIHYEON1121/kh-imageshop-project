package com.kh.imageshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.imageshop.domain.Member;
import com.kh.imageshop.domain.MemberAuth;
import com.kh.imageshop.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper mapper;

    // 등록 처리
    @Transactional
    @Override
    public void register(Member member) throws Exception {
        mapper.create(member);
        // 회원 권한 생성
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuth("ROLE_MEMBER");
        mapper.createAuth(memberAuth);
    }

    // 목록 페이지
    @Override
    public List<Member> list() throws Exception {
        return mapper.list();
    }

}
