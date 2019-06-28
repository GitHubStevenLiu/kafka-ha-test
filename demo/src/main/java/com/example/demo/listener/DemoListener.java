package com.example.demo.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/28 0028 14:03
 */
@EnableBinding({FundChannel.class})
@Component
public class DemoListener {

    @Resource(name = FundChannel.FUND_OUTPUT)
    private MessageChannel sendFundMessageChannel;


    @StreamListener(FundChannel.FUND_INPUT)
    public void receive(Message<String> message) throws InterruptedException {
        System.out.println("接收"+message);
    }


    @Scheduled(cron = "0/8 * * * * ? ")
    public void genDate() {
        String s = Calendar.getInstance().getTime().toLocaleString();
        boolean send = sendFundMessageChannel.
                send(MessageBuilder.withPayload(s).build());
        System.out.println("发送"+s+" , 发送"+send);
    }

}
