package com.kh.imageshop.service;

import java.util.List;

import com.kh.imageshop.domain.Member;

public interface MemberService {
    // 등록 처리
    public void register(Member member) throws Exception;

    // 목록 페이지
    public List<Member> list() throws Exception;
}
