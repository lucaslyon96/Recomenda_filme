package builder;

import java.util.*;
import java.util.ArrayList;;

public class GA {
	Filme dataIn;
	List<Filme> pop = new ArrayList<Filme>();
	Database data = new Database();
	List<Filme> pais;
	List<Filme> filhos;
	int n; 
	int tamBD = 1000;
 
	GA(int tam){
		n = tam; //Tamanho da populacao
		int k = 4;//Quantidade de individuos que serao mantidos por elitismo em cada geracao
		Random aux = new Random();
		
		int numAleatorio;
		for(int i=0; i<50; i++){
			numAleatorio = aux.nextInt(tamBD);
			pop.add(data.get(numAleatorio));	
		}
		pais = new ArrayList<Filme>(n-k);
		filhos = new ArrayList<Filme>(n-k);
	}
	 
	public void fitnessFunction(){
		for(int i=0; i<n; i++){
			pop.get(i).fitness = 0;
			//COMPARA OS ATORES
			if(dataIn.cast.get(0).compareTo(pop.get(i).cast.get(0))==0){
				pop.get(i).fitness += 15;
			}
			//COMPARA OS DIRETORES
			if(dataIn.directors.get(0).compareTo(pop.get(i).directors.get(0))==0){
				pop.get(i).fitness += 20;
			}
			
			//COMPARA OS GENEROS
			String generoIn = dataIn.genres.get(0);
			if(generoIn.compareTo(pop.get(i).genres.get(i))==0){
				pop.get(i).fitness+=100;
			}
			else if(generoIn.compareTo("Action")==0 || generoIn.compareTo("Adventure")==0 || generoIn.compareTo("Crime")==0){
				if(pop.get(i).genres.get(0).compareTo("Action")==0 || pop.get(i).genres.get(0).compareTo("Adventure")==0 || pop.get(i).genres.get(0).compareTo("Crime")==0){
					pop.get(i).fitness += 90;
				}
				else if(pop.get(i).genres.get(0).compareTo("Thriller")==0 || pop.get(i).genres.get(0).compareTo("Horror")==0 || pop.get(i).genres.get(0).compareTo("Mystery")==0){
					pop.get(i).fitness +=75;
				}
				else if(pop.get(i).genres.get(0).compareTo("Fantasy")==0 || pop.get(i).genres.get(0).compareTo("Sci-Fi")==0){
					pop.get(i).fitness +=60;
				}
				else if(pop.get(i).genres.get(0).compareTo("Comedy")==0 || pop.get(i).genres.get(0).compareTo("Animation")==0){		
					pop.get(i).fitness +=40;
				}
				else if(pop.get(i).genres.get(0).compareTo("Romance")==0 || pop.get(i).genres.get(0).compareTo("Drama")==0){
					pop.get(i).fitness +=20;
				}
			}
				
			else if(generoIn.compareTo("Thriller")==0 || generoIn.compareTo("Horror")==0 || generoIn.compareTo("Mystery")==0){
				if(pop.get(i).genres.get(0).compareTo("Thriller")==0 || pop.get(i).genres.get(0).compareTo("Horror")==0 || pop.get(i).genres.get(0).compareTo("Mystery")==0){
					pop.get(i).fitness +=90;
				}
				else if(pop.get(i).genres.get(0).compareTo("Action")==0 || pop.get(i).genres.get(0).compareTo("Adventure")==0 || pop.get(i).genres.get(0).compareTo("Crime")==0){
					pop.get(i).fitness += 75;
				}
				else if(pop.get(i).genres.get(0).compareTo("Fantasy")==0 || pop.get(i).genres.get(0).compareTo("Sci-Fi")==0){
					pop.get(i).fitness +=60;
				}
				else if(pop.get(i).genres.get(0).compareTo("Romance")==0 || pop.get(i).genres.get(0).compareTo("Drama")==0){
					pop.get(i).fitness +=40;
				}
				else if(pop.get(i).genres.get(0).compareTo("Comedy")==0 || pop.get(i).genres.get(0).compareTo("Animation")==0){		
					pop.get(i).fitness +=20;
				}		
			}
			
			else if(generoIn.compareTo("Comedy")==0 || generoIn.compareTo("Animation")==0){
				if(pop.get(i).genres.get(0).compareTo("Comedy")==0 || pop.get(i).genres.get(0).compareTo("Animation")==0){		
					pop.get(i).fitness +=90;
				}
				else if(pop.get(i).genres.get(0).compareTo("Romance")==0 || pop.get(i).genres.get(0).compareTo("Drama")==0){
					pop.get(i).fitness +=75;
				}
					
				else if(pop.get(i).genres.get(0).compareTo("Fantasy")==0 || pop.get(i).genres.get(0).compareTo("Sci-Fi")==0){
					pop.get(i).fitness +=60;
				}
				else if(pop.get(i).genres.get(0).compareTo("Action")==0 || pop.get(i).genres.get(0).compareTo("Adventure")==0 || pop.get(i).genres.get(0).compareTo("Crime")==0){
					pop.get(i).fitness += 40;
				}
				else if(pop.get(i).genres.get(0).compareTo("Thriller")==0 || pop.get(i).genres.get(0).compareTo("Horror")==0 || pop.get(i).genres.get(0).compareTo("Mystery")==0){
					pop.get(i).fitness +=20;
				}	
			}
			else if(generoIn.compareTo("Romance")==0 || generoIn.compareTo("Drama")==0){
				if(pop.get(i).genres.get(0).compareTo("Romance")==0 || pop.get(i).genres.get(0).compareTo("Drama")==0){
					pop.get(i).fitness +=90;
				}
				else if(pop.get(i).genres.get(0).compareTo("Comedy")==0 || pop.get(i).genres.get(0).compareTo("Animation")==0){		
					pop.get(i).fitness +=75;
				}	
				else if(pop.get(i).genres.get(0).compareTo("Fantasy")==0 || pop.get(i).genres.get(0).compareTo("Sci-Fi")==0){
					pop.get(i).fitness +=60;
				}
				else if(pop.get(i).genres.get(0).compareTo("Thriller")==0 || pop.get(i).genres.get(0).compareTo("Horror")==0 || pop.get(i).genres.get(0).compareTo("Mystery")==0){
					pop.get(i).fitness +=40;
				}	
				else if(pop.get(i).genres.get(0).compareTo("Action")==0 || pop.get(i).genres.get(0).compareTo("Adventure")==0 || pop.get(i).genres.get(0).compareTo("Crime")==0){
					pop.get(i).fitness += 20;
				}
			}
			else if(pop.get(i).genres.get(0).compareTo("Fantasy")==0 || pop.get(i).genres.get(0).compareTo("Sci-Fi")==0){
				if(pop.get(i).genres.get(0).compareTo("Fantasy")==0 || pop.get(i).genres.get(0).compareTo("Sci-Fi")==0){
					pop.get(i).fitness +=100;
				}
				else if(pop.get(i).genres.get(0).compareTo("Action")==0 || pop.get(i).genres.get(0).compareTo("Adventure")==0 || pop.get(i).genres.get(0).compareTo("Crime")==0){
					pop.get(i).fitness += 75;
				}
				else if(pop.get(i).genres.get(0).compareTo("Thriller")==0 || pop.get(i).genres.get(0).compareTo("Horror")==0 || pop.get(i).genres.get(0).compareTo("Mystery")==0){
					pop.get(i).fitness +=75;
				}	
				else if(pop.get(i).genres.get(0).compareTo("Comedy")==0 || pop.get(i).genres.get(0).compareTo("Animation")==0){		
					pop.get(i).fitness +=75;
				}
				else if(pop.get(i).genres.get(0).compareTo("Romance")==0 || pop.get(i).genres.get(0).compareTo("Drama")==0){
					pop.get(i).fitness +=75;
				}
			}
		}
	}

