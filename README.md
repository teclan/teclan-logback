
# logback 日志使用

## 加入日志依赖
```Java
       <dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>1.7.7</version>
		</dependency>		
		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
			<version>1.1.3</version>
			<scope>runtime</scope>
		</dependency>

```

## 配置 logback.xml
  在项目classpath（/src/main/resources）下面建立 logback.xml,内容如下：
  ```Java
<?xml version="1.0" encoding="UTF-8" ?>
	<configuration>
	  <jmxConfigurator />
	  <!-- 控制台输出日志 -->
	  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
	    <layout class="ch.qos.logback.classic.PatternLayout">
	      <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
	    </layout>
	  </appender>
	  <!-- 文件输出日志 (文件大小策略进行文件输出，超过指定大小对文件备份)-->
	  <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
	   <!-- 日志文件路径 -->
	    <File>log/teclan-logback.log</File>
	    <rollingPolicy class="ch.qos.logback.core.rolling.FixedWindowRollingPolicy">
	      <FileNamePattern>%d{yyyy-MM-dd}.%i/teclan-logback.log.gz</FileNamePattern>
	      <!-- keep 30 days' worth of history -->
		  <maxHistory>30</maxHistory>
	      <MinIndex>1</MinIndex>
	      <MaxIndex>12</MaxIndex>
	    </rollingPolicy>
	    <triggeringPolicy            class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
	      <MaxFileSize>100MB</MaxFileSize>
	    </triggeringPolicy>
	    <layout class="ch.qos.logback.classic.PatternLayout">
	      <Pattern>log/%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</Pattern>
	    </layout>
	  </appender>
	   <!-- 日志级别，日志等级由低到高依次是 DEBUG，INFO，ERROR，只会输出 >=level 的日志 -->
	   <root level="ERROR">
			<appender-ref ref="STDOUT" />
			<appender-ref ref="FILE" />
		</root>
	</configuration>
  ```
  
  ## 每个日志级别指定一个输出文件
  
  参考以下
  ```
  <?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
		<!-- encoder 默认配置为PatternLayoutEncoder -->
		<encoder>
			<pattern>%d [%thread] %-5level %logger{36}[%L] - %msg%n
			</pattern>
		</encoder>
	</appender>
	
	<appender name="DEBUG"
		class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>log/teclan-lvzaotou-debug.log</file>
		<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
			<!-- daily rollover -->
			<fileNamePattern>log/teclan-lvzaotou-debug-%d{yyyy-MM-dd}.%i.log
			</fileNamePattern>
			<!-- <fileNamePattern>log/teclan-lvzaotou-%d{yyyy-MM-dd}.%i.log.gz</fileNamePattern> -->
			<!-- keep 30 days' worth of history -->
			<maxHistory>30</maxHistory>
			<timeBasedFileNamingAndTriggeringPolicy
				class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
				<!-- max size of log file -->
				<maxFileSize>10MB</maxFileSize>
			</timeBasedFileNamingAndTriggeringPolicy>
		</rollingPolicy>
		<filter class="ch.qos.logback.classic.filter.LevelFilter"> 
            <level>DEBUG</level> 
            <onMatch>ACCEPT</onMatch> 
            <onMismatch>DENY</onMismatch> 
        </filter> 
		<encoder>
			<pattern>%d [%thread] %-5level %logger{36}[%L] - %msg%n</pattern>
		</encoder>
	</appender>
	
	<appender name="INFO"
		class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>log/teclan-lvzaotou-info.log</file>
		<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
			<!-- daily rollover -->
			<fileNamePattern>log/teclan-lvzaotou-info-%d{yyyy-MM-dd}.%i.log
			</fileNamePattern>
			<!-- <fileNamePattern>log/teclan-lvzaotou-%d{yyyy-MM-dd}.%i.log.gz</fileNamePattern> -->
			<!-- keep 30 days' worth of history -->
			<maxHistory>30</maxHistory>
			<timeBasedFileNamingAndTriggeringPolicy
				class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
				<!-- max size of log file -->
				<maxFileSize>10MB</maxFileSize>
			</timeBasedFileNamingAndTriggeringPolicy>
		</rollingPolicy>
		<filter class="ch.qos.logback.classic.filter.LevelFilter"> 
            <level>INFO</level> 
            <onMatch>ACCEPT</onMatch> 
            <onMismatch>DENY</onMismatch> 
        </filter> 
		<encoder>
			<pattern>%d [%thread] %-5level %logger{36}[%L] - %msg%n</pattern>
		</encoder>
	</appender>
	
	<appender name="WARN"
		class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>log/teclan-lvzaotou-warn.log</file>
		<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
			<!-- daily rollover -->
			<fileNamePattern>log/teclan-lvzaotou-warn-%d{yyyy-MM-dd}.%i.log
			</fileNamePattern>
			<!-- <fileNamePattern>log/teclan-lvzaotou-%d{yyyy-MM-dd}.%i.log.gz</fileNamePattern> -->
			<!-- keep 30 days' worth of history -->
			<maxHistory>30</maxHistory>
			<timeBasedFileNamingAndTriggeringPolicy
				class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
				<!-- max size of log file -->
				<maxFileSize>10MB</maxFileSize>
			</timeBasedFileNamingAndTriggeringPolicy>
		</rollingPolicy>
		<filter class="ch.qos.logback.classic.filter.LevelFilter"> 
            <level>WARN</level> 
            <onMatch>ACCEPT</onMatch> 
            <onMismatch>DENY</onMismatch> 
        </filter> 
		<encoder>
			<pattern>%d [%thread] %-5level %logger{36}[%L] - %msg%n</pattern>
		</encoder>
	</appender>
	
	<appender name="ERROR"
		class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>log/teclan-lvzaotou-erro.log</file>
		<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
			<!-- daily rollover -->
			<fileNamePattern>log/teclan-lvzaotou-error-%d{yyyy-MM-dd}.%i.log
			</fileNamePattern>
			<!-- <fileNamePattern>log/teclan-lvzaotou-%d{yyyy-MM-dd}.%i.log.gz</fileNamePattern> -->
			<!-- keep 30 days' worth of history -->
			<maxHistory>30</maxHistory>
			<timeBasedFileNamingAndTriggeringPolicy
				class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
				<!-- max size of log file -->
				<maxFileSize>10MB</maxFileSize>
			</timeBasedFileNamingAndTriggeringPolicy>
		</rollingPolicy>
		<filter class="ch.qos.logback.classic.filter.LevelFilter"> 
            <level>ERROR</level> 
            <onMatch>ACCEPT</onMatch> 
            <onMismatch>DENY</onMismatch> 
        </filter> 
		<encoder>
			<pattern>%d [%thread] %-5level %logger{36}[%L] - %msg%n</pattern>
		</encoder>
	</appender>

	<root level="DEBUG">
		<appender-ref ref="STDOUT" />
		<appender-ref ref="DEBUG" />
		<appender-ref ref="INFO" />
		<appender-ref ref="WARN" />
		<appender-ref ref="ERROR" />
	</root>
</configuration>
  ```
