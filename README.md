Push Notification Android
===========

Google Cloud Messaging


Google Coud Messaging (CGM) servi�o especial disponibilizado pelo Google para enviar mensagens por push do servidor para o device.
O GCM para Android � um servi�o gratuito que ajuda desenvolvedores a enviar dados de aplica��es servidoras para aplica��es Android. O intuito n�o � trafegar uma grande massa de dados, e sim enviar mensagens simples (de at� 4KB), para, por exemplo, avisar que h� um novo dado a ser baixado da aplica��o servidora. A aplica��o servidora poder� enviar mensagens quando for necess�rio, e ficar� a cargo dos servidores do GCM todo o enfileiramento dessas mensagens e a entrega das mesmas para as aplica��es mobile.
Os componentes envolvidos s�o:


� Dispositivo m�vel: � o aparelho (smartphone ou tablet) que est� rodando a aplica��o Android. Ele deve usar a vers�o 2.2 ou superior e que tenha o Google Play instalado. Alternativamente podemos usar o emulador com as Google APIs;

� Servidores GCM do Google: recebem as mensagens da aplica��o servidora e as entrega aos dispositivos registrados;

� Aplica��o servidora: � a aplica��o que recebe o registro do dispositivo m�vel, armazena o seu id, e envia informa��es para eles atrav�s dos servidores GCM.

O segundo elemento da arquitetura, as credenciais, s�o identificadores e chaves utilizadas pelos componentes durante os diversos est�gios do processo de registro e comunica��o da aplica��o servidora com o dispositivo m�vel.


Como come�ar?


O primeiro passo para iniciar o uso do GCM � acessar a p�gina do Google APIs Console para registrar um novo projeto. Ap�s a p�gina ser carregada, digite o seu usu�rio e senha da conta do Google (se j� n�o estiver autenticado). Se voc� ainda n�o criou um projeto, ser� exibida como realizar esse procedimento.

clique em Create project.Deste modo, ser� exibida a lista de servi�os que o Google disponibiliza para os desenvolvedores. Habilite a op��oGoogle Cloud Messaging for Android.
 
Em seguida, ser�o exibidos os termos de uso do GCM. Leia atentamente e aceite para continuar o processo. Ap�s essa etapa, a p�gina com a lista dos servi�os ser� exibida novamente, agora com o servi�o GCM habilitado.
Uma vez criado o projeto, e habilitado o servi�o, voc� notar� que a URL ficar� similar a essa: https://code.google.com/apis/console/?pli=1#project:999999999999. O n�mero presente nessa URL � o ID do nosso projeto e o utilizaremos no c�digo da aplica��o Android.
Obtendo uma chave da API
Para que a aplica��o servidora possa enviar mensagens para os clientes Android � necess�rio obter uma chave de acesso. Para tal, selecione a op��o API Access para exibir a Em Em seguida, clique no bot�o Create new Server Keye depois em Create.
 
Criando uma chave para utiliza��o do GCM.
Aparecer� a tela onde o campo API key representa a chave de registro que utilizaremos na aplica��o servidora para que ela possa se comunicar com o servidor GCM.
 
Criando uma chave para utiliza��o do GCM.


Editando o manisfest: 


� com.google.android.c2dm.permission.RECEIVE � para usarmos o servi�o GCM;

� android.permission.INTERNET � para usarmos a comunica��o com a Web;

� android.permission.GET_ACCOUNTS � para obter informa��es da conta do usu�rio do aparelho (apenas para vers�es anteriores � 4.0.4);

� android.permission.WAKE_LOCK � para despertar o aparelho caso ele esteja inativo ao chegar uma mensagem.


Ap�s as permiss�es, temos a declara��o da Activity do projeto. E logo ap�s ela, temos a declara��o do BroadcastReceiver que tratar� as mensagens do GCM. Ele j� est� contido na biblioteca do GCM, e a declara��o deve ser sempre igual ao que foi declarado nessa listagem, exceto pela tag category, onde colocamos o nome do pacote da aplica��o. Para finalizar, adicionamos a declara��o do servi�o que deveremos implementar e que ser� chamado pelo BroadcastReceiver especificado anteriormente. � esse servi�o que gerenciar� o processo de registro do dispositivo no GCM, assim como o recebimento de mensagens. Agora crie a classe GCMIntentService, respons�vel por tratar as mensagens vindas do GCM.


OBS:
 Para utilizar o CGM � necess�rio o Android 2.2 ou superior o que � configurado pela tag:

<uses-sdk android:minSdkVersion="8" android:targetSdkVersion="15" /> 

Links

Google APIs Console.

https://code.google.com/apis/console

Sites Consultados: www.devmedia.com.br

Livros:
Ricardo R. Lecheta - Google Android � aprenda a criar aplica��es para dispositivos m�veis com o Android SDK.

