package com.kh.imageshop.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeGroup {
    private String groupCode;
    private String groupName;
    private String useYn;
    private Date regDate;
    private Date updDate;
}