import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import java.util.Random;
public class Seguradora {

    private String nome ;
    private String telefone ;
    private String endereco ;
    private String email ;
    private static List<Cliente> lista_clientes = new ArrayList<Cliente>();
    private static List<Sinistro> lista_sinistros = new ArrayList<Sinistro>() ;
    
    //construtor 
    public Seguradora(String nome,String telefone,String endereco,String email) {
        this.nome = nome ;
        this.telefone = telefone ;
        this.endereco = endereco ;
        this.email = email ;
    }

    // getters e setters
    public String getNome() {
        return nome ;
    }
    public void setNome(String nome) {
        this.nome = nome ;
    }
    public String getTelefone() {
        return telefone ;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone ;
    }
    public String getEndereco() {
        return endereco ;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco ;
    }
    public String getEmail() {
        return email ;
    }
    public void setEmail(String email) {
        this.email = email ;
    }
    public String toString() {
        return ("nome :" + nome + ", telefone:" + telefone + ", endereco:" + endereco + ", email:" + email) ;
    }
    public void listarClientes(String tipo_cliente) {
        int i ;
        if (tipo_cliente == "cpf") {
            for (i= 0;i < Seguradora.lista_clientes.size();i++) {
                System.out.println(Seguradora.lista_clientes.get(i).toString()) ;
            }
        }
    }
    public boolean gerarSinistro(Date data,String endereco,Seguradora seguradora,Veiculo veiculo,Cliente cliente) {
        int id ;
        Random gerador = new Random() ;
        id = gerador.nextInt() ;
        if (Sinistro.getListaIds().contains(id)) {
            return false ;
        }
        else {
            Sinistro sinistro = new Sinistro(data, endereco,seguradora,veiculo,cliente) ;
            lista_sinistros.add(sinistro) ;
            return true ;
        }
    }
    public boolean visualizarSinistro(Sinistro sinistro) {
        boolean indicador ;
        indicador = Sinistro.getListaIds().contains(sinistro.getId());
        if (indicador == true) {
            System.out.println(sinistro.toString());
            return true ;
        }
        else {
            return false ;
        }
    }
    public void listarSinistros() {
        int i ;
        for (i = 0;i < lista_sinistros.size();i++) {
            System.out.println(lista_sinistros.get(i).getId());
        }
    }
    public boolean cadastrarCliente(Cliente cliente) {
        if (lista_clientes.contains(cliente)) {
            return false ;
        }
        else {
            lista_clientes.add(lista_clientes.size(),cliente) ;
            return true ;
    }
    }
    public boolean removerCliente(Cliente cliente) {
        if (lista_clientes.contains(cliente)) {
            lista_clientes.remove(cliente) ;
            return true ;
        }
        else {
            return false ;
        }
    }
    
}
