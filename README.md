Push Notification Android
===========

Google Cloud Messaging


Google Coud Messaging (CGM) serviço especial disponibilizado pelo Google para enviar mensagens por push do servidor para o device.
O GCM para Android é um serviço gratuito que ajuda desenvolvedores a enviar dados de aplicações servidoras para aplicações Android. O intuito não é trafegar uma grande massa de dados, e sim enviar mensagens simples (de até 4KB), para, por exemplo, avisar que há um novo dado a ser baixado da aplicação servidora. A aplicação servidora poderá enviar mensagens quando for necessário, e ficará a cargo dos servidores do GCM todo o enfileiramento dessas mensagens e a entrega das mesmas para as aplicações mobile.
Os componentes envolvidos são:


• Dispositivo móvel: é o aparelho (smartphone ou tablet) que está rodando a aplicação Android. Ele deve usar a versão 2.2 ou superior e que tenha o Google Play instalado. Alternativamente podemos usar o emulador com as Google APIs;
• Servidores GCM do Google: recebem as mensagens da aplicação servidora e as entrega aos dispositivos registrados;
• Aplicação servidora: é a aplicação que recebe o registro do dispositivo móvel, armazena o seu id, e envia informações para eles através dos servidores GCM.
O segundo elemento da arquitetura, as credenciais, são identificadores e chaves utilizadas pelos componentes durante os diversos estágios do processo de registro e comunicação da aplicação servidora com o dispositivo móvel.


Como começar?


O primeiro passo para iniciar o uso do GCM é acessar a página do Google APIs Console para registrar um novo projeto. Após a página ser carregada, digite o seu usuário e senha da conta do Google (se já não estiver autenticado). Se você ainda não criou um projeto, será exibida como realizar esse procedimento.

clique em Create project.Deste modo, será exibida a lista de serviços que o Google disponibiliza para os desenvolvedores. Habilite a opçãoGoogle Cloud Messaging for Android.
 
Em seguida, serão exibidos os termos de uso do GCM. Leia atentamente e aceite para continuar o processo. Após essa etapa, a página com a lista dos serviços será exibida novamente, agora com o serviço GCM habilitado.
Uma vez criado o projeto, e habilitado o serviço, você notará que a URL ficará similar a essa: https://code.google.com/apis/console/?pli=1#project:999999999999. O número presente nessa URL é o ID do nosso projeto e o utilizaremos no código da aplicação Android.
Obtendo uma chave da API
Para que a aplicação servidora possa enviar mensagens para os clientes Android é necessário obter uma chave de acesso. Para tal, selecione a opção API Access para exibir a Em Em seguida, clique no botão Create new Server Keye depois em Create.
 
Criando uma chave para utilização do GCM.
Aparecerá a tela onde o campo API key representa a chave de registro que utilizaremos na aplicação servidora para que ela possa se comunicar com o servidor GCM.
 
Criando uma chave para utilização do GCM.


Editando o manisfest: 


• com.google.android.c2dm.permission.RECEIVE – para usarmos o serviço GCM;
• android.permission.INTERNET – para usarmos a comunicação com a Web;
• android.permission.GET_ACCOUNTS – para obter informações da conta do usuário do aparelho (apenas para versões anteriores à 4.0.4);
• android.permission.WAKE_LOCK – para despertar o aparelho caso ele esteja inativo ao chegar uma mensagem.


Após as permissões, temos a declaração da Activity do projeto. E logo após ela, temos a declaração do BroadcastReceiver que tratará as mensagens do GCM. Ele já está contido na biblioteca do GCM, e a declaração deve ser sempre igual ao que foi declarado nessa listagem, exceto pela tag category, onde colocamos o nome do pacote da aplicação. Para finalizar, adicionamos a declaração do serviço que deveremos implementar e que será chamado pelo BroadcastReceiver especificado anteriormente. É esse serviço que gerenciará o processo de registro do dispositivo no GCM, assim como o recebimento de mensagens. Agora crie a classe GCMIntentService, responsável por tratar as mensagens vindas do GCM.


OBS:
 Para utilizar o CGM é necessário o Android 2.2 ou superior o que é configurado pela tag:

<uses-sdk android:minSdkVersion="8" android:targetSdkVersion="15" /> 

Links

Google APIs Console.

https://code.google.com/apis/console

Sites Consultados: www.devmedia.com.br

Livros:
Ricardo R. Lecheta - Google Android – aprenda a criar aplicações para dispositivos móveis com o Android SDK.

