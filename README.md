Esta aplicação foi desenvolvida com Intellij IDEA.
Não é necessária instalação de nenhuma third party.

A aplicação incorpora o HSQLDB (http://hsqldb.org/) para BD em memória.
Após executar a aplicação, em modo debug ou não, navegue até http://localhost:8080/, nesse serão listados todos os endpoints, conforme:

  -	/billing/create
  - [POST] Inclusão de conta a pagar.
---
  - /billing/list
  - [GET] Listagem das contas cadastradas
---

Exemplo de POST para /billing/create
>{ "name": "Teste 01", "priceOriginal": 10, "dueDate": "1988-05-18", "paymentDate":"1988-05-20" }

Divirta-se
=)
