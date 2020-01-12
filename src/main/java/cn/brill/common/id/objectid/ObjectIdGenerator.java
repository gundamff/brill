package cn.brill.common.id.objectid;

import cn.brill.common.id.IdGenerator;

/**
 * mongoDB使用的ObjectId
 * 
 * 可以算作是和snowflake类似方法，通过“时间+机器码+pid+inc”共12个字节，通过4+3+2+3的方式最终标识成一个24长度的十六进制字符。
 * 
 * @author zhang
 * @date 2019/12/26
 */
public class ObjectIdGenerator implements IdGenerator {

    @Override
    public String get(String key) {
        return ObjectId.get().toString();
    }

    @Override
    public boolean init() {
        return true;
    }
}
