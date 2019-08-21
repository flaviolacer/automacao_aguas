# language: pt

Funcionalidade: 'Cadastrar localidade na aba de clientes'
  Eu como 'Testador'
  Desejo 'Realizar um cadastro de localidade utilizando a aba de clientes'
  A fim de 'mostrar como o teste automatizado funciona'

  Contexto: A página do sistema esteja no ar
    Dado que eu acesse a tela login
    E realizo o login
    E clico na aba de clientes

  Esquema do Cenário: Cadastrar localidade
    Quando eu clicar na opcao 'localidade'
    E clicar no botão 'incluir'
    E preencher os campos nos valores <nome_localidade>, <codigo_localidade>, <cidade>, <data_implantacao>
    E clico no botão 'gravar'
    Então apresenta a mensagem <resultado>

    Exemplos:
      | nome_localidade   | codigo_localidade | cidade        | data_implantacao | resultado                         |
      | teste1_localidade | 01                | Afonso Arinos | 01/08/2019       | 'Inclusão realizada com sucesso!' |
      | teste2_localidade | 02                | Andrade Pinto | 02/08/2019       | 'Inclusão realizada com sucesso!' |
      | teste3_localidade | 03                | Araruama      | 03/08/2019       | 'Inclusão realizada com sucesso!' |