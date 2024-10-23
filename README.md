# template-goose

<p align="center" width="100%">
  <img width="33%" src="https://github.com/staleks/template-goose/blob/d895564a9cfe1aa68577f87b97724474ebf12c48/documentation/images/repository-logo.jpg"/>
</p>


Gradle, Java 21, Spring Boot, Hexagonal Architecture Template

## How to start application?

1. Go to `docker` folder and start local MySQL with the following script
```
$ docker compose -f docker-compose.yaml up -d
```

2. You have to define `Dev` profile for Spring as
```
--spring.profiles.active=dev
```
And then start application

3. Application will start on port :8080 and then you can trigger `GET` request to
```declarative
http://localhost:8080/geo/v1/countries
```

It will return JSON with Countries from DB


