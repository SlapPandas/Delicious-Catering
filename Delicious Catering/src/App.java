import java.util.*;

import BLL.*;
import DAL.*;
import java.text.*;

public class App {
    public static void main(String[] args) throws Exception {
        OrderData the = new OrderData();
        List<Order> myOrder = the.ReadOrderList();
        the.UpdateOrderCancelation(myOrder.get(0).getOrdernr(), myOrder.get(0).getClientName(), myOrder.get(0).getEventAddress(), myOrder.get(0).getEventType(), myOrder.get(0).getDecoration(), myOrder.get(0).getTheme(), myOrder.get(0).getEventDate(), myOrder.get(0).getFood(), myOrder.get(0).getBeverages(), myOrder.get(0).getSpecialFoodRequest(), myOrder.get(0).getAdultFood_TotalCost(), myOrder.get(0).getChildFood_TotalCost(), myOrder.get(0).getBevarages_TotalCost(), myOrder.get(0).getDecoration_TotalCost(), myOrder.get(0).getAddOns(), myOrder.get(0).getAddOns_TotalCost(), myOrder.get(0).getCovidEquipment(), myOrder.get(0).getCovidEquip_TotalCost(), myOrder.get(0).getCancellation(), myOrder.get(0).getTotalCost(), myOrder.get(0).getDepositDue(), myOrder.get(0).getDepositPaid(), myOrder.get(0).getRemainingAmount(), myOrder.get(0).getChildrenAttending(), myOrder.get(0).getAdultsAttending(), false);
        
    }
}
