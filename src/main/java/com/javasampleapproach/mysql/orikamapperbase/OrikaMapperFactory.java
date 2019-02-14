package com.javasampleapproach.mysql.orikamapperbase;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaMapperFactory {

	private static MapperFactory mapperFactory;
	
	
	public MapperFactory getMapperFactory() {
		if(mapperFactory == null) createMapperFactory();
		return mapperFactory;
	}
	
	public void createMapperFactory() {
		mapperFactory = new DefaultMapperFactory.Builder().build();
	}
}
