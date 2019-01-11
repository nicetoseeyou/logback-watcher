package lab.orz.logging.web.socket.impl;

import ch.qos.logback.classic.spi.LoggingEventVO;
import lab.orz.logging.web.socket.IDataRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class LogEventRouter implements IDataRouter<LoggingEventVO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogEventRouter.class);

    @Autowired
    private SimpMessagingTemplate template;

    @Override
    public void transmit(LoggingEventVO event, String... target) {
        LOGGER.debug("Transmit LoggingEvent to topic:{}", target[0]);
        template.convertAndSend(target[0], event);
    }
}
