package top.chengyunlai.springbootmiddleutils.config.auth;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.chengyunlai.springbootmiddleutils.properties.GroupListProperties;

@Configuration
@ConditionalOnClass(GroupListProperties.class)
@EnableConfigurationProperties(GroupListProperties.class)
@ConditionalOnProperty(prefix = "chengyunlai.accept", value = "enabled", matchIfMissing = false)
public class GroupListAutoConfigure {

    /**
     * @description: 将配置文件类实例化为Bean
     * @param: [properties]
     * @return: java.lang.String
     * @author Chengyunlai
     * @date: 2023/8/26
     */
    @Bean("groupList")
    @ConditionalOnMissingBean
    public String groupListConfig(GroupListProperties properties) {
        return properties.getPermission();
    }

}