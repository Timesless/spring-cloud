package com.yangzl.springcloud.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author yangzl
 * @Date: 2020/8/8 14:16
 * @Desc:
 */

@Getter
@Setter
@ToString
public class Payment {

    private Long id;
    private String seq;

    public Payment() {}
    public Payment(Long id, String seq) {
        this.id = id;
        this.seq = seq;
    }
}
