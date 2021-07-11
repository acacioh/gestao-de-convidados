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