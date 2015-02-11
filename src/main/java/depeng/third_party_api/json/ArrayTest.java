package depeng.third_party_api.json;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ArrayTest {
    ArrayList<Object> jsonMsgList = new ArrayList<Object>();
    ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
//        loadLogbackConfigFile("")
        InputStream is = ArrayTest.class.getResourceAsStream("/user.json");
        System.out.println(is);
    }


    private void json(Object o) {
        jsonMsgList.add(o);
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(o);
        } catch (IOException e) {
            try {
                jsonStr = mapper.writeValueAsString(e);
            } catch (IOException ignored) {

            }
        }
        MDC.put("JSON_MSG", jsonStr);
    }


    public static void loadLogbackConfigFile(String filePath) {
        // assume SLF4J is bound to logback in the current environment
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);
            // Call context.reset() to clear any previous configuration, e.g. default configuration.
            context.reset();
            // re-configure specified file
            configurator.doConfigure(filePath);
        } catch (JoranException e) {
            e.printStackTrace();
        }
    }

}
