## POC Spring Boot Customer/Cryptography
`<autor>`: Miguel Rodrigo Armas Abt

## 📋 Pre requisitos
> ⚙️ **Instalar herramientas**<br>
> `Java 17+`, `Maven 3.9.1+`, `Docker`, `Minikube`, `Kubectl`
>

## ▶️ Docker

⚙️ Crear imágenes
```shell
eval $(minikube docker-env --shell bash)
docker build -t miguelarmasabt/customer:v1.0.1 -f ./customer-v1/Dockerfile ./customer-v1
docker build -t miguelarmasabt/cryptography:v1.0.1 -f ./cryptography-v1/Dockerfile ./cryptography-v1
```

⚙️ Ver imágenes
```shell
docker image ls
```

⚙️ Ejecutar contenedores
```shell
docker run --rm -p 8093:8093 --name customer-v1  miguelarmasabt/customer:v1.0.1
docker run --rm -p 8094:8094 --name cryptography-v1  miguelarmasabt/cryptography:v1.0.1
```

## ▶️ Kubernetes

⚙️ Crear namespace
```shell
kubectl create namespace customers
```

⚙️ Aplicar manifiestos
```shell
kubectl apply -f ./cryptography-v1/k8s-cryptography-v1.yaml -n customers
kubectl apply -f ./customer-v1/k8s-customer-v1.yaml -n customers
```

⚙️ Eliminar orquestación
```shell
kubectl delete -f ./cryptography-v1/k8s-cryptography-v1.yaml -n customers
kubectl delete -f ./customer-v1/k8s-customer-v1.yaml -n customers
```

⚙️ Port-forward
```shell
kubectl port-forward <pod-id-customer> 8093:8093 -n customers
kubectl port-forward <pod-id-cryptography> 8094:8094 -n customers
```
