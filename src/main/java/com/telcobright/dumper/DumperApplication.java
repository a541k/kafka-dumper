package com.telcobright.dumper;

import com.telcobright.dumper.config.AppConfig;
import com.telcobright.dumper.entity.Campaign;
import com.telcobright.dumper.service.CampaignFetcher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class DumperApplication {

	public static void main(String[] args) {
		SpringApplication.run(DumperApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			CampaignFetcher campaignFetcher = context.getBean(CampaignFetcher.class);

			// Example: Fetch campaigns with default strategy
			campaignFetcher.fetchCampaign(false, null);

			// Example: Fetch active campaigns with custom specification
			Specification<Campaign> spec = (root, query, criteriaBuilder) ->
					criteriaBuilder.equal(root.get("status"), "active");
			campaignFetcher.fetchCampaign(true, spec);
		};
	}
}
