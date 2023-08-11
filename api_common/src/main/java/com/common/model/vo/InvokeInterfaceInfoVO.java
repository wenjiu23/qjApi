package com.common.model.vo;

import com.common.model.entity.InterfaceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InvokeInterfaceInfoVO extends InterfaceInfo {

    /**
     * 接口调用次数
     */
    private Integer invokeNum;

    private static final long serialVersionUID = 1L;
}