# Tracing Demo

## Create Docker Image

```shell
mvn package
docker build -t boyone/liveproject-tracing:v1.1 .
```

> 1.1, 1.2

## Run EShop

```shell
docker run -d --name demo -p 80:8080 boyone/liveproject-tracing:v1.1
```

## Run Jaeger

```shell
docker run -d --name jaeger -p 14268:14268 -p 16686:16686 jaegertracing/all-in-one:1.26
```

## Call checkout

```shell
curl localhost/checkout
```

## Open Jaeger Dashboard

```shell
open localhost:16686
```