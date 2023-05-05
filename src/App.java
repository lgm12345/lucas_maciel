import java.util.Date;
import java.text.SimpleDateFormat;
public class App {
    public static SimpleDateFormat formata_data = new SimpleDateFormat("DD//MM/YYYY") ;
    public static void main(String[] args) {
        try {
            // leitura da data
            Date data = new Date() ;
            // instanciação da seguradora
            Seguradora seguradora = new Seguradora("Porto Seguros","41-3273-7414","portoseguros@gmail.com","rua XX") ;
           // instanciação dos clientes PF e PJ
           Cliente_PF cliente_pf = new Cliente_PF("Lucas","rua YY","052.700.529-03","masculino", data,"ensino superior completo", data,"media") ;
           Cliente_PJ cliente_pj = new Cliente_PJ("Andre", "rua ZZ","", data) ;
           // instanciação dos veículos 
           Veiculo veiculo_1 = new Veiculo("placa_1","marca_1","modelo_1", 2010) ;
           Veiculo veiculo_2 = new Veiculo("placa_2","marca_2","modelo_2",2011) ;
           //adicionando um veiculo em cada cliente cadastrado
           cliente_pf.adicionaLista(veiculo_1) ;
           cliente_pj.adicionaLista(veiculo_2) ;
           // cadastrando os clientes na seguradora 
           seguradora.cadastrarCliente(cliente_pj) ;
           seguradora.cadastrarCliente(cliente_pf) ;
           // gererando um sinistro
           seguradora.gerarSinistro(data,"rua ZY", seguradora, veiculo_2, cliente_pj) ;
           // removendo um cliente 
           seguradora.removerCliente(cliente_pj) ;
           //testando os metodos to_string
           System.out.println(veiculo_1.toString());
           System.out.println(seguradora.toString()) ;
           System.out.println(cliente_pf.toString());
           System.out.println(cliente_pj.toString());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

}
