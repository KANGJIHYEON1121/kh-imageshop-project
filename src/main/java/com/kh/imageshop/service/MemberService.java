package com.kh.imageshop.service;

import java.util.List;

import com.kh.imageshop.domain.Member;

public interface MemberService {
    // 등록 처리
    public void register(Member member) throws Exception;

    // 목록 페이지
    public List<Member> list() throws Exception;

    // 상세 페이지
    public Member read(int userNo) throws Exception;

    // 수정 처리
    public void modify(Member member) throws Exception;

    // 삭제 처리
    public void remove(int userNo) throws Exception;
}
