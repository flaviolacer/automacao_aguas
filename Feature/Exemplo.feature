# language: pt


Funcionalidade: 'Realizar uma busca'
    Eu como 'Testador'
    Desejo 'Realizar um teste de busca'
    A fim de 'mostrar como o cucumber funciona'
    
Contexto: A página do google esteja no ar
		Dado que eu acesso a tela de busca

Esquema do Cenário: Realizar teste de busca
    Dado o texto de busca com <texto> = <valor>
    Quando realizar a busca
    Então resultado da busca é <resultado>

    Exemplos:
        | texto   | valor    | resultado                   |
        | query   | primeup  | www.primeup.com.br          |