	public void selection(){ //MÉTODO ROLETA
		int k = pais.size();
		//ATRIBUINDO OS PESOS PARA CADA INDIVIDUO
		float soma = 0;
		float auxVetor[] = new float[n];
		for(int i=0; i<n; i++){
			soma += pop.get(i).fitness;
		}
		for(int i=0; i<n; i++){
			auxVetor[i] = 10000*(pop.get(i).fitness/soma);
		}
		
		//REALIZANDO O SORTEIO
		Random gerador = new Random();
		int aux;
		for(int i=0; i<k; i++){
			aux = gerador.nextInt(10000);
			float auxSoma=0;
			for(int j=0; j<n; j++){
				auxSoma += auxVetor[j];
				if(auxSoma>=aux){
					pais.add(pop.get(j));
					break;
				}
			}
		}
		
	}

	public void cruzamento(){
		int k = pais.size();
		//GERAR OS FILHOS
		for(int i=0; i<k; i=i+2){
			filhos.add(new Filme(pais.get(i).genres, pais.get(i+1).directors, pais.get(i).cast));
			filhos.add(new Filme(pais.get(i+1).genres, pais.get(i).directors, pais.get(i+1).cast));	
		}
		for(int filho=0; filho<k; filho++){
		
			//ENCONTRAR FILMES SEMELHANTES AOS FILHOS
			List<Filme> aux7 = new ArrayList<Filme>(); //Lista auxiliar para armazenar os filmes que tem 3 caracteristicas iguais ao filho gerado
			
			List<Filme> aux6 = new ArrayList<Filme>(); //Lista auxiliar para armazenar os filmes que tem 2 caracteristicas iguais ao filho gerado  --- GENERO E DIRETOR
			List<Filme> aux5 = new ArrayList<Filme>(); //Lista auxiliar para armazenar os filmes que tem 2 caracteristicas iguais ao filho gerado  --- GENERO E ATOR
			List<Filme> aux4 = new ArrayList<Filme>(); //Lista auxiliar para armazenar os filmes que tem 2 caracteristicas iguais ao filho gerado  --- DIRETOR E ATOR
			
			List<Filme> aux3 = new ArrayList<Filme>(); //Lista auxiliar para armazenar os filmes que tem 1 caracteristicas iguais ao filho gerado  --- GENERO
			List<Filme> aux2 = new ArrayList<Filme>(); //Lista auxiliar para armazenar os filmes que tem 1 caracteristicas iguais ao filho gerado  --- DIRETOR
			List<Filme> aux1 = new ArrayList<Filme>(); //Lista auxiliar para armazenar os filmes que tem 1 caracteristicas iguais ao filho gerado  --- ATOR
			/* ----------------TABELA DE COMPARACAO-------------------
			 * O NUMERO REPRESENTA A IMPORTANCIA DE CADA COMBINACAO
			 * COINCIDIU: GENERO, DIRETOR E ATOR = 9
			 * COINCIDIU: GENERO E DIRETOR       = 7
			 * COINCIDIU: GENERO E ATOR          = 6
			 * COINCIDIU: DIRETOR E ATOR         = 5
			 * COINCIDIU: GENERO                 = 4
			 * COINCIDIU: DIRETOR                = 3
			 * COINCIDIU: ATOR                   = 2
			 */
			for(int i=0; i<tamBD; i++){
				int numMatch = 0;
				if(data.get(i).genres.get(0).compareTo(filhos.get(k).genres.get(0))==0) numMatch += 4;
				if(data.get(i).directors.get(0).compareTo(filhos.get(k).directors.get(0))==0) numMatch += 3;
				if(data.get(i).cast.get(0).compareTo(filhos.get(k).cast.get(0))==0) numMatch += 2;
				switch(numMatch){
				case(9):
					aux7.add(data.get(i));
					break;
				case(7):
					aux6.add(data.get(i));
					break;
				case(6):
					aux5.add(data.get(i));
					break;
				case(5):
					aux4.add(data.get(i));
					break;
				case(4):
					aux3.add(data.get(i));
					break;
				case(3):
					aux2.add(data.get(i));
					break;
				case(2):
					aux1.add(data.get(i));
					break;
				}
			}
			if(aux7.size()!=0){
				Random rand = new Random();
				int aux = rand.nextInt(aux7.size());
				filhos.set(filho, aux7.get(aux));
			}
			else if(aux6.size()!=0){
				Random rand = new Random();
				int aux = rand.nextInt(aux6.size());
				filhos.set(filho, aux6.get(aux));
			}
			else if(aux5.size()!=0){
				Random rand = new Random();
				int aux = rand.nextInt(aux5.size());
				filhos.set(filho, aux5.get(aux));
			}
			else if(aux4.size()!=0){
				Random rand = new Random();
				int aux = rand.nextInt(aux4.size());
				filhos.set(filho, aux4.get(aux));
			}
			else if(aux3.size()!=0){
				Random rand = new Random();
				int aux = rand.nextInt(aux3.size());
				filhos.set(filho, aux3.get(aux));
			}
			else if(aux2.size()!=0){
				Random rand = new Random();
				int aux = rand.nextInt(aux2.size());
				filhos.set(filho, aux2.get(aux));
			}
			else if(aux1.size()!=0){
				Random rand = new Random();
				int aux = rand.nextInt(aux1.size());
				filhos.set(filho, aux1.get(aux));
			}
		}	
	}
	
	public void mutacao(){ //A MUTAÇÃO É SIMPLESMENTE TROCAR UM DOS FILHOS POR UM FILME QUALQUER EM NOSSO BANCO DE DADOS
		Random gerador = new Random();
		int aux1, aux2;
		aux1 = gerador.nextInt(filhos.size());
		aux2 = gerador.nextInt(n);
		filhos.set(aux1, data.get(aux2));
	}
	
	public void atualizarPopulacao(){
		int qtdFilhos = filhos.size();
		int k = n - qtdFilhos;
		
		for(int i=0; i<qtdFilhos; i++){
			pop.set(k, filhos.get(i));
			k++;
		}
	}
	public void ordenar(){
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				if(pop.get(i).fitness < pop.get(i).fitness){
					Filme aux = pop.get(i);
					pop.set(i, pop.get(j));
					pop.set(j, aux);
				}
			}
		}
		
	}
	
	public void buscaFilme(){
		int it=1;
		while(true){
			fitnessFunction();
			ordenar();
			if(it>=100) break;
			selection();
			cruzamento();
			mutacao();
			atualizarPopulacao();
			it++;
		}
		
		
	}
}
