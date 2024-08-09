# Template Documentation

## Where to find alphabet animal images

+ Alphabetimals [Animals starts with A](https://alphabetimals.com/animal-dictionary/animals-that-start-with-a/)
+ Alphabetimals [Animals starts with B](https://alphabetimals.com/animal-dictionary/animals-that-start-with-b/)
+ Alphabetimals [Animals starts with C](https://alphabetimals.com/animal-dictionary/animals-that-start-with-c/)
+ Alphabetimals [Animals starts with D](https://alphabetimals.com/animal-dictionary/animals-that-start-with-d/)
+ Alphabetimals [Animals starts with E](https://alphabetimals.com/animal-dictionary/animals-that-start-with-e/)
+ Alphabetimals [Animals starts with F](https://alphabetimals.com/animal-dictionary/animals-that-start-with-f/)
+ Alphabetimals [Animals starts with G](https://alphabetimals.com/animal-dictionary/animals-that-start-with-g/)


## missing table [country_seq]

Ako koristimo po default-u

```
  @Id
  @GeneratedValue
  private Long id;
```
onda ce MySQL traziti da se napravi i tabela `country_seq` koja treba da cuva auto-increment ID za Country.
Medjutim, ako stavimo


```
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
```

onda nece praviti.

Ovo treba istraziti, sta je default strategy a sta joj ovo za `GenerationType.IDENTITY` radi?


## How to access application?

0. Start MySQL in docker > dev > docker-compose.yaml

1. Start TemplateGooseApplication [dev] mode
   --spring.profiles.active=dev

2. Go to: localhost:8080



