package top.chengyunlai.springbootmiddleutils.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("chengyunlai.accept")
@Data
public class GroupListProperties {
    private String permission;
}
