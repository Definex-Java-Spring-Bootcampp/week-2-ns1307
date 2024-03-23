# 5. Docker komutlarını örneklerle açıklayın.
Docker, uygulamaları ve altyapıyı tutarlı ve taşınabilir bir şekilde oluşturmak, geliştirmek ve dağıtmak için kullanılan bir platformdur. Bu platformda birçok komut bulunur. En sık kullanılanlardan bazılarını ve örnekleri şunlardır:
### Temel Komutlar:
```bash
docker version
```
Docker'ın kurulu sürümünü gösterir.

---
```bash
docker search
```
Docker Hub'da bulunan imajları arar. Örneğin: 
```bash
docker search nginx
``` 
---
```bash
docker pull
``` 
Docker Hub'dan bir imajı indirir. Örneğin: docker pull nginx
```bash
docker pull nginx
``` 
---
```bash
docker images
``` 
Yerel makinede bulunan imajları listeler.

---
```bash
docker run
``` 

Bir imajdan bir konteyner oluşturur ve çalıştırır. Örneğin: 
```bash
docker run nginx
``` 
---
```bash
docker ps
``` 
Çalışan konteynerleri listeler.

---
```bash
docker stop
``` 
Bir konteyneri durdurur. Örneğin: 
```bash
docker stop nginx
``` 
---
```bash
docker rm
``` 
Bir konteyneri siler. Örneğin: 
```bash
docker rm nginx
```
---
### Gelişmiş Komutlar:
```bash
docker build
```
Bir Dockerfile'dan bir imaj oluşturur.

---
```bash
docker push
```
Bir imajı Docker Hub'a yükler.

---
```bash
docker login
```
Docker Hub'a giriş yapar.

---
```bash
docker exec
```
Bir konteynerin içinde komut çalıştırır. Örneğin: 
```bash
docker exec nginx ls
```
---
```bash
docker logs
```
Bir konteynerin günlüklerini gösterir. Örneğin: 
```bash
docker logs nginx
```
---
```bash
docker network
```
Docker ağlarını yönetir.

---
```bash
docker volume
```
Docker veri birimlerini yönetir.
