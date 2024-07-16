package com.telcobright.dumper;

import com.telcobright.dumper.service.CampaignFetcher;
import com.telcobright.dumper.service.CampaignTaskFetcher;
import com.telcobright.dumper.service.KafkaDumper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DumperApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DumperApplication.class, args);
	}

	@Bean
	public KafkaDumper kafkaDumper(CampaignTaskFetcher taskFetcher, CampaignFetcher campaignFetcher) {
		return new KafkaDumper(10, 20);
	}

}
