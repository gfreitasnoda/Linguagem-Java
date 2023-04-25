package br.com.poo.objetos;
import java.io.BufferedReader;
/*
 * Este arquivo de java realiza um acesso remoto por ssh em um servidor linux(Fedora Server)
 * Para realizar essa operação foi necessario a utilização de uma biblioteca chamada 
 * jsch. Esta biblioteca foi baixada no site oficial
 */
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class AcessoSSH {
		/*
		 * Para o aceso a maquina remota(linux) foi definida como
		 * constante os seguintes abaixo
		 * 
		 */
		private static final String REMOTE_HOST = "127.0.0.1";
		private static final String REMOTE_USER = "senac";
		private static final String REMOTE_PASSWORD = "senac@123";
		private static final int REMOTE_PORT = 2222;
		private static final int SESSION_TIMEOUT = 10000;
		private static final int CHANNEL_TIMEOUT = 10000;
		/*
		 * Para a sessao e o canal(channel) foi definido um tempo de execução de 
		 * 10000 milisegundos, ouseja, 10 segundos
		 */
	
	public static void main(String[] args) {
		
			//O comando que será executado remotamente
			String comando = "python3 /home/senac/Python/populacao.py";
			//Tipando a variavel sessao para abrir a sessão ssh com o servidor linux
			Session sessao =  null;
			try {
				/*
				 * Criação do obj para criar as configuração de avesso do
				 * servidor
				 */
				Properties  config = new Properties();
				/*
				 * foi setada a configuração restritd para a checagem da chave de criptografia como no(não)
				 * isso faz com que não haja a verificação da chave de criptografia
				 * muito usado quando nao se tem a chave
				 */
				config.put("StrictHostKeyChecking", "no");
				/*
				 * Criando o objeto JSch
				 */
				JSch jsch = new JSch();
				//Setar o arquivo que contem a chave de criptografia para acesso SSH
				jsch.setKnownHosts("/home/senac/.ssh/nome_arquivo_chave");
				
				//Comando para avrir a sessao remota com o servidor linux. Forampassados:
				//Nome de Usuario, Ip do Servidor e porta de comunicação nesta ordem
				sessao = jsch.getSession(REMOTE_USER, REMOTE_HOST, REMOTE_PORT);
				
				//Setando a senha do servidor remoto
				sessao.setPassword(REMOTE_PASSWORD);
				//Foi setado a configuração para a sessao não verificar a existencia da chave
				//de acesso
				sessao.setConfig(config);
				
				//Passando o tempo de execução da sessao
				sessao.connect(SESSION_TIMEOUT);
				
				/*
				 * Criando o elemento que representa o canal de execução de comandos . o comando 
				 * sessao.openChannel, nos diz que quando a sessao for aberta tambem sera aberto um
				 * canal para passagem dos comandos que serão executados no servidor
				 * remoto
				 **/
				ChannelExec channelExec = (ChannelExec) sessao.openChannel("exec");
				/*
				 * O comando channelExec.setCommand aponta o comando que deve ser executado no servidor remoto
				 * Exte comando foi definido na declaraçao de variavel String comando.
				 * */
				channelExec.setCommand(comando);
				/*
				 * Quando ha algum erro inesperado na execução do channelExec será exibido no sysout
				 * */
				
				channelExec.setErrStream(System.err);
				/*
				 * O comando InputStream realiza uma entrada de dados por meio do canal criado. Tambem permite
				 * obter os dados que estao entrando no canal como comando getInputStream()
				 */
				
				InputStream in = channelExec.getInputStream();
				/*
				 * Estabelece a conexao com o canal e passa o tempo em que no canal fica aberto para a passagem de dados
				 */
				channelExec.connect(CHANNEL_TIMEOUT);
				/*
				 * Os dados serao passados e recebido por bytes e nao diretamente com Strings ou Numeros(inteiros ou reais)
				 * para que esta açao seja feita criamos uma array de bytes para realizar a transiçao.
				 */
				byte[] tmp = new byte[1024];
				/*
				 * Enquanto for possivel ao laço (while(true)) ele deve
				 * verificar se ha dados em in, portanto temos o comando in.available(disponivel) se é
				 * maior que 0. sendo positivo ele deve execytar todas as linhas disponiveis que retornaram
				 * Se o retorno de dados resultou em mais linhas maiores que 0(zero), estas linhas deveram 
				 * ser apresentadas no terminal. O uso do comando new String(tmp,0,i) faz a conversão de bytes 
				 * que estao vindo como resposta e a variavel i conta a quantidade de linhas que retorna
				 */
				while(true) {
					while(in.available()>0) {
						int i = in.read(tmp,0,1024);
						if( i<0 ) break;
						System.out.println(new String(tmp,0,i));
					}
					/*
					 * Se o canal estiver fechado mas medsmo assim tiver dados em in o laço deve continuar,
					 * ou seja volta ao inicio e executa tudo outra vez
					 * Caso nao haja mais nada a ser exibido em tela o canal é fechado e é exibida a mensagem de 
					 * canal fechado
					 */
					if(channelExec.isClosed()) {
						if(in.available() > 0) continue;
						System.out.println("Saída do processo " +channelExec.getExitStatus());
						break;
					}
					try {
						//Demora 1 segundo  e repete o laço outra vez até o canal ser desconectado
						Thread.sleep(1000);
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				Process pr = Runtime.getRuntime().exec(" C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe 127.0.0.1:6660/grafico.html");
				BufferedReader leitor = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				String rs = "";
				while((rs = leitor.readLine())!=null) {
					System.out.println(rs);
				}
				
				channelExec.disconnect();
				//Desconectar o canal
			}
				catch(JSchException jsex) {
					jsex.printStackTrace();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			finally {
				if(sessao != null) {
					sessao.disconnect();//desconectar o canal
				}
			}
	}

}
