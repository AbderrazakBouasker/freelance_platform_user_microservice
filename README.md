# freelance_platform_user_microservice

## Docker build instructions

### Create a docker network if it doesn't exist
```bash
docker network create freelance-platform
```

### Build the docker image
```bash
docker build -t user-service .
```

### Run the docker image
```bash
docker run -p 9090:8080 --name user-service --network freelance-platform user-service
```

### Test the service
```bash
curl http://localhost:9090/users/hello
```

