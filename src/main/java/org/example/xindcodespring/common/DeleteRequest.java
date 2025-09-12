package org.example.xindcodespring.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xind
 * @Date 2025/9/12
 **/
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}
