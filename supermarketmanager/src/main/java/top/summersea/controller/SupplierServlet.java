package top.summersea.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import top.summersea.entity.Supplier;
import top.summersea.service.SupplierService;
import top.summersea.service.impl.SupplierServiceImpl;
import top.summersea.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "SupplierServlet", urlPatterns = "/supplier/*")
public class SupplierServlet extends HttpServlet {
    private SupplierService supplierService;

    @Override
    public void init() throws ServletException {
        super.init();
        supplierService = new SupplierServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取方法路径
        String methodPath = request.getPathInfo();
        String methodName = methodPath.substring(1);
        try {
            // 找到对应方法
            Method declaredMethod = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(this, request, response);
        } catch (NoSuchMethodException e) {
            response.setStatus(404);
            response.sendError(404, "找不到对应方法");
            e.printStackTrace();
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void toSupplierManagerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String supplierName = request.getParameter("supplierName");
        List<Supplier> supplierList;
        if (null == supplierName || "".equals(supplierName)) {
            supplierList = supplierService.getAllSupplier();
        } else {
            supplierList = supplierService.getAllSupplier(supplierName);
        }


        JSONObject jsonObject = JSONUtil.createSuccessJSONObject();
        jsonObject.put("data", supplierList);

        response.getWriter().print(JSON.toJSONString(jsonObject, SerializerFeature.WriteNullStringAsEmpty));
    }

    private void isSupplierIdExistent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        String supplierId = request.getParameter("supplierId");
        boolean supplierExistent = supplierService.isSupplierExistent(supplierId);

        JSONObject successJSONObject = JSONUtil.createSuccessJSONObject();
        successJSONObject.put("isExistent", supplierExistent);
        response.getWriter().print(successJSONObject.toJSONString());
    }

    private void registerSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, IllegalAccessException {


        Supplier supplier = DataLoader.loadClassByRequest(Supplier.class, request);

        boolean b = supplierService.registerSupplier(supplier);

        response.setContentType("application/json;charset=utf-8");
        JSONObject successJSONObject = JSONUtil.createSuccessJSONObject();
        successJSONObject.put("insertState", b);
        response.getWriter().print(successJSONObject.toJSONString());
    }

    private void updateSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, IllegalAccessException {

        Supplier supplier = DataLoader.loadClassByRequest(Supplier.class, request);

        boolean b = supplierService.updateSupplier(supplier);

        response.setContentType("application/json;charset=utf-8");
        JSONObject successJSONObject = JSONUtil.createSuccessJSONObject();
        successJSONObject.put("updateState", b);
        response.getWriter().print(successJSONObject.toJSONString());
    }

    private void deleteSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String supplierId = request.getParameter("supplierId");

        boolean b = supplierService.deleteSupplier(supplierId);
        response.setContentType("application/json;charset=utf-8");
        JSONObject successJSONObject = JSONUtil.createSuccessJSONObject();
        successJSONObject.put("deleteState", b);
        response.getWriter().print(successJSONObject.toJSONString());
    }

    private void getAllSupplierName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        List<Object> allSupplierName = supplierService.getAllSupplierName();
        JSONObject jsonObject = JSONUtil.createSuccessJSONObject();
        jsonObject.put("data", allSupplierName);

        response.getWriter().print(jsonObject.toJSONString());
    }
}
