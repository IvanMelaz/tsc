[![Build status](https://ca-group-solutions.visualstudio.com/4296_Demo/_apis/build/status/CA_R4296_BE_SPRINGBOOT_DEMO/cd)](https://ca-group-solutions.visualstudio.com/4296_Demo/_build/latest?definitionId=564)

# Cookbook

Applicazione **Spring Boot** di esempio

## Build locale - profilo di default

il profilo maven di default esegue la build ed i test unitari.

```bash
mvn clean install
```

per eseguire localmente l'applicazione eseguire:

```bash
mvn spring-boot:run
```

## Build docker

E' possibile eseguire l'applicazione su container docker, simulando le configurazioni previste dall'ambiente di collaudo.

Per eseguire l'applicazione su container eseguire la build con il profilo *docker*

```bash
mvn clean install -Pdocker
```

con questo profilo viene buildata l'applicazione ed eseguita localmente su Docker, emulando in ambiente locale le configurazioni previste sugli ambienti centralizzati.

la build docker prevede:

- il clone del repository di configurazione indicato nel pom
- la build dell'immagine docker
- l'esecuzione di eventuali test di integrazione.

### Esecuzione su container

se buildata con il profilo docker il componente può essere avviato su docker con il comando

```bash
mvn docker:start -Pdocker
```

e stoppata con il comando

```bash
mvn docker:stop -Pdocker
```

## API esposte

L'applicazione espone due API principali più una terza di monitoring:

- la prima API è un semplice "Hello World";
- la seconda API legge delle configurazioni dal file di properties e li restituisce;
- la terza API sfrutta Actuator per esporre una risorsa di "health check"

### Hello World

```bash
curl -X GET 'http://<endpoint>:8088/demo/v1/greetings?name=Pippo'
```

### Get Properties

```bash
curl -X GET http://<endpoint>:8088/demo/v1/properties
```

### Health Check

```bash
curl -X GET http://<endpoint>:8088/actuator/health
```

