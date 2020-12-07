package top.summersea.controller;

import com.alibaba.fastjson.JSONObject;
import top.summersea.service.OrderService;
import top.summersea.service.impl.OrderServiceImpl;
import top.summersea.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/order/*")
public class OrderServlet extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
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

    private void getOrderList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsName = request.getParameter("goodsName");
        String supplierName = request.getParameter("supplierName");
        String hasPayedInString = request.getParameter("hasPayed");

        List<Object> orderList;
        if (goodsName == null) {
            orderList = orderService.getOrderList();
        } else {
            List<Boolean> hasPayedList = null;
            if (!"".equals(hasPayedInString)) {
                hasPayedList = new ArrayList<>();
                hasPayedList.add(Boolean.valueOf(hasPayedInString));
            }
            orderList = orderService.getOrderList(goodsName, hasPayedList, supplierName);
        }
        response.setContentType("application/json;charset=utf-8");
        JSONObject jsonObject = JSONUtil.createSuccessJSONObject();
        jsonObject.put("data", orderList);
        response.getWriter().print(jsonObject.toJSONString());
    }
}
