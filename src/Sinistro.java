import java.util.ArrayList;
import java.util.List ;
import java.util.Random;
import java.util.Date ;
public class Sinistro {
    private final int id ;
    private Date data ;
    private String endereco ;
    private Seguradora seguradora ;
    private Veiculo veiculo ;
    private Cliente cliente ;
    private static List<Integer> lista_ids = new ArrayList<Integer>();
    public Sinistro(Date data,String endereco,Seguradora seguradora,Veiculo veiculo,Cliente cliente) {
        int id ;
        Random gerador = new Random() ;
        id = gerador.nextInt() ;
        while (lista_ids.contains(id) == true) {
            id = gerador.nextInt() ;
        }
        this.id = id ;
        this.data = data ;
        this.endereco = endereco ;
        this.seguradora = seguradora ;
        this.veiculo = veiculo ;
        this.cliente = cliente ;
    }
    public int getId() {
        return id ;
    }
    public Date getData() {
        return data ;
    }
    public void setData(Date data) {
        this.data = data ;
    }
    public String getEndereco() {
        return endereco ;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco ;
    }
    public static List<Integer> getListaIds() {
        return lista_ids ;
    }
    public void adicionaId(int id) {
        lista_ids.add(id) ;
    }
    public Seguradora getSeguradora() {
        return seguradora ;
    }
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora ;
    }
    public Veiculo getVeiculo() {
        return veiculo ;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo ;
    }
    public Cliente getCliente() {
        return cliente ;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente ;
    }
    public String toString() {
        return ("id" + id + ", data:" + data + ", endereco" + endereco + ", seguradora" + seguradora.getNome() + ", veiculo" + veiculo.getModelo() + ", cliente :" + cliente.getNome()) ;
    }
}
