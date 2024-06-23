package com.fitra.controller;

import com.fitra.entity.Order;
import com.fitra.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

@Namespace("/order")
@ParentPackage("struts-default")
@Results({
    @Result(name = "success", location = "/order/orderList.jsp"),
    @Result(name = "input", location = "/order/orderForm.jsp"),
    @Result(name = "error", location = "/error.jsp")
})
public class OrderAction extends ActionSupport {
    
    private OrderService orderService;
    private Order order;
    private String orderNo;

    // Constructor, getters, and setters for orderService, order, and orderNo

    @Action(value = "saveOrder", interceptorRefs = @InterceptorRef("defaultStack"))
    public String save() {
        try {
            orderService.placeOrder(order);
            return SUCCESS;
        } catch (Exception e) {
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "deleteOrder", interceptorRefs = @InterceptorRef("defaultStack"))
    public String delete() {
        try {
            orderService.deleteOrder(orderNo);
            return SUCCESS;
        } catch (Exception e) {
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    // Other methods: list(), edit(), showAddForm(), etc.

}
