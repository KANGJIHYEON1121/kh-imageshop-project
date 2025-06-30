package com.kh.imageshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.imageshop.domain.CodeDetail;
import com.kh.imageshop.mapper.CodeDetailMapper;

@Service
public class CodeDetailServiceImpl implements CodeDetailService {
    @Autowired
    private CodeDetailMapper mapper;

    // 등록 처리
    @Override
    public void register(CodeDetail codeDetail) throws Exception {
        String groupCode = codeDetail.getGroupCode();
        int maxSortSeq = mapper.getMaxSortSeq(groupCode);
        codeDetail.setSortSeq(maxSortSeq + 1);
        mapper.create(codeDetail);
    }

    // 목록 페이지
    @Override
    public List<CodeDetail> list() throws Exception {
        return mapper.list();
    }
}
