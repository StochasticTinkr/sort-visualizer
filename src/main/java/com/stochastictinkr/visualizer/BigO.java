package com.stochastictinkr.visualizer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BigO {
    CONST("O(1)"),
    N("O(n)"),
    NLOGN ("O(nlogn)"),
    N2("O(n²)"),
    EXP("O(aⁿ)")
    ;
    private final String description;
}
