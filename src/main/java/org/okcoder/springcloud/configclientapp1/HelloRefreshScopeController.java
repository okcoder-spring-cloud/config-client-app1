package org.okcoder.springcloud.configclientapp1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloRefreshScopeController {
//curl -X POST http://localhost:8080/refresh
//change refreshScopeValue 
//curl http://localhost:8080/welcome3


	@Value("${hello.refreshScope:}")
	private String refreshScopeValue; 

	private final Logger logger = LoggerFactory.getLogger(HelloRefreshScopeController.class);

    @RequestMapping("/welcome3")
    public String welcome(@Value("${welcome:hello}") String welcome) {
    	logger.debug("welcome3={}",welcome);
    	return Stream.of(refreshScopeValue,welcome).collect(Collectors.joining("#"));
    }

}
