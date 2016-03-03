package com.personal.diecastfun.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.personal.diecastfun.conditions.ConditionResolver;
import com.personal.diecastfun.controllers.service.BasicFacade;
import com.personal.diecastfun.controllers.service.BrandFacade;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.controllers.service.ColorFacade;
import com.personal.diecastfun.controllers.service.ConditionResolverFacade;
import com.personal.diecastfun.controllers.service.ConfigFacade;
import com.personal.diecastfun.controllers.service.EraFacade;
import com.personal.diecastfun.controllers.service.MakerFacade;
import com.personal.diecastfun.controllers.service.TagsFacade;
import com.personal.diecastfun.controllers.service.ViewsFacade;
import com.personal.diecastfun.controllers.service.VotesFacade;
import com.personal.diecastfun.utils.Paginator;

@Configuration
@ComponentScan(basePackages = { "com.personal.diecastfun" })
@EntityScan(basePackages = { "com.personal.diecastfun.domain" })
@EnableTransactionManagement
@EnableWebMvc
@EnableScheduling
@EnableJpaRepositories(basePackages = { "com.personal.diecastfun.domain.repositories" })
@PropertySources(value = { @PropertySource("classpath:application.properties") })
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public BasicFacade basicFacade() {
		return new BasicFacade();
	}

	@Bean
	public BrandFacade brandFacade() {
		return new BrandFacade();
	}

	@Bean
	public CarFacade carFacade() {
		return new CarFacade();
	}

	@Bean
	public ColorFacade colorFacade() {
		return new ColorFacade();
	}

	@Bean
	public ConfigFacade configFacade() {
		return new ConfigFacade();
	}

	@Bean
	public EraFacade eraFacade() {
		return new EraFacade();
	}

	@Bean
	public MakerFacade makerFacade() {
		return new MakerFacade();
	}

	@Bean
	public TagsFacade tagsFacade() {
		return new TagsFacade();
	}

	@Bean
	public ViewsFacade viewsFacade() {
		return new ViewsFacade();
	}

	@Bean
	public VotesFacade votesFacade() {
		return new VotesFacade();
	}

	@Bean
	public Paginator paginator() {
		return new Paginator();
	}

	@Bean
	public ConditionResolver conditionResolver() {
		return new ConditionResolver();
	}

	@Bean
	public ConditionResolverFacade conditionResolverFacade() throws Exception {
		return new ConditionResolverFacade(conditionResolver());
	}

	@Bean(name = "jspViewResolver")
	public ViewResolver getJspViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
