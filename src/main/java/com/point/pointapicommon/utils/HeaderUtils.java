package com.point.pointapicommon.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.util.HashMap;
import java.util.Map;

/**
 * 签名工具
 */
public class HeaderUtils {
    /**
     * 根据请求体body和accessKey，secretKey生成请求头
     *
     * @param body
     * @param accessKey
     * @param secretKey
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @Author point
     * @Date 14:06 2023/7/26
     **/
    public static Map<String, String> getHeaderMap(String body, String accessKey, String secretKey) {
        // 创建返回的header
        Map<String, String> header = new HashMap<>();

        // 加入各种参数
        header.put("accessKey", accessKey);
        header.put("nonce", RandomUtil.randomNumbers(6));
        header.put("body", body);
        header.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        header.put("sign", getSign(body, secretKey));

        // 将header返回
        return header;
    }

    /**
     * 生成签名
     *
     * @param body
     * @param secretKey
     * @return
     */
    public static String getSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey;
        return md5.digestHex(content);
    }
}
