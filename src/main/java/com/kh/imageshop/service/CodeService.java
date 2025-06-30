package com.kh.imageshop.service;

import java.util.List;

import com.kh.imageshop.common.domain.CodeLabelValue;

public interface CodeService {
    // 그룹코드 목록 조회 (그룹목록코드, 그룹목록이름)
    public List<CodeLabelValue> getCodeGroupList() throws Exception;
}
