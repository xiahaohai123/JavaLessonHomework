package top.summersea.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @PackageName: top.summersea.util
 * @ClassName: JSONUtil
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/4 11:18
 */
public class JSONUtil {
    public static JSONObject createSuccessJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 20000);
        return jsonObject;
    }

    public static JSONObject createFailedJSONObejct() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 40000);
        return jsonObject;
    }
}
