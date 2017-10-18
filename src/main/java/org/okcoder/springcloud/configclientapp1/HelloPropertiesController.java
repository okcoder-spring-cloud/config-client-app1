package org.okcoder.springcloud.configclientapp1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(HelloProperties.class)
public class HelloPropertiesController {
//curl -X POST http://localhost:8080/refresh
//change helloProperties.getWelcomeMessage() but no refreshScopeValue
//curl http://localhost:8080/welcome1

	@Autowired
	private HelloProperties helloProperties; 

	@Value("${hello.refreshScope:}")
	private String refreshScopeValue; 

	private final Logger logger = LoggerFactory.getLogger(HelloRefreshScopeController.class);

    @RequestMapping("/welcome2")
    public String welcome(@Value("${welcome:hello}") String welcome) {
    	logger.debug("welcome2={}",welcome);
    	return Stream.of(refreshScopeValue,helloProperties.getWelcomeMessage(),welcome).collect(Collectors.joining("#"));
    }

}
