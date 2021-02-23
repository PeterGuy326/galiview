package cn.edu.zucc.galiview.gateway;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaClient
public class GateWayApplication {

	private static final Logger LOG = LoggerFactory.getLogger(GateWayApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(GateWayApplication.class);
		Environment env = app.run(args).getEnvironment();
		LOG.info("启动成功！！");
		LOG.info("Gateway地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
	}
}
