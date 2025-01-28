## kafka-basics

### Setup loca

1. Subir servidor conductor + kafka
```shell
docker compose up 
```

2. criar topico

```shell
kafka-topics.sh --bootstrap-server localhost:8080 --topic <topic-name> --partitions 3 --create
```

