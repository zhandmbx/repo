package org.example.xindcodespring.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xind
 * @Date 2025/9/30
 **/
@Data
public class AppUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 应用名称
     */
    private String appName;

    private static final long serialVersionUID = 1L;
}

