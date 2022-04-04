

import java.io.Serializable;
import java.util.ArrayList;

public class SaveState implements Serializable{
    ArrayList<Order> orderList;
    ArrayList<User> userList;
    ArrayList<MenuItem> menuList;
    int nextOrderNumber;
    int currentUserIDToAssign;
    int currentCouponNum;

    public SaveState(ArrayList<Order> newOrderList, ArrayList<User> newUserList, ArrayList<MenuItem> newMenuList, int newNextOrderNumber, int newCurrentUserIDToAssign, int newCurrentCouponNum){
        this.orderList = newOrderList;
        this.userList = newUserList;
        this.menuList = newMenuList;
        this.nextOrderNumber = newNextOrderNumber;
        this.currentUserIDToAssign = newCurrentUserIDToAssign;
        this.currentCouponNum = newCurrentCouponNum;
    }

    public void setOrderList(ArrayList<Order> newOrderList){
        this.orderList = newOrderList;
        return;
    }

    public void setMenuList(ArrayList<MenuItem> newMenuList){
        this.menuList = newMenuList;
        return;
    }

    public void setUserList(ArrayList<User> newUserList){
        this.userList = newUserList;
        return;
    }

    public void setNextOrderNumber(int newNextOrderNumber){
        this.nextOrderNumber = newNextOrderNumber;
        return;
    }

    public void setCurrentUserIDtoAssign(int newCurrentUserIDToAssign){
        this.currentUserIDToAssign = newCurrentUserIDToAssign;
        return;
    }
    public void setCurrentCouponNum(int newCurrentCouponNum){
        this.currentCouponNum = newCurrentCouponNum;
        return;
    }

    public ArrayList<Order> getOrderList(){
        
        return this.orderList;
    }

    public ArrayList<MenuItem> getMenuList(){
        return menuList;
    }

    public ArrayList<User> getUserList(){
        return userList;
        }

    public int getNextOrderNumber(){
        return nextOrderNumber;
    }

    public int getCurrentUserIDtoAssign(){
        return currentUserIDToAssign;
    }

    public int getCurrentCouponNum(){
        return currentCouponNum;
    }
}
