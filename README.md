# freelance_platform_user_microservice

## Docker build instructions

### Build the docker image
```bash
docker build -t user-service .
```

### Run the docker image
```bash
docker run -p 8080:8080 user-service
```

### Test the service
```bash
curl http://localhost:8080/users/hello
```

