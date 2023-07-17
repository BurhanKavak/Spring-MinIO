# :triangular_flag_on_post: MinIO

![](/images/minio.jpeg)

**AWS S3 gibi popüler bir bulut depolama hizmetine alternatif olarak Minio, açık kaynak kodlu ve kullanımı kolay bir nesne depolama sistemidir.**

**Minio, Amazon S3 uyumlu bir şekilde dosyalarınızı depolayabilir ve yüksek performans ve ölçeklenebilirlik sağlayarak büyük veri dosyalarını kolayca depolamanıza olanak tanır. Yedekleme, arşivleme, analiz, arama ve daha birçok işlem için kullanılabilir. Depolama alanınızı farklı bölümlere ayırarak, verilerinizi kolayca yönetebilirsiniz.**

**Ancak S3 araçlarının fiyatları ve özellikle finans sektöründeki regülasyonlar göz önüne alındığında, verilerin yurtdışında saklanabilmesi yasal olmadığından S3 gibi bulut tabanlı sistemleri kullanmak istemeyebilirsiniz. Bu noktada MinIO ile sunucularınızı oluşturup kullanabilirsiniz.**

**Java ile MinIO kullanmak için MinIO Java Client kütüphanesini kullanabilirsiniz. Bu kütüphane, Java programlarının MinIO sunucusuyla etkileşime geçmesini sağlar.**

**MinIO Java Client'ı kullanarak MinIO'ya dosya yüklemek, indirmek, silmek, listelemek ve diğer işlemleri gerçekleştirebilirsiniz. Kütüphane, MinIO sunucusuyla HTTP veya HTTPS üzerinden iletişim kurar ve MinIO tarafından sağlanan API'yi kullanır.**

## 🎯 **Neden ihtiyaç duyuldu?**

**Modern uygulamalar genellikle büyük miktarda veri işlemesi gerektirir. Geleneksel dosya sistemleri ve veritabanları bu ölçekte verileri depolamak ve hızlı bir şekilde erişmek için yeterli olmayabilir. Büyük ölçekli dağıtılmış sistemlerde verileri depolamak ve dağıtmak için ölçeklenebilir, dayanıklı ve hızlı bir depolama çözümüne ihtiyaç vardır.**

**MinIO'nun sunduğu nesne depolama modeli, verilerin parçalara bölünerek dağıtıldığı ve birden fazla sunucu üzerinde depolandığı bir yaklaşımı benimser. Bu sayede, verilerin paralel olarak erişilmesi ve yüksek performansın elde edilmesi sağlanır. Ayrıca, MinIO'nun sunucuları otomatik olarak ölçeklendirilebilir, böylece depolama kapasitesini artırma veya azaltma ihtiyacına göre kolayca ayarlanabilir.**

## 🎯 **Bucket'a veri yükleme (upload)**
![](/images/2.png)

## 🎯 **Buckettan veri indirme (download)**
![](/images/1.png)

## 🎯 **Bucket görünümü**
![](/images/3.png)

## :pushpin: MinIO bağımlılığı

```xml
<dependency>
    <groupId>io.minio</groupId>
    <artifactId>minio</artifactId>
    <version>8.5.4</version>
</dependency>
```

