package org.example.xindcodespring.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xind
 * @Date 2025/10/2
 **/
@Data
public class AppDeployRequest implements Serializable {

    /**
     * 应用 id
     */
    private Long appId;

    private static final long serialVersionUID = 1L;
}

