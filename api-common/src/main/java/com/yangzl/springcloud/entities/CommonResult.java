package com.yangzl.springcloud.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author yangzl
 * @Date: 2020/8/8 14:12
 * @Desc:
 */

@Getter
@Setter
@ToString
public class CommonResult<T> {

    private Integer code;
    private String msg;
    private T data;

    public CommonResult() {}
    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }
    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
