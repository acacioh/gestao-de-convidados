# gestao-de-convidados
Introdução Spring Boot

### Execução

- Execute com `./gradlew bootRun`

- visite o endereço `http://localhost:8080/swagger-ui/index.html`

- Credenciais:
```
username: user
password: password  
```

### Docker

- Construa um jar do projeto
`./gradlew build`

- Construa a imagem
`docker build -t acacioh/gestao-de-convidados .`
  
- Execute a imagem
`docker run -p 8080:8080 --name gestao-de-convidados acacioh/gestao-de-convidados:latest`

### Imagem publicada

Existe uma imagem publicada do projeto no JFrog. Execute com

`docker run --name gestao-de-convidados -p 8080:8080 acacioh.jfrog.io/acacioh-docker/gestao-de-convidados:latest`
  
### Publicação

Esse projeto está publicado no jfrog. Você pode executá-lo com

`docker run --name gestao-de-convidados -p 8080:8080 acacioh.jfrog.io/acacioh-docker/gestao-de-convidados:latest`

### Testes

Execute os testes com

`./gradlew test --info`
