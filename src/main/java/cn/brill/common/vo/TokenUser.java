package cn.brill.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhang
 * @date 2020/12/30
 */
@Data
@AllArgsConstructor
public class TokenUser implements Serializable {

    private String username;

    private List<String> permissions;

    private Boolean saveLogin;
}
