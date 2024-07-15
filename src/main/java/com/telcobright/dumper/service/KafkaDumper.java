package com.telcobright.dumper.service;

import com.telcobright.dumper.entity.Campaign;
import com.telcobright.dumper.entity.CampaignTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaDumper {
    @Autowired
    private CampaignTaskFetcher taskFetcher;
    @Autowired
    private CampaignFetcher campaignFetcher;

    private final int campaignBatchSize;
    private final int taskBatchSize;

    public KafkaDumper(int campaignBatchSize, int taskBatchSize) {
        this.campaignBatchSize = campaignBatchSize;
        this.taskBatchSize = taskBatchSize;
    }

    public void dumpTasksToKafka(){
        boolean tasksLeft = false;
        int pageNumberOfCampaigns = 0;
        do{
            Page<Campaign> campaignPage = campaignFetcher.fetchEntities(PageRequest.of(pageNumberOfCampaigns++, campaignBatchSize));
            if(campaignPage.isEmpty()){//---iteration complete, reset---
                pageNumberOfCampaigns = 0;
                continue;
            }
            for(Campaign campaign : campaignPage.getContent()) {
                Page<CampaignTask> campaignTaskPage = taskFetcher.getTasksForCampaign(campaign.getCampaignId(), PageRequest.of(0, taskBatchSize));
                List<CampaignTask> campaignTasks = new ArrayList<>(campaignTaskPage.getContent());
                if(campaignTasks.isEmpty()) tasksLeft = true;
                campaignTasks.forEach(campaignTask -> {
                    System.out.println(campaignTask.getCampaignTaskId());
                    //---send to Kafka---
                });
            }
        }while(tasksLeft);

    }
}
