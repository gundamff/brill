package cn.brill.common.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * @author zhang
 * @date 2019/12/27
 */
@Data
public class SearchVo implements Serializable {
    private String startDate;

    private String endDate;
}
