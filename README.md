# Primeira REST Api com Vert.x 3

API REST Simples com o uso do Vert.x 3 e as dependências do CORE e WEB.


## Build

Execute o seguinte comando no terminal:

```
mvn clean package
```


## Para Rodar a aplicação execute o seguinte comando:


```
Compile e execute a classe Run.java
```
OU

```
java -jar target/vertxapi-0.0.1-SNAPSHOT-RELEASE.jar
```


Pronto! Agora abra o navegador na seguinte URL: http://localhost:9000.


## Executando os Endpoints:

Listar todos os contatos:

```
http://localhost:9000/api/contato GET
```


```
Adiciona um contato:
http://localhost:9000/api/contato POST
```
Consulta contato por id:

```
http://localhost:9000/api/contato/id GET
```
Alterar contato:

```
http://localhost:9000/api/contato/id PUT
```

Deletar contato:

```
http://localhost:9000/api/contato/id DELETE
```

Exmplo de Body

```
{
   "nome":"Luiz Evangelista",
   "telefone":"(13)3222-2222"
}
```
