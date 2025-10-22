package com.davivienda.pensionados.config;

import java.util.List;
import java.util.Objects;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@ConfigurationProperties(prefix="cors")
@Getter 
@Setter 
@RequiredArgsConstructor 
@ToString
public class CorsProperties {

	private List<String> allowedOrigins;
	private List<String> allowedHeaders;
	private List<String> allowedMethods;
	private List<String> exposedHeaders;

	@Override
	public int hashCode() {
		return Objects.hash(allowedHeaders, allowedMethods, allowedOrigins, exposedHeaders);
	}
}
