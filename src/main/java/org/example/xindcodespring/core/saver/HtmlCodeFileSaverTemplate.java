package org.example.xindcodespring.core.saver;

import cn.hutool.core.util.StrUtil;
import org.example.xindcodespring.ai.model.HtmlCodeResult;
import org.example.xindcodespring.ai.model.enums.CodeGenTypeEnum;
import org.example.xindcodespring.exception.BusinessException;
import org.example.xindcodespring.exception.ErrorCode;

/**
 * HTML代码文件保存器
 * @author xind
 * @Date 2025/9/21
 **/

public class HtmlCodeFileSaverTemplate extends CodeFileSaverTemplate<HtmlCodeResult> {

    @Override
    protected CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.HTML;
    }

    @Override
    protected void saveFiles(HtmlCodeResult result, String baseDirPath) {
        // 保存 HTML 文件
        writeToFile(baseDirPath, "index.html", result.getHtmlCode());
    }

    @Override
    protected void validateInput(HtmlCodeResult result) {
        super.validateInput(result);
        // HTML 代码不能为空
        if (StrUtil.isBlank(result.getHtmlCode())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML代码内容不能为空");
        }
    }
}

