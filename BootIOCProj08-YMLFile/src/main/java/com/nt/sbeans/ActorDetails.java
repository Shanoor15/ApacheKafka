package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("actor")
@Data
@ConfigurationProperties(prefix="movie.actor")
public class ActorDetails {

	private String name;
	private String addrs;
	private String category;
	private Double fee;
	private String industry;
	private String email;
	//array type
	private String[] favColor;
	//collection type
	private List<String> friends;
	private Set<Long> phoneNumbers;
	private Map<String,Object> idDetails;
	private Customer customer;
	
}
