package org.okcoder.springcloud.configclientapp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//curl -X POST http://localhost:8080/refresh
//change logger.level by spring boot 1.5.X
//curl http://localhost:8080/welcome


	private final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
    @RequestMapping("/welcome")
    public String welcome(@Value("${welcome:hello}") String welcome) {
    	logger.debug("welcome={}",welcome);
        return welcome;
    }
}
