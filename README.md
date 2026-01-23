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

Os testes manuais estão disponíveis em PDF no repositório:
src\doc\testes_api_gherkin.pdf
link: https://github.com/douglastavares2702/jsonplaceholder-api-tests/blob/main/src/doc/testes_api_gherkin.pdf

## Relatórios de Teste

target/surefire-reports/

## Suporte

- Linkedin: https://www.linkedin.com/in/douglas-tavares-02127567/ 
- E-mail: `datg2702@hotmail.com`