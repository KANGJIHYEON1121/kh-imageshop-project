package com.kh.imageshop.service;

import java.util.List;

import com.kh.imageshop.domain.CodeDetail;

public interface CodeDetailService {
    // 등록 처리
    public void register(CodeDetail codeDetail) throws Exception;

    // 목록 페이지
    public List<CodeDetail> list() throws Exception;
}
