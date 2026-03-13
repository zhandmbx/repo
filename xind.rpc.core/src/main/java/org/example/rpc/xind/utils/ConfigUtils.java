package org.example.rpc.xind.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import cn.hutool.setting.yaml.YamlUtil;

import java.io.InputStream;
import java.util.Map;

/**
 * 配置工具类
 */
public class ConfigUtils {

    /**
     * 加载配置对象
     *
     * @param tClass
     * @param prefix
     * @param <T>
     * @return
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix) {
        return loadConfig(tClass, prefix, "");
    }

    /**
     * 加载配置对象，支持区分环境
     *
     * @param tClass
     * @param prefix
     * @param environment
     * @param <T>
     * @return
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix, String environment) {
        StringBuilder configFileBuilder = new StringBuilder("application");
//        if (StrUtil.isNotBlank(environment)) {
//            configFileBuilder.append("-").append(environment);
//        }
//        configFileBuilder.append(".properties");
//        Props props = new Props(configFileBuilder.toString());
//        return props.toBean(tClass, prefix);
        if (StrUtil.isNotBlank(environment)) {
            configFileBuilder.append("-").append(environment);
        }

        // --- 1. 尝试加载 YML/YAML 配置 ---
        // 先尝试 .yml
        String ymlConfig = configFileBuilder.toString() + ".yml";
        InputStream ymlStream = ConfigUtils.class.getClassLoader().getResourceAsStream(ymlConfig);
        if (ymlStream != null) {
            try {
                // 使用 YamlUtil 将 YAML 文件解析为 Map
                Map<String, Object> ymlMap = YamlUtil.load(ymlStream, Map.class);
                // 从 Map 中提取指定前缀的配置并转换为 Bean
                Map<String, Object> configMap = (Map<String, Object>) ymlMap.get(prefix);
                if (configMap != null) {
                    return BeanUtil.toBean(configMap, tClass);
                }
            } catch (Exception e) {
                // 解析失败或类型转换失败，尝试下一个
                e.printStackTrace();
                System.out.println("降级处理。。。");
            }
        }

        // 如果 .yml 没找到或解析失败，尝试 .yaml
        if (ymlStream == null) {
            String yamlConfig = configFileBuilder.toString() + ".yaml";
            InputStream yamlStream = ConfigUtils.class.getClassLoader().getResourceAsStream(yamlConfig);
            if (yamlStream != null) {
                try {
                    Map<String, Object> yamlMap = YamlUtil.load(yamlStream, Map.class);
                    Map<String, Object> configMap = (Map<String, Object>) yamlMap.get(prefix);
                    if (configMap != null) {
                        return BeanUtil.toBean(configMap, tClass);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // --- 2. 尝试加载 PROPERTIES 配置 ---
        // 如果 YML/YAML 都失败了，回退到原来的 Properties 逻辑
        String propertiesConfig = configFileBuilder.toString() + ".properties";
        InputStream propertiesStream = ConfigUtils.class.getClassLoader().getResourceAsStream(propertiesConfig);
        if (propertiesStream != null) {
            Props props = new Props(propertiesConfig);
            return props.toBean(tClass, prefix);
        }

        // --- 3. 如果所有配置文件都不存在，返回 null 或抛出异常 ---
        // 根据你的业务需求决定是返回 null 还是抛出异常
        return null;
    }
}
