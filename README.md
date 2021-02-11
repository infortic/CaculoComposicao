# Calculo Composicao

Projeto criado para resolver cálculo de composição a partir de uma lista de objeos no formato JSON.

Seguindo as seguintes Regras: 

Digamos que para fazer uma obra vamos precisar preparar 3m³ de argamassa, nesse caso poderíamos ter</br>
uma composição chamada: “Preparo de argamassa para assentamento”. E para cada 1m³ de argamassa</br>
precisamos dos seguintes insumos:</br></br></br>
• 0,5 hora(s) de mão de obra de um pedreiro (que custa R$ 30,00 por hora);</br>
• 1 hora(s) de mão de obra de um servente (que custa R$ 18,00 por hora);</br>
• 0,1 sacos do material cimento (que custa R$ 30,00 por saco);</br>
• 5kg do material areia (que custa R$ 20,00 por kg);</br>
• 1kg do material cal (que custa R$ 9,00 por kg);</br></br></br>
Nesse cenário acima, o custo para cada 1m³ de argamassa é a soma das multiplicações dos valores unitários</br>
por unidade de tempo acima:</br></br></br>
0,5 * 30 + 1 * 18 + 0,1 * 30 + 5 * 20 + 1 * 9 = 145</br></br></br></br>
Dessa forma, o custo para cada 1m³ de argamassa seria de R$ 145,00. Sendo que o custo por 3m³ de</br>
argamassa seria R$ 435,00.</br>
Além disso, o valor de uma composição também pode ser composto de outras composições. Por exemplo,</br>
poderia ser segunda composição chamada “Construção de paredes” composta por outra composição</br>
chamada “Preparo de argamassa para assentamento”. E para cada 1m² de parede fosse necessário a</br>
seguinte composição:</br></br></br>
• 0,5 hora(s) de mão de obra de um pedreiro (que custa R$ 30,00 por hora);</br>
• 1 hora(s) de mão de obra de um servente (que custa R$ 18,00 por hora);</br>
• 10 unidade de tijolo de 6 furos (que custa R$ 0,34 por unidade);</br>
• 3m³ de “preparo de argamassa para assentamento” (que custa R$ 145,00 por m³);</br>
Nesse cenário acima, o custo para cada 1m² de parede é a soma das multiplicações dos valores unitários</br></br></br>
por unidade de tempo acima:</br></br></br>
0,5 * 30 + 1 * 18 + 10 * 0,34 + 3 * 145 = 471,4</br></br></br>
Dessa forma, o custo para cada 1m² de parede seria de R$ 471,40. Sendo que o custo por 3m³ de</br>
argamassa seria R$ 1.305,00.</br>
Nesse exercício você está recendo um JSON que contém composições e queremos que você desenvolva um</br>
modelo para o cálculo dos valores das composições do arquivo e retorne o valor unitário de cada uma das</br>
composições contidas no arquivo, conforme as instruções a seguir:</br>
</br></br></br>
• Para essa implementação você está recebendo um arquivo JSON pronto como dados de entrada.</br>
Esse arquivo pode estar num caminho fixo do projeto;</br>
• Nesse JSON cada objeto representa um item de uma composição. Como uma composição pode</br>
mais de um item, as informações da composição (descrição da composição, unidade, etc.) estão</br>
repetidas dentro de cada JSON;</br>
• Como auxiliar a implementação e ao entendimento, você pode usar o arquivo XLS que mostra</br>
detalhes de como é a estrutura e como é feito o cálculo dos preços das composições;</br>
• Como o resultado não será uma aplicação completa com interface gráfica ou API REST, a execução</br>
do código deve ser demonstrada no método main da aplicação (ainda assim, iremos avaliar os</br>
testes automatizados).</br>
• Esperamos que a saída da execução do programa que foi executada no método main seja</br>
apresentada no console, imprimindo os valores dos 5 serviços, conforme o modelo a seguir:</br></br>
94793 REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA</br>
CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE</br>
FIBRA/FIBROCIMENTO FORNECIMENTO E INSTALAÇÃO. AF_06/2016 UN 128,60</br>
98561 IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE CIMENTO E AREIA, COM ADITIVO</br>
IMPERMEABILIZANTE, E = 2CM. AF_06/2018 M2 28,73</br>
87286 ARGAMASSA TRAÇO 1:1:6 (CIMENTO, CAL E AREIA MÉDIA) PARA EMBOÇO/MASSA</br>
ÚNICA/ASSENTAMENTO DE ALVENARIA DE VEDAÇÃO, PREPARO MECÂNICO COM BETONEIRA 400 L.</br>
AF_06/2014 M3 289,97</br>
88830 BETONEIRA CAPACIDADE NOMINAL DE 400 L, CAPACIDADE DE MISTURA 280 L, MOTOR ELÉTRICO</br>
TRIFÁSICO POTÊNCIA DE 2 CV, SEM CARREGADOR - CHP DIURNO. AF_10/2014 CHP 1,25</br>
88831 BETONEIRA CAPACIDADE NOMINAL DE 400 L, CAPACIDADE DE MISTURA 280 L, MOTOR ELÉTRICO</br>
TRIFÁSICO POTÊNCIA DE 2 CV, SEM CARREGADOR - CHI DIURNO. AF_10/2014 CHI 0,22</br>