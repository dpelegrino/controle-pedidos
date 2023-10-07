Criar uma solução java em formato de API que atenda aos seguintes requisitos para a recepção de pedidos dos clientes:

Criar um serviço que receba pedidos no formato xml e json com 6 campos:
número controle - número aleatório informado pelo cliente.
data cadastro (opcional)
nome - nome do produto
valor - valor monetário unitário produto
quantidade (opcional) - quantidade de produtos.
codigo cliente - identificação numérica do cliente.

Critérios aceitação e manipulação do arquivo:

O arquivo pode conter 1 ou mais pedidos, limitado a 10.
Não poderá aceitar um número de controle já cadastrado.
Caso a data de cadastro não seja enviada o sistema deve assumir a data atual.
Caso a quantidade não seja enviada considerar 1.
Caso a quantidade seja maior que 5 aplicar 5% de desconto no valor total, para quantidades a partir de 10 aplicar 10% de desconto no valor total.
O sistema deve calcular e gravar o valor total do pedido.
Assumir que já existe 10 clientes cadastrados, com códigos de 1 a 10.


Criar um serviço onde possa consultar os pedidos enviados pelos clientes.
Critérios aceitação:
O retorno deve trazer todos os dados do pedido.

filtros da consulta:
número pedido, data cadastro, todos



Frameworks:
Fica a critério do candidato utilizar ou não, sem restrições de escolha.

desejável:
Injeção de dependência
Padrões de projeto
Testes unitários

Obrigatório
banco de dados mysql
utilizar framework ORM
utilizar a linguagem java 1.8

a solução deve ser publicada no github juntamente com o script de criação das tabelas.
deve ser enviado o link do repositório da solução para este email.


## ATUALIZAÇÃO:
1. Adicionado o docker-compose.yml na pasta resources para subida do Banco de dados Mysql localmente.
Basta executar o comando 'docker-compose up' no diretorio onde se encontra o arquivo.

1. Adicionado a dependencia do Flyway para criação dos scripts de banco de dados automaticamente(Se o banco e a tabela não existir. Os cripts estão na pasta resource/db.migration)

1. Adicionado a dependencia 'org.modelmapper' onde a mesma efetua o bind de Entity para DTO/Response e vise versa de forma automatica, sem a necessidade da criação da Entidade e setando as propriedades conforme implementação anterior.

1. Utilizado a IDE Intellij para a implementação, porem como o projeto é maven, acredito que nao terá problema na execução do mesmo no Eclipse.

1. Podemos discutir sobre todas as implementações caso gostem e queiram que eu passe para proxima fase :)


# Muito Obrigado!!!



