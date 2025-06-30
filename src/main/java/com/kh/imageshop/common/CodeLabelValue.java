package com.kh.imageshop.common;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class CodeLabelValue {
    private final String value;
    private final String label;
}
