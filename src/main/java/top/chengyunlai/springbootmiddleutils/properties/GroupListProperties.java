package top.chengyunlai.springbootmiddleutils.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description 读取配置文件中的配置
 */
@ConfigurationProperties("chengyunlai.accept")
@Data
public class GroupListProperties {
    private String permission;
}
