package org.okcoder.springcloud.configclientapp1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/welcome")
    public String greeting(@Value("${welcome:hello}") String welcome) {
        return welcome;
    }
}
