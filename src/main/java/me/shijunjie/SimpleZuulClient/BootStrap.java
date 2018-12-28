package me.shijunjie.SimpleZuulClient;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan("me.shijunjie")
@EnableZuulProxy
public class BootStrap {
	public static void main(String[] args) {
		SpringApplication.run(BootStrap.class, args); 
	}
}
