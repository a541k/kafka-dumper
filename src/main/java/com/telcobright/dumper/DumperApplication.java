package com.telcobright.dumper;

import com.telcobright.dumper.config.AppConfig;
import com.telcobright.dumper.repository.SmsRepo;
import com.telcobright.dumper.service.CampaignFetcher;
import com.telcobright.dumper.service.CampaignGetter;
import com.telcobright.dumper.service.TaskFetcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class DumperApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DumperApplication.class, args);
		//context.getBean(TaskFetcher.class).getTasks();
		//context.getBean(CampaignFetcher.class).getCampaign();
		//context.getBean(CampaignFetcher.class).findAllCampaign();
		//context.getBean(CampaignFetcher.class).fetchCampaignById("10000");
		context.getBean(CampaignFetcher.class).fetchCampaign();

//		CampaignGetter campaignGetter = new CampaignGetter(()->SmsRepo::getCampaign);


		//System.out.println("hello world");
	}

}
