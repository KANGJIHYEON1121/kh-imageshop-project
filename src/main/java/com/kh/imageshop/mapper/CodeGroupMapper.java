package com.kh.imageshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.imageshop.domain.CodeGroup;

@Mapper
public interface CodeGroupMapper {
    // 등록 처리
    public void create(CodeGroup codeGroup) throws Exception;

    // 목록 페이지
    public List<CodeGroup> list() throws Exception;

    // 상세 페이지
    public CodeGroup read(CodeGroup codeGroup) throws Exception;

    // 수정 처리
    public void update(CodeGroup codeGroup) throws Exception;

    // 삭제 처리
    public void delete(CodeGroup codeGroup) throws Exception;
}
