package com.telcobright.dumper.service;

import com.telcobright.dumper.config.AppConfig;
import com.telcobright.dumper.entity.Campaign;
import com.telcobright.dumper.entity.CampaignTask;
import com.telcobright.dumper.repository.SmsRepo;
import com.telcobright.dumper.repository.CampaignTaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignFetcher extends EntityFetcher<Campaign>{

//    public void getCampaign(){
//        int pageNumber = appConfig.getCampaignPageNumber();
//        int batchSize = appConfig.getCampaignBatchSize();
//
//        Page<Campaign> campaignPage;
//
//        do {
//            //campaignPage = campaignRepository.findAll(PageRequest.of(pageNumber++, batchSize));
//            campaignPage = smsRepo.findByQuery(PageRequest.of(pageNumber++, batchSize));
//
//            System.out.println("On page: " + pageNumber + "----------------------");
//            for (Campaign campaign : campaignPage.getContent()) {
//                List<CampaignTask> taskList = fetchFailedTasks(campaign.getCampaignId());
//                System.out.println("for campaignId: " + campaign.getCampaignId() + " tasks f3tched: "+ taskList.size());
//            }
//        }while (campaignPage.hasContent());
//
//    }
//
//    private List<CampaignTask> fetchFailedTasks(String campaignId) {
//        Pageable pageable = PageRequest.of(0, appConfig.getCampaignTaskBatchSize());
//        Page<CampaignTask> page = campaignTaskRepository.getFailedTaskBatch(pageable, campaignId);
//        return page.getContent();
//    }
//
    public void fetchCampaign(){
        fetchEntities();
    }
//
//
//    public void fetchCampaignById(String campaignId){
//        Optional<Campaign> campaignOptional = smsRepo.findByCampaignId(campaignId);
//        if(campaignOptional.isPresent()){
//            Campaign campaign = campaignOptional.get();
//            System.out.println(campaign);
//        }else{
//            System.out.println("campaign not found with id: " + campaignId);
//        }
//    }

//    public void findAllCampaign(){
//        List<Campaign> campaignList = smsRepo.findAllCampaigns();
//        campaignList.forEach(System.out::println);
//    }

}
