package com.siro.yyds.task.scheduled;

import com.siro.yyds.rabbit.constant.MqConst;
import com.siro.yyds.rabbit.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author starsea
 * @date 2022-02-08 21:57
 */
@Component
@EnableScheduling
public class ScheduledTask {

    @Autowired
    private RabbitService rabbitService;

    /**
     * 每天8点执行 提醒就诊
     * 在线生成cron地址：https://crom.qqe2.com
     */
    @Scheduled(cron = "0 0 8 * * ?")
    public void task1() {
        rabbitService.sendMessage(MqConst.EXCHANGE_DIRECT_TASK, MqConst.ROUTING_TASK_8, "");
    }
}
