package com.telcobright.dumper.service;

import com.telcobright.dumper.config.AppConfig;
import com.telcobright.dumper.entity.Campaign;
import com.telcobright.dumper.entity.CampaignTask;
import com.telcobright.dumper.repository.SmsRepo;
import com.telcobright.dumper.repository.CampaignTaskRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskFetcher {
    private final SmsRepo campaignRepo;
    private final CampaignTaskRepository campaignTaskRepo;
    private final AppConfig appConfig;

    public TaskFetcher(SmsRepo campaignRepo, CampaignTaskRepository campaignTaskRepository, AppConfig appConfig) {
        this.campaignRepo = campaignRepo;
        this.campaignTaskRepo = campaignTaskRepository;
        this.appConfig = appConfig;
    }

    public HashMap<Integer, List<CampaignTask>> getTasks(){
        try {
            Integer batchSize = appConfig.getBatchSize();
            Integer pageNumber = appConfig.getPageNumber();
            List<Campaign> campaignList = campaignRepo.findAll();
            boolean moreTasksToFetch = true;

            while (moreTasksToFetch) {
                moreTasksToFetch = false;
                Map<String, List<CampaignTask>> campaignTasksMap = new HashMap<>();

                for (Campaign campaign : campaignList) {
                    String campaignId = campaign.getCampaignId();
                    List<CampaignTask> tasks = fetchTasksForCampaign(campaignId, pageNumber, batchSize);

                    if (!tasks.isEmpty()) {
                        campaignTasksMap.put(campaignId, tasks);
                        moreTasksToFetch = true;
                    }
                }

                //processCampaignTasks(campaignTasksMap);


                campaignTasksMap.clear();
                pageNumber++;
            }
            return new HashMap<>();

        }catch (Exception e){
            System.err.println(e.getMessage());
            return new HashMap<>();
        }
    }

    private List<CampaignTask> fetchTasksForCampaign(String campaignId, int pageNumber, int batchSize) {
        System.out.println("fetching tasks from " + (pageNumber*batchSize) + " to " + (pageNumber*batchSize + batchSize));
        List<CampaignTask> tasks = new ArrayList<>();
        Pageable pageable = PageRequest.of(pageNumber, batchSize);
        Page<CampaignTask> taskPage = campaignTaskRepo.findByCampaignId(campaignId, pageable);

        if (taskPage.hasContent()) {
            tasks.addAll(taskPage.getContent());
        }

        return tasks;
    }

    private void processCampaignTasks(Map<String, List<CampaignTask>> campaignTasksMap) {
        campaignTasksMap.forEach((campaignId, tasks) -> {
            System.out.println("processing tasks for campaignId: " + campaignId);
            tasks.forEach(task -> {
                System.out.println("taskId: " + task.getCampaignTaskId());
            });
        });
    }
}
