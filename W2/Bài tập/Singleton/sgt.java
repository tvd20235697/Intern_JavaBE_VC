public class sgt{
    private static sgt instance;

    private sgt(){
        System.out.println("sgt created");
    }

    public static synchronized sgt getInstance(){
        if(instance==null){
            instance= new sgt();
        }
        return instance;
    }
}