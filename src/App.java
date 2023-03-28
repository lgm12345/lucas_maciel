public class App {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("BRA2E19","Ford","Focus" ) ;
        Cliente cliente = new Cliente("Lucas","052.700.529-03","07/01/2000",23,"Campinas");
        Sinistro sinistro = new Sinistro(12345,"10/08/21","campinas") ;
        Seguradora seguradora = new Seguradora("Porto Seguros","11-988399061","Campinas","portoseguros@gmail.com") ;
        //testando getters e setters da classe Veiculo:
        System.out.println(veiculo.getPlaca());
        veiculo.setMarca("Fiat");
        System.out.println(veiculo.getMarca()) ;
        //testando getters e setters da classe Seguradora:
        System.out.println(seguradora.getNome());
        seguradora.setNome("Alianz Seguros");
        System.out.println(seguradora.getNome()) ;
        //testando getters e setters da classe Sinistro ;
        System.out.println(sinistro.getData());
        sinistro.setData("01/02/15");
        System.out.println(sinistro.getData()) ;
        //testando getters e setters da classe Cliente ;
        System.out.println(cliente.getNome()) ;
        cliente.setNome("Joao") ;
        System.out.println(cliente.getNome()) ;
        //testando o metodo toString da classe Cliente:
        System.out.println(cliente.toString()) ;
        //testando o metodo Validar cpf da classe Cliente:
        System.out.println(cliente.validarCPF(cliente.getCpf())) ;
    }
    


}