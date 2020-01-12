package cn.brill.common.id;

/**
 * @author zhang
 * @date 2019/12/26
 */
public interface IdGenerator {

    String get(String key);

    boolean init();

}
