import java.util.concurrent.CompletableFuture;

public class CFuture {
    public static void main(String[] args){
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println("Tao la Duy");
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Tao");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "duy").thenApply(name -> name.toUpperCase());
        CompletableFuture<String> f4 = f2.thenCombine(f3,(name1, name2) -> name1 + " la " + name2);
        CompletableFuture<String> f5 = getUser().thenCompose(name -> getOrder(name));
        System.out.println(f2.join());
        System.out.println(f4.join());
        System.out.println(f5.join());
        f1.join();

        CompletableFuture<String> user = getUserAsync();
        CompletableFuture<String> order = getOrderAsync();
        CompletableFuture<String> noti = getNotificationAsync();
        CompletableFuture<Void> all = CompletableFuture.allOf(
            user,
            order,
            noti
        );
        all.thenRun(()->{
            String u = user.join();
            String o = order.join();
            String n = noti.join();
            System.out.println( u + " " + o + " " + n);
        });
        CompletableFuture<String> future = CompletableFuture.<String>supplyAsync(() -> {throw new RuntimeException("Error");}).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return "...";
        });

        System.out.println(future.join());
    }
    public static CompletableFuture<String> getUser() {
        return CompletableFuture.supplyAsync(() -> "Duy");
    }
    public static CompletableFuture<String> getOrder(String name){
        return CompletableFuture.supplyAsync(() -> "Order of " + name);
    }

    public static CompletableFuture<String> getUserAsync(){
        return CompletableFuture.supplyAsync(() -> "Duy");
    }
    public static CompletableFuture<String> getOrderAsync(){
        return CompletableFuture.supplyAsync(() -> "Order 1");
    }
    public static CompletableFuture<String> getNotificationAsync(){
        return CompletableFuture.supplyAsync(() -> "Notify");
    }
}
