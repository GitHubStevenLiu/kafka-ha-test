package com.example.demo.listener;

import lombok.*;

import java.io.Serializable;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/27 0027 15:18
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FundDto implements Serializable {

    private Long time;
    private String code;
    private Double currentPrice;
}
