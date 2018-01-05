Voc� ir� implementar um mecanismo de an�lise de risco de clientes.
Para isso voc� ir� usar um instrumento chamado de score de cr�dito.

O score acima de 700 � classificado como OTIMO.
O score entre 300 e 699 � classificado como BOM.
O score abaixo de 300 � classificado como RUIM.

O score ir� variar de acordo com as seguintes regras:
  - O valor inicial do score de cr�dito � de 500 pontos
  - Cada uso do cheque especial gera uma perda de 20 pontos no score
  - Aplica��es maiores que 1000 reais nas contas do banco geram um ganho de 10 pontos no score
  - A compra de Titulo de Capitaliza��o gera um ganho de 10 pontos no score.
  - Cheques devolvidos geram uma perda de 200 pontos no score.
  
Implemente um utilit�rio que calcule o score de cr�dito de um determinado cliente. Para isso use a metodologia BDD, estudada anteriormente.



   
  