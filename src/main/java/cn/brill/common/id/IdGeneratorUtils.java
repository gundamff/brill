package cn.brill.common.id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.brill.common.id.objectid.ObjectIdGenerator;
import cn.brill.common.utils.SpringContextUtil;
import cn.brill.config.properties.IdGeneratorTypeProperties;

/**
 * @author zhang
 * @date 2019/12/26
 */
@Configuration
@EnableConfigurationProperties(IdGeneratorTypeProperties.class)
public class IdGeneratorUtils {

    @Autowired
    private IdGeneratorTypeProperties idGeneratorTypeProperties;

    @ConditionalOnMissingBean(IdGenerator.class)
    @Bean
    @ConditionalOnProperty(prefix = "id.generator", name = "type", havingValue = "objectId", matchIfMissing = true)
    public IdGenerator autoConfMongodbIdGenerator() {
        return new ObjectIdGenerator();
    }

    /**
     * @return
     */
    public static IdGenerator getGenerator() {
        return SpringContextUtil.getBean(IdGenerator.class);
    }

}
