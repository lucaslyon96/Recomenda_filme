package builder;
import java.util.*;
public class Filme {
	String cod; // usado na consulta das outras tabelas
	String title;
	List<String> genres = new ArrayList<String>();
	List<String> directors = new ArrayList<String>();//diretores
	List<String> cast = new ArrayList<String>(); //atores principais
	float averageRating;
	int numVotes;
	int fitness;
	
	
	public void codificacao(){
		
	}
	
	public float funcaoAvaliacao(Filme filme ) 
	{
		float fx = 0;

		return fx; 
				
	}
	
}
