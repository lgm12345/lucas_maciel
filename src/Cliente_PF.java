import java.util.Date;
public class Cliente_PF extends Cliente {
    private final String cpf ;
    private String genero ;
    private Date dataLiscenca ;
    private String educacao ;
    private Date dataNascimento ;
    private String classeEconomica ;
    public Cliente_PF(String nome,String endereco,String cpf,String genero,Date dataLiscenca,String educacao,Date dataNascimento,String classeEconomica) throws Exception{
        super(nome, endereco) ;
        if (validarCPF(cpf)) {
            this.cpf = cpf ;
        }
        else {
            throw new Exception("cpf invalido") ;
        }
        this.genero = genero ;
        this.dataLiscenca = dataLiscenca ;
        this.educacao = educacao ;
        this.dataNascimento = dataNascimento ;
        this.classeEconomica = classeEconomica ;
       }
    public String getCpf() {
        return cpf ;
    }
    public Date getDataNascimento() {
        return dataNascimento ;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento ;
    }
    @Override
    public String toString() {
        return super.toString() + ", cpf:" + cpf + ", genero:" + genero + ", data de liscenca" + dataLiscenca + ", educacao" + educacao + "data de nascimento" + dataNascimento + ", classe economica:" + classeEconomica;
    }
    public boolean validarCPF(String cpf) {
        int i ;
        int primeiro_digito ;
        int segundo_digito ;
        boolean sao_iguais = true ;
        int[] lista = {10,9,8,7,6,5,4,3,2} ;
        String cpf_aux_1 = cpf.replaceAll("[^0-9]+", "");
        if (cpf_aux_1.length() != 11) {
            return false;
        } ;
        for (i = 0;i < 9;i++) {
            if (cpf_aux_1.charAt(i) != cpf_aux_1.charAt(i + 1)) {
                sao_iguais = false ;
            } ;
        } ;
        if (sao_iguais == true) {
            return false ;
        } ;
        int soma  = 0;
        //conversao do cpf_aux em inteiro
        int digito ;
        for (i = 0;i < 9;i++) {
            digito = Character.getNumericValue(cpf_aux_1.charAt(i)) ;
            soma = soma + (lista[i] * digito) ;
        } 
        int resto = soma % 11 ;
        if (resto == 0) {
            primeiro_digito = 0 ;
        }
        else if (resto == 1) {
            primeiro_digito = 0 ;
        }
        else {
            primeiro_digito = 11 - resto ;
        }
        //calculo do segundo digito verificador ;
        soma = 0 ;
        for (i = 0;i < 9 ;i++) {
            digito = Character.getNumericValue(cpf_aux_1.charAt(i + 1)) ;
            soma = soma + (lista[i] * digito) ;
        }
        soma = soma + (lista[8] * primeiro_digito) ;
        resto = soma % 11 ;
        if (resto == 0) {
            segundo_digito = 0 ;
        }
        else if (resto == 1) {
            segundo_digito = 0 ;
        }
        else {
            segundo_digito = 11 - resto ;
        }
        int aux_1 = Character.getNumericValue(cpf_aux_1.charAt(9)) ;
        int aux_2 = Character.getNumericValue(cpf_aux_1.charAt(10)) ;
        if (aux_1 == primeiro_digito & aux_2 == segundo_digito) {
            return true ;
        }
        else {
            return false ;
        }
    }
}