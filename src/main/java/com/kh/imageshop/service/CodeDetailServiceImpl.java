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

    // 코드디테일 등록 처리
    @Override
    public void register(CodeDetail codeDetail) throws Exception {
        // 선택된 코드그룹코드
        String groupCode = codeDetail.getGroupCode();
        // 그룹 코드 정렬 순서의 최대값
        int maxSortSeq = mapper.getMaxSortSeq(groupCode);
        codeDetail.setSortSeq(maxSortSeq + 1);
        mapper.create(codeDetail);
    }

    // 목록 페이지
    @Override
    public List<CodeDetail> list() throws Exception {
        return mapper.list();
    }

    // 상세 페이지(수정 페이지)
    @Override
    public CodeDetail read(CodeDetail codeDetail) throws Exception {
        return mapper.read(codeDetail);
    }

    // 수정 처리
    @Override
    public void modify(CodeDetail codeDetail) throws Exception {
        mapper.update(codeDetail);
    }

    // 삭제 처리
    @Override
    public void remove(CodeDetail codeDetail) throws Exception {
        mapper.delete(codeDetail);
    }
}
