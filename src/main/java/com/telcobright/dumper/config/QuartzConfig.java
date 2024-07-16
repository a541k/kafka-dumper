package com.telcobright.dumper.config;


import com.telcobright.dumper.service.KafkaDumper;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class QuartzConfig implements Job {
    @Autowired
    private ApplicationContext context;

    @Bean
    public JobDetailFactoryBean jobDetail() {
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setName("campaign_dumper_job");
        factory.setJobClass(QuartzConfig.class);
        factory.setDurability(true);
        return factory;
    }

    @Bean
    public SimpleTriggerFactoryBean jobTrigger(JobDetail jobDetail) {
        SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
        factory.setJobDetail(jobDetail);
        factory.setRepeatInterval(10000); // Repeat every 10 seconds
        factory.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        return factory;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        context.getBean(KafkaDumper.class).dumpTasksToKafka();
    }
}
