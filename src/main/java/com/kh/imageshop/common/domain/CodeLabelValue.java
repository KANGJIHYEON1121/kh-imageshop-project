package com.kh.imageshop.common.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CodeLabelValue {
    private final String value;
    private final String label;
}
