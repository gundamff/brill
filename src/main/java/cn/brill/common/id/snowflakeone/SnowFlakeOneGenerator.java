package cn.brill.common.id.snowflakeone;

import cn.brill.common.id.IdGenerator;

/**
 * @author zhang
 * @date 2019/12/26
 */
public class SnowFlakeOneGenerator implements IdGenerator {

    @Override
    public String get(String key) {
        return String.valueOf(SnowFlakeOneUtil.getFlowIdInstance().nextId());
    }

    @Override
    public boolean init() {
        return true;
    }

}
