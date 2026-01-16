package org.example.xindcodespring.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import org.example.xindcodespring.model.entity.App;
import org.example.xindcodespring.model.dto.app.AppQueryRequest;
import org.example.xindcodespring.model.entity.User;
import org.example.xindcodespring.model.vo.app.AppVO;
import reactor.core.publisher.Flux;

import java.io.Serializable;
import java.util.List;

/**
 * 应用 服务层。
 *
 * @author xind
 */
public interface AppService extends IService<App> {

    AppVO getAppVO(App app);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    List<AppVO> getAppVOList(List<App> appList);

    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    String deployApp(Long appId, User loginUser);

    boolean removeById(Serializable id);
}
