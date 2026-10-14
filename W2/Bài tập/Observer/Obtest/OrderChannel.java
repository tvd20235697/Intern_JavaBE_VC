import java.util.ArrayList;
import java.util.List;

public class OrderChannel {
    private List<Observer> orders= new ArrayList<>();

    public void addObserver(Observer obsv){
        orders.add(obsv);
    }

    public void removeObserver(Observer obsv){
        orders.add(obsv);
    }

    public void notifyObservers(){
        for(Observer obsv: orders){
            obsv.update();
        }
    }
}
