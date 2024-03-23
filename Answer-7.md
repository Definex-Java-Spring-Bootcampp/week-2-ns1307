# 7. API Gateway, Service Discovery, Load Balancer kavramlarını açıklayın.
## API Gateway
API Gateway, çoklu kaynaklardan API'leri tek bir merkezi noktada birleştirerek yöneten bir platformdur. Güvenli ve kolay ölçeklenebilir API'ler sunarak verimliliği artırmaya ve karmaşıklığı azaltmaya yardımcı olur.
#### API Gateway'in Avantajları:
* Tek Giriş Noktası: API Gateway, tüm API'leriniz için merkezi bir erişim noktası oluşturarak yönetim ve izleme kolaylığı sağlar. 
* Güvenlik: API Gateway, API'lerinizi yetkisiz kullanımdan korumak için kimlik doğrulama ve yetkilendirme özellikleri sunar. 
* Ölçeklenebilirlik: API Gateway, trafikteki artışları otomatik olarak yöneterek API'lerinizin taleplere uyum sağlamasını sağlar.
* İzleme: API Gateway, API kullanım verilerine erişim sağlayarak API performansının izlenmesini ve iyileştirilmesini mümkün kılar.

## Service Discovery
Service Discovery, bir ağdaki hizmetleri otomatik olarak bulma ve konumlandırma özelliğine sahip bir sistemdir.
#### Service Discovery'nin Avantajları:
* Otomatik Keşif: Service Discovery, hizmetleri manuel yapılandırmaya gerek kalmadan otomatik olarak bulur.
* Yüksek Kullanılabilirlik: Birden fazla hizmet örneği varsa, Hizmet Keşfi kullanıcıları her zaman erişilebilen bir hizmete yönlendirir.
* Yük Dengeleme: Service Discovery, gelen trafiği birden fazla hizmet örneği arasında otomatik olarak dağıtarak yük dengelemesini sağlar.
 

## Load Balancer
Load Balancer, gelen trafiği birden fazla sunucuya dağıtarak yükü dengeleyen bir sistemdir. Bu sistem; performansı artırarak, altyapıyı ölçeklendirerek ve yüksek kullanılabilirlik sağlayarak çeşitli avantajlar sunar.
#### Load Balancer'ın Avantajları:
* Geliştirilmiş Performans: Trafiğin farklı sunuculara dağıtılması, tek bir sunucu üzerindeki baskıyı azaltır ve genel performansı iyileştirir.
* Artırılmış Ölçeklenebilirlik: Load Balancer, gerektiğinde yeni sunucular ekleyerek veya kaldırarak altyapının sorunsuz bir şekilde ölçeklenmesini kolaylaştırır. 
* Yüksek Kullanılabilirlik: Birden fazla sunucu mevcut olduğunda, bir sunucu arızalanması durumunda bile hizmetin kesintisiz bir şekilde devam etmasını sağlar.

