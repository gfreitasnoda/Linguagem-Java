package br.com.poo.objetos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Processos {

	public static void main(String[] args) {
			
			try {
				/*
				 * O comando Process executa um comando do sistema operacional,
				 * neste caso  o sistema é Windows
				 * O comando RunTime(Tempo de execução ) getRuntime(chamar para executar)
				 * são utilizados para executar um comando do sistema operacional. E,este
				 * comando será executado quando a aplicação do java for executada (Runtime)
				 * Abaixo estamos abrindo o Google Chrome pelo endereço dele das pastas 
				 * e abrindo o site Terra
				 */
				Process pr = Runtime.getRuntime().exec(" C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe 127.0.0.1:8888/ ");
				/*
				 * o comando BufferedReader(A classe Buffered) é um leitor que trabalha 
				 * com o dados em memória. Ele é responsavel para ler 
				 * os dados em mémoria.
				 * Abaixo é feita uma inserção de leitura de dados com o comando 
				 * InputStreamReader(Inserir um dado de leitura). Neste caso foi inserido
				 * e lido o processo que executa o comando
				 */
				BufferedReader leitor = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				/*
				 * Para exibir as informações retornadas pelo Buffer, podemos usar uma
				 * variavel no formato de String para armazenar estas informações e
				 * depois exibi-las
				 **/
				String rs = "";
				/*
				 * Para pegar todos os dados em memoria e exibir em tema foi utilizado
				 * o comando while e os dados foram passados para a variavel rs.
				 * Assim foi possivel exibir no console.
				 */
				while((rs = leitor.readLine())!=null) {
					System.out.println(rs);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}

	}

}
