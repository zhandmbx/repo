package org.example.xindcodespring.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xind
 * @Date 2025/9/30
 **/
@Data
public class AppAddRequest implements Serializable {

    /**
     * 应用初始化的 prompt
     */
    private String initPrompt;

    private static final long serialVersionUID = 1L;
}

