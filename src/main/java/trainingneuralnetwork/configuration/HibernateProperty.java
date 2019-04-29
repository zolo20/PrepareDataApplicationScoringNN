package trainingneuralnetwork.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "hibernate")
public class HibernateProperty {
    private String dialect;
    private String defaultSchema;
    private Boolean showSql;
    private Boolean enableLazyLoadNoTrans;
    private Connection connection = new Connection();

    @Data
    public static class Connection {
        private String driverClass;
        private String url;
        private String username;
        private String password;
    }

}
