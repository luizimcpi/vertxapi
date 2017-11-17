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
http://localhost:9000/api/contatos GET
```
Adicionar contato:

```
http://localhost:9000/api/contatos POST
```
Consultar contato:

```
http://localhost:9000/api/contatos/id GET
```
Alterar contato:

```
http://localhost:9000/api/contatos/id PUT
```

Deletar contato:

```
http://localhost:9000/api/contatos/id DELETE
```

Exmplo de Body

```
{
   "nome":"Luiz Evangelista",
   "telefone":"(13)3222-2222"
}
```
