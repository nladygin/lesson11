package helper;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class DataLoader {

    private Logger logger = LogManager.getLogger(DataLoader.class);



    public <T> T load(Class<T> type){
        try {
            String json = IOUtils.toString(
                    getClass().getClassLoader().getResourceAsStream(type.getSimpleName() + ".json"),
                    "UTF-8"
            );
            Gson g = new Gson();
            return g.fromJson(json, type);
        } catch (Exception e) {
            logger.error("cannot get test data {}", type.getSimpleName());
            return null;
        }
    }
}
