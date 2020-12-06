package top.summersea.controller;

import com.alibaba.fastjson.JSONObject;
import top.summersea.service.GoodsService;
import top.summersea.service.impl.GoodsServiceImpl;
import top.summersea.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet(name = "GoodsServlet", urlPatterns = "/goods/*")
public class GoodsServlet extends HttpServlet {
    private GoodsService goodsService;

    @Override
    public void init() throws ServletException {
        super.init();
        goodsService = new GoodsServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取方法路径
        String methodPath = request.getPathInfo();
        String methodName = methodPath.substring(1);
        Class<?>[] classes = new Class[]{HttpServletRequest.class, HttpServletResponse.class};
        try {
            MethodFinder.findAndInvokeMethod(this, methodName, classes, request, response);
        } catch (NoSuchMethodException e) {
            response.setStatus(404);
            response.sendError(404, "找不到对应方法");
            e.printStackTrace();
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取goodsList
     *
     * @param request
     * @param response
     */
    private void getGoodsList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsName = request.getParameter("goodsName");

        List<Object> goodsList;
        if (null == goodsName || "".equals(goodsName)) {
            goodsList = goodsService.getGoodsList();
        } else {
            goodsList = goodsService.getGoodsList(goodsName);
        }

        response.setContentType("application/json;charset=utf-8");
        JSONObject jsonObject = JSONUtil.createSuccessJSONObject();
        jsonObject.put("data", goodsList);
        response.getWriter().print(jsonObject.toJSONString());
    }
}
