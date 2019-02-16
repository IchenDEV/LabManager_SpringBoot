package com.idevlab.LabMgr.Config;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.idevlab.LabMgr.Service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * @author JE哥
 * @email
 * @description:动态修改定时任务cron参数
 */
@Component
public class DynamicScheduledTask implements SchedulingConfigurer {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String DEFAULT_CRON = "0 0 0/5 * * ?";
    private String cron = DEFAULT_CRON;
    private String lastBackTime = null;
    @Autowired
    private LogService logService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                Task();
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 定时任务触发，可修改定时任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });
    }

    public void Task() {
        // 定时任务的业务逻辑
        System.out.println("尝试备份，当前时间：" + dateFormat.format(new Date()));
        setLastBackTime(dateFormat.format(new Date()));
        logService.addLog("System", "Backup", "DB");
        try {
            String shpath = "/home/backup.sh";
            Process ps = Runtime.getRuntime().exec(shpath);
            ps.waitFor();
            System.out.println("备份数据库成功");
        } catch (Exception e) {
            System.out.println("备份数据库失败");
        }
    }

    /**
     * @return the lastBackTime
     */
    public String getLastBackTime() {
        return lastBackTime;
    }

    /**
     * @param lastBackTime the lastBackTime to set
     */
    public void setLastBackTime(String lastBackTime) {
        this.lastBackTime = lastBackTime;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    /**
     * @return the cron
     */
    public String getCron() {
        return cron;
    }
}