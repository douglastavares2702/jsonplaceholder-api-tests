# Automação de API - JSONPlaceholder

Repositório com automação de testes de API usando o framework: RestAssured e JUnit

> Testando e validando serviços REST em Java com 
> https://jsonplaceholder.typicode.com/

---
## Estrutura e Manutenção

Os testes automatizados utilizam POJOs para mapear as respostas da API,
desacoplando os testes do formato exato que o JSON retornar.

Os modelos estão preparados para lidar com possíveis mudanças de contrato,
como alteração de nomes de campos ou inclusão de atributos,
utilizando anotações do Jackson (`@JsonAlias`, `@JsonIgnoreProperties`),
permitindo que os testes não sofram impactos imediatos.

## Índice

- Pré-requisitos
- Configuração
- Instalação
- Como testar
- Testes com Postman
- Testes Manuais
- Relatórios de Teste
- Suporte

---

## Pré-requisitos

- [Instalar JDK 17](https://www.oracle.com/java/technologies/downloads/)
- [Instalar Maven 3.8+](https://maven.apache.org/install.html)
- [Instalar IntelliJ ou outra IDE](https://www.jetbrains.com/idea/download/)

## Configuração de pré-requisitos

> Certifique-se de que as seguintes ferramentas estejam instaladas e configuradas em sua máquina.

### Java: Verifique se o Java está disponível no terminal:
```bash
java -version
```

- Caso necessário, configure a variável de ambiente.

### Maven: Verifique se o Maven está disponível no terminal:
```bash
mvn -version
```

### Instalação do Java (Windows, linux e macOS)
- https://www.liquidweb.com/kb/how-to-install-java-on-ubuntu-windows-and-macos

### Instalação do Maven (Windows, linux e macOS)
- https://www.baeldung.com/install-maven-on-windows-linux-mac

Todas as dependências estão declaradas no arquivo pom.xml e serão baixadas
automaticamente ao executar os comandos Maven.

## Instalação:

> Clonar o projeto

- Clone este repositório para sua máquina local utilizando HTTPS ou SSH:

`git clone https://github.com/douglastavares2702/jsonplaceholder-api-tests.git`

>Em seguida, acesse a pasta do projeto:

`cd jsonplaceholder-api-tests`

## Como testar:
- mvn clean test

## Testes com Postman

Incluem validações automáticas por meio de scripts na aba Tests.

> Cenários positivos:
- GET /posts
- POST /posts
- GET /posts/{id}
- GET /users{id}
- PATH /posts/{id}

> Cenários negativos:
- GET /posts/{id}
- PATH /posts/{id}
- GET /users{id}

> Validações realizadas:
- Status code da resposta
- Campos obrigatórios
- Tipos de campos
- Validação do id ao consultar um post específico

## Execução com Newman

Pode ser executada via linha de comando utilizando o Newman:

```bash
newman run JSONPlaceholder_API.postman_collection.json \
  -e JSONPlaceholder.postman_environment.json \
  --reporters cli,junit  
```
---

## Testes Manuais

Os principais cenários de teste foram modelados de forma manual com o objetivo de permitir que qualquer pessoa consiga reproduzi-los, mesmo sem automação.

## Testes Positivos:

## Cenário 1 – Listar posts
- Valida quantidade de posts e presença de campos obrigatórios

Endpoint: GET /posts  
Resultado esperado:
- Status code: 200
- Retorno: 100 registros
- Campos: userId, id, title, body

## Cenário 2 – Criar posts
- A API JSONPlaceholder não salva dados permanentemente

Endpoint: GET /posts
- Status code: 201

## Cenário 3 – Buscar post por id válido
- Confirma que o post correto é retornado
- Verifica que campos obrigatórios estão presentes e não nulos

Endpoint: GET /posts/1  
Resultado esperado:
- Status code 200
- Campo id igual a 1
- Campos obrigatórios não nulos

## Cenário 4 – Buscar usuário por ID válido
- Testa campos individuais e o contrato JSON completo do usuário
- Garantia de consistência da estrutura da resposta

Endpoint: GET /users/10  
Resultado esperado:
- Status code 200
- Campo id igual a 10
- Campo "username" = "Moriah.Stanton"
- Campos obrigatórios: id, name, username, email, address, phone, website, company
- Estrutura do JSON conforme contrato/schema definido

## Cenário 5 – Editar post existente
- O endpoint PATCH/PUT retorna o objeto atualizado, mas não altera os dados permanentemente

Endpoint: PATH /posts/100
Resultado esperado:
- Status code 200
- ID igual a 100
- Retorno: objeto com o title atualizado

## Testes Negativos:

## Cenário 1 – Buscar posts inexistentes
- Retorna 404 e objeto vazio, mostrando tratamento correto de recurso não existente

Endpoint: GET /posts/150  
Resultado esperado:
- Status code: 404
- Retorno: 100 registros
- Campos: Não deverá retornar

## Cenário 2 – Campo não deveria existir
- Para campos inventados (ex: categoria), o teste passa, garantindo que não há atributos inesperados
- Para campos obrigatórios (ex: title), o teste falha intencionalmente, demonstrando que não se pode negar campos existentes

Endpoint: GET /posts/1 
Resultado esperado:
- Status code: 200
- Campo categoria não existe
- Campo title existe

## Cenário 3 – E-mail incorreto de usuário existente
- Valida que valores incorretos não passam despercebidos

Endpoint: GET /users/{id}
Resultado esperado:
- Status code: 200
- Campo username igual a "Moriah.Stanton"
- Campo email não igual a "datg2702@hotmail.com"

## Relatórios de Teste

target/surefire-reports/

## Suporte

- Linkedin: https://www.linkedin.com/in/douglas-tavares-02127567/ 
- E-mail: `datg2702@hotmail.com`