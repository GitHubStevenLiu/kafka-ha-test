package com.example.demo.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/26 0026 13:39
 */
public interface FundChannel {

    /**
     * 发消息的通道名称
     */
    String FUND_OUTPUT = "fund_output";

    /**
     * 消息的订阅通道名称
     */
    String FUND_INPUT = "fund_input";

    /**
     * 发消息的通道
     *
     * @return
     */
    @Output(FUND_OUTPUT)
    MessageChannel sendFundMessage();

    /**
     * 收消息的通道
     *
     * @return
     */
    @Input(FUND_INPUT)
    SubscribableChannel receiveFundMessage();

}