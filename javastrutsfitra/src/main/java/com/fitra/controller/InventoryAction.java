package com.fitra.controller;

import com.fitra.entity.Inventory;
import com.fitra.service.InventoryService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

@Namespace("/inventory")
@ParentPackage("struts-default")
@Results({
    @Result(name = "success", location = "/inventory/inventoryList.jsp"),
    @Result(name = "input", location = "/inventory/inventoryForm.jsp"),
    @Result(name = "error", location = "/error.jsp")
})
public class InventoryAction extends ActionSupport {
    
    private InventoryService inventoryService;
    private Inventory inventory;
    private int inventoryId;

    // Constructor, getters, and setters for inventoryService, inventory, and inventoryId

    @Action(value = "saveInventory", interceptorRefs = @InterceptorRef("defaultStack"))
    public String save() {
        try {
            if (inventory.getType().equals("T")) {
                inventoryService.topUpInventory(inventory);
            } else if (inventory.getType().equals("W")) {
                inventoryService.withdrawInventory(inventory);
            }
            return SUCCESS;
        } catch (Exception e) {
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "deleteInventory", interceptorRefs = @InterceptorRef("defaultStack"))
    public String delete() {
        try {
            inventoryService.deleteInventory(inventoryId);
            return SUCCESS;
        } catch (Exception e) {
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    // Other methods: list(), edit(), showAddForm(), etc.

}
