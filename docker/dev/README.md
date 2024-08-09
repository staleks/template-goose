# Starting

## Debug mode (development mode)

1. Start MySQL as Docker Container
```
$ docker-compose -f docker-compose.yaml up -d
```

2. Start App from IntelliJ IDE, with `--spring.profiles.active=dev`

3. Once debugging is finished, then stop & remove Docker containers

```
$ docker-compose -f docker-compose.yaml down
```

## Full Docker mode for development (with docker-compose)

1. Use full docker-compose file to start MySQL and Spring Boot Application

```
$ docker-compose -f docker-compose.all.yaml up -d
```

2. Do manual trigger on cURL

```
$ curl http://localhost:8080/geo/v1/countries
```

You should get response

```
{
    "items":[
        {
            "id":1,
            "createdBy":"admin@template-goose.com",
            "createdDate":"2024-06-11T12:00:00Z",
            "lastModifiedBy":"admin@template-goose.com",
            "lastModifiedDate":"2024-06-11T12:00:00Z",
            "name":"United States Of America",
            "alpha2":"US",
            "alpha3":"USA",
            "visible":true,
            "deleted":false
        },
        {
            "id":2,
            "createdBy":"admin@template-goose.com",
            "createdDate":"2024-06-11T12:00:00Z",
            "lastModifiedBy":"admin@template-goose.com",
            "lastModifiedDate":"2024-06-11T12:00:00Z",
            "name":"Canada",
            "alpha2":"CA",
            "alpha3":"CAN",
            "visible":true,
            "deleted":false
        }
    ],
    "totalPages":1,
    "page":1,
    "size":2,
    "total":2
}
```

3. Once debugging is done, then stop & remove Docker containers

```
$ docker-compose -f docker-compose.all.yaml down
```


