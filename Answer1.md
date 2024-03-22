# 1- Senkron ve Asenkron iletişim nedir örneklerle açıklayın?
Yazılımda senkron ve asenkron iletişim, veri alışverişi yapma şekillerini tanımlar ve her ikisi de farklı durumlar için uygun çözümler sunar.

## Senkron İletişim
Senkron iletişim, bir işlemin tamamlanmasını bekleyen bloklayıcı bir iletişim türüdür. Bir istek gönderildiğinde, yanıt gelene kadar bekler ve bu süreç boyunca hiçbir başka işlem yapmaz. Bu, iletişimin adım adım ve düzenli bir şekilde gerçekleştiği anlamına gelir. Java Örneği: Senkron iletişim örneği olarak, bir web servisinden veri çekme işlemi verilebilir. Aşağıdaki kod, bir HTTP GET isteği gönderir ve yanıtı bekler:
```java
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SyncExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://example.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        
        // İstek gönderildi ve yanıt bekleniyor
        int status = con.getResponseCode();
        System.out.println("Response Code: " + status);
        
        // İşlem burada yanıt alındıktan sonra devam eder
        con.disconnect();
    }
}
```
Bu örnekte, getResponseCode() metodunun çağrılması senkron bir işlemdir; yanıt gelene kadar kodun geri kalanı bloklanır.
## Asenkron İletişim
Asenkron iletişimde, bir mesaj gönderilir ve cevap anında geri dönmeden işlenir. Bu, başka işlemlerin mesaj beklerken devreye girmesini sağlar. Mesaj gönderildikten sonra uygulama, yanıt almadan önce diğer işlemlere geçer. Yanıt geldiğinde bir geri çağırma işlevi kullanılarak işlenir. Java'da asenkron işlemler genellikle CompletableFuture veya geri çağırma işlevleriyle uygulanır. Aşağıdaki örnekte CompletableFuture kullanılarak asenkron bir HTTP GET isteği gösterilmiştir:
```java
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class AsyncExample {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://example.com"))
                .build();
        
        // Asenkron istek gönderimi
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join(); // Bu noktada, yanıt gelene kadar beklemek yerine diğer işlemlere devam edilebilir
    }
}
```
Bu durumda "sendAsync" yöntemi, yanıt alınana kadar programın çalışmasına devam etmesini sağlayan asenkron bir istek yapar. Yanıt alındığında "thenApply" ve "thenAccept" yöntemleri ile işlenir.

Senkron ve asenkron iletişim arasındaki kilit fark, "bekleme" durumundadır. Senkron iletişim, yanıt gelmeden sonraki adıma geçerken, asenkron iletişimde yanıt gelmeden önce işlemler devam edebilir. Bu nedenle asenkron iletişim genellikle daha verimli kaynak kullanımı ve daha hızlı tepki süreleri sağlar.