package com.testjava2020.Prices;

import com.testjava2020.Prices.entity.Brand;
import com.testjava2020.Prices.entity.Price;
import com.testjava2020.Prices.entity.Product;
import com.testjava2020.Prices.repository.BrandRepository;
import com.testjava2020.Prices.repository.PricesRepository;
import com.testjava2020.Prices.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.util.List;

@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(MainApplication.class,args);
		BrandRepository brandRepository = configurableApplicationContext.getBean(BrandRepository.class);
		ProductRepository productRepository = configurableApplicationContext.getBean(ProductRepository.class);
		PricesRepository pricesRepository = configurableApplicationContext.getBean(PricesRepository.class);

		Brand brand = new Brand(1,"ZARA");
		brandRepository.save(brand);

		Product product = new Product(35455,"test");
		productRepository.save(product);

		Price price = new Price(1,brand,product, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),"1","0","35.50","EUR");
		Price price1 = new Price(2,brand,product, LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"),"2","1","25.45","EUR");
		Price price2 = new Price(3,brand,product, LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"),"3","1","30.50","EUR");
		Price price3 = new Price(4,brand,product, LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),"4","1","38.95","EUR");

		List<Price> listPrice = List.of(price,price1,price2,price3);

		pricesRepository.saveAll(listPrice);
	}

	@Bean
	public Docket productApi() {
		ApiInfo apiInfo= new ApiInfoBuilder().title("Prueba Tecnica JavaTest")
				.description("Proyecto para prueba tecnica")
				.termsOfServiceUrl("Developer: Faber Garcia")
				.licenseUrl("faber-1234-@hotmail.com").version("1.0").build();

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.testjava2020.Prices.controller"))
				.build();
	}


}
