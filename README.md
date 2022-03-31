# REST API para sistema de Catalogo Veiculos

## Path's para requisição:

api/carros/{id} - **GET** - Irá retornar o objeto que será o carro de acordo com seu id salvo no banco de dados

api/carros/ - **POST** - Irá salvar o objeto no banco

api/carros/ - **GET** - Irá retornar uma lista paginada com todos os objetos salvos no banco de dados

api/carros/nome/{nome} - **GET** - Irá retornar uma lista paginada com todos objetos com determinado nome passado como parâmetro no path

api/carros/modelo/{modelo} - **GET** - Irá retornar uma lista paginada com todos objetos com determinado modelo passado como parâmetro no path

api/carros/marca/{marca} - **GET** - Irá retornar uma lista paginada com todos objetos com determinado marca passado como parâmetro no path

api/carros/{id} - **PUT** - Irá alterar o objeto de id correspondente no banco de dados, assim o retornando após a alteração

api/carros/{id} - **DELETE** - Irá deletar o objeto de id correspondente no banco de dados.

### POST e PUT (passar id no path):

```
{
  "nome":"BMW",
  "marca":"BMW",
  "modelo":"BMW m2",
  "foto":"https://imgur.com/fqqfihwfi"
}
```

### Todas as requisições requisitam token JWT

/login - **POST** - requisição para gerar o token e liberar as demais requisições à API

#### O token é gerado no header da requisição, a ferramenta recomendada para recuperar o token e realizar as requisições é o Postman.

```
{
  "username":"admin",
  "password":"password"
}
```
