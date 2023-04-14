# Gerênciador de Tarefas Java

## Sobre o Projeto
Um mini-sistema que permite aos usuários criar e gerenciar listas de tarefas, definir prazos, adicionar lembretes e categorizar as tarefas de acordo com a importância.

### Uso do Java
Irei usar a linguagem Java para construir essa aplicação, já que diz respeito a uma sistema que poderá ser usado por qualquer pessoa.

### Uso do POO
A programação orientada a objeto será implemenetada na criação das 'entidades' que são classes e por sua vez intanciações das classes, objeto. Como por exemplo a classe que poderá representar a Tarefa, categorias, os lembretes utilizando outros tópicos de POO para representar relacionamentos, métodos entres as classes e etc.

## Camadas lógicas (BackEnd)
![Modelo Conceitual](https://github.com/Joao-Darwin/repoImgs/blob/main/Imgs%20-%20Web%20Service%20SpringBoot/camadasLogicas.png)

## Tecnologias usadas
### Back-End
- Java (Linguagem de Programação
- Spring Boot (Framework)
- Hibernate (Mapeamento)
- JPA (Persistência dos Dados no Banco de Dados)
- Maven (Gerênciador de Pacotes)
- H2 DataBase (Banco de Dados Teste)
- MySQL (Banco de Dados produção)

### Front-End
- React

## Como executar o Projeto
### Pré Requisitos: Java 17

## Back-End
### Clonar o Repositório
```bash
git clone https://github.com/ifpb-cz-ads/poo-2023-1-ai-Joao-Darwin.git GerenciadorTarefas
```

### Entrar na pasta backend
```bash
cd backend
```

### Instalar o Maven
```bash
sudo apt-get install maven
```

### Instalar dependências
```bash
sudo mvn clean install 
```

### Rodar o backend
```bash
mvn spring-boot:run
```

## Front-End
### Sair da pasta do backend e ir para a do frontend
```bash
cd ../frontend
```

### Instalar o npm
```bash
sudo apt-get install npm
```

### Builder no frontend
```bash
sudo npm run build
```

### Rodar frontend
```bash
sudo npm start
```
