import java.util.List ;
import java.util.ArrayList;
public class Cliente {
    private String nome ;
    private String endereco ;
    private List<Veiculo> listaVeiculos  ;
    
    // construtor

    public Cliente(String nome,String endereco) {
        this.nome = nome ;
        this.endereco = endereco ;
        this.listaVeiculos = new ArrayList<Veiculo>() ;
    }
    
    // setters e getters

    public String getNome() {
        return nome ;
    }
    public void setNome(String nome) {
        this.nome = nome ;
    }
    public String getEndereco() {
        return endereco ;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco ;
    }
    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos ;
    }
    public boolean adicionaLista(Veiculo veiculo) {
        listaVeiculos.add(veiculo) ;
        return true ;

    }
    public String toString() {
        return ("nome :" + nome + " endereco: " + endereco + ", lista de veículos:" + listaVeiculos) ;
    }
    }

