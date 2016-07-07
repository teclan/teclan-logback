package teclan.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LobakDemo {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(LobakDemo.class);

    public static void main(String[] args) {
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.error("error");

    }
}
