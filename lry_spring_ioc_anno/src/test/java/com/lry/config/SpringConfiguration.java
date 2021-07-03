package com.lry.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
//<context:component-scan base-package="com.lry"/>
@ComponentScan("com.lry")
//<context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")
//<import resource=""></import>
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {


}
