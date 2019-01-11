package lab.orz.logging.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/logs")
public class LogController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @RequestMapping(value = "/view/{host}")
    public String view(@PathVariable(value = "host", required = true) String host) {
        LOGGER.info("View Agent[host={}] logs.", host);
        return "metrics/metrics";
    }
}
