package cn.brill.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import cn.brill.common.id.IdGeneratorTypeEnum;
import lombok.Data;

/**
 * @author zhang
 * @date 2019/12/26
 */
@Data
@ConfigurationProperties(prefix = "id.generator")
public class IdGeneratorTypeProperties {

    private IdGeneratorTypeEnum type;

}
