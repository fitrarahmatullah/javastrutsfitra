package com.fitra.controller;

import com.fitra.entity.Item;
import com.fitra.service.ItemService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

@Namespace("/item")
@ParentPackage("struts-default")
@Results({
    @Result(name = "success", location = "/item/itemList.jsp"),
    @Result(name = "input", location = "/item/itemForm.jsp"),
    @Result(name = "error", location = "/error.jsp")
})
public class ItemAction extends ActionSupport {
    
    private ItemService itemService;
    private Item item;
    private int itemId;

    // Constructor, getters, and setters for itemService, item, and itemId

    @Action(value = "saveItem", interceptorRefs = @InterceptorRef("defaultStack"))
    public String save() {
        try {
            if (item.getId() == null) { // New item
                itemService.addItem(item);
            } else { // Existing item (edit)
                itemService.updateItem(item);
            }
            return SUCCESS;
        } catch (Exception e) {
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "deleteItem", interceptorRefs = @InterceptorRef("defaultStack"))
    public String delete() {
        try {
            itemService.deleteItem(itemId);
            return SUCCESS;
        } catch (Exception e) {
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    // Other methods: list(), edit(), showAddForm(), etc.

}
