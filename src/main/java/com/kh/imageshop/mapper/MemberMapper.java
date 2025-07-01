package com.kh.imageshop.mapper;

import java.util.List;

import com.kh.imageshop.domain.Member;
import com.kh.imageshop.domain.MemberAuth;

public interface MemberMapper {
    // 등록 처리
    public void create(Member member) throws Exception;

    // 권한 생성
    public void createAuth(MemberAuth memberAuth) throws Exception;

    // 목록 페이지
    public List<Member> list() throws Exception;
}
