# 8. Hibernate, JPA, Spring Data framework’lerini örneklerle açıklayın.
### Hibernate
Hibernate, Java'da oluşturulmuş ve veritabanı nesne eşlemesinde (ORM) kullanılan bir açık kaynaklı yazılım kütüphanesidir. Veritabanınız ile nesneleriniz arasında bir bağlantı kurarak veritabanı sorgularını ve işlemlerini nesne odaklı bir arayüz aracılığıyla basitleştirir.

```java
@Entity
public class Kullanici {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ad;
    private String soyad;
    // getter ve setter metodları
}

// Kullanımı
Session session = sessionFactory.openSession();
session.beginTransaction();
Kullanici kullanici = new Kullanici();
kullanici.setAd("Ali");
kullanici.setSoyad("Yılmaz");
session.save(kullanici);
session.getTransaction().commit();
session.close();
```
### JPA (Java Persistence API)
JPA, Java uygulamalarında veritabanıyla etkileşim kurmak için ortak bir arayüzler ve açıklamalar kümesi sunar. ORM (Nesne İlişkisel Eşleme) çözümlerini kullanan geliştiriciler, Hibernate gibi farklı ORM araçlarını kolayca değiştirebilirler. JPA, uygulama ve veritabanı arasındaki bağlantıyı yönetmeyi basitleştirerek geliştiricilerin veritabanıyla etkileşim kurmasını kolaylaştırır.
```java
@Entity
public class Kitap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ad;
    // getter ve setter metodları
}

// Kullanımı
EntityManager em = entityManagerFactory.createEntityManager();
em.getTransaction().begin();
Kitap kitap = new Kitap();
kitap.setAd("Sefiller");
em.persist(kitap);
em.getTransaction().commit();
em.close();
```

### Spring Data
Spring Data, Spring çerçevesinde veri erişimini kolaylaştırmaya odaklanan bir projedir. Veritabanı teknolojileri arasında JPA, MongoDB ve Neo4J için ortak bir erişim modeli sunar. Bu model, geliştiricilerin "repository" denilen arabirimler kullanarak veritabanı işlemlerini sorunsuz bir şekilde gerçekleştirmesine olanak tanır.
```java
public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {
    List<Kullanici> findBySoyad(String soyad);
}

// Kullanımı
@Autowired
private KullaniciRepository kullaniciRepository;

public void kullaniciEkle() {
    Kullanici kullanici = new Kullanici();
    kullanici.setAd("Mehmet");
    kullanici.setSoyad("Kara");
    kullaniciRepository.save(kullanici);
}

public List<Kullanici> kullaniciBulBySoyad(String soyad) {
    return kullaniciRepository.findBySoyad(soyad);
}
```
