
import java.util.ArrayList;
import java.util.List;

public class OrderChannel {
    private List<Order> orders = new ArrayList<>();
    public void addOrderService(Order order){
        orders.add(order);
    }
    public void removeOrderService(Order order){
        orders.remove(order);
    }
    public void updateOrderService(){
        for(Order order:orders){
            order.update();
        }
    }
}
