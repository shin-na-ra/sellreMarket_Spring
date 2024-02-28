package com.springlec.base.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
/*
*  Mybatis 사용을 위한 SqlSessionFactoryBean을 생성하는 클래스
*/
@Configuration
@MapperScan(basePackages ="com.springlec.base.dao")
public class DataAccessConfig {
	@Bean
	SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource);
		
		sessionFactory.setMapperLocations(
			new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml")
		
		);
		
		return sessionFactory.getObject();
	}
	
	@Bean
	SqlSessionTemplate sessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
