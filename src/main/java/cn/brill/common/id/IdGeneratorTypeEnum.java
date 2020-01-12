package cn.brill.common.id;

/**
 * @author zhang
 * @date 2019/12/26
 */
public enum IdGeneratorTypeEnum {
    // https://github.com/Meituan-Dianping/Leaf
    // TODO 目前只实现了objectId snowflakeOne
    objectId, segment, snowflake, snowflakeOne, zero
}
