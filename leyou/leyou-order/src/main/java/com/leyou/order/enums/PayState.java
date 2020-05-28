package com.leyou.order.enums;

/**
 * @description:
 * @data: 2020/5/27 22:53
 * @author: xiaoNan
 */
public enum PayState {
    NOT_PAY(0),
    SUCCESS(1),
    FAIL(2)
    ;
    PayState(int value) {
        this.value = value;
    }
    int value;
    public int getValue() {
        return value;
    }
}
