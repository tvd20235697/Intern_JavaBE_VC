import java.util.ArrayList;
import java.util.List;

public class YoutobeChannel {
    private List<observer> subcribers= new ArrayList<>();

    public void subcribe(observer obsv){
        subcribers.add(obsv);
    }

    public void unsubcribe(observer obsv){
        subcribers.remove(obsv);
    }

    public void notifySubscribers(String message){
        for(observer obsv: subcribers){
            obsv.update(message);
        }
    }

    public void printSubscribers(){
        System.out.println("List of Subscribers:");
        for(observer obsv: subcribers){
            if(obsv instanceof subcriber){
                subcriber sub = (subcriber) obsv;
                System.out.println(sub.getName());
            }
        }
    }
}
