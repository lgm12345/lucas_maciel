import java.util.Date;
public class Cliente_PJ extends Cliente {
    private final String cnpj ;
    private Date dataFundacao ;
    public Cliente_PJ(String nome,String endereco,String cnpj,Date dataFundacao) throws Exception{
        super(nome,endereco) ;
        if (ValidarCnpj(cnpj) == "cnpj valido") {
            this.cnpj = cnpj ;
        }
        else {
            throw new Exception("cnpj invalido") ;
        }
        this.dataFundacao = dataFundacao ;
    }
    public String getCnpj() {
        return cnpj ;
    }
    public Date getDataLiscenca() {
        return dataFundacao ;
    }
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao ;
    }
    @Override
    public String toString() {
        return super.toString() + ", cnpj:" + cnpj + ", data de fundacao" + dataFundacao ;
    }
    public String ValidarCnpj(String cnpj) {
        int i ;
        int primeiro_digito ;
        int segundo_digito ;
        boolean sao_iguais = true ;
        String string ;
        int[] lista_1 = {2,3,4,5,6,7,8,9,2,3,4,5} ;
        int[] lista_2 = {2,3,4,5,6,7,8,9,2,3,4,5,6} ;
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        if (cnpj.length() != 11) {
            return "cnpj invalido" ;
        }
        for (i = 0;i < 10;i++) {
            if (cnpj.charAt(i) != cnpj.charAt(i +1)) {
                sao_iguais = false ;
            }
        }
        if (sao_iguais == true) {
            return "cnpj invalido" ;
        }
        int soma ;
        soma = 0 ;
        int digito_aux ;
        for (i = 0;i < 11;i++) {
            digito_aux = Character.digit(cnpj.charAt(11 - i),10) ;
            soma = soma + (lista_1[i] * digito_aux) ;
        }
        int resto ;
        resto = soma % 11 ;
        if (resto == 1) {
            primeiro_digito = 0 ;
        }
        else if (resto == 0) {
            primeiro_digito = 0 ;
        }
        else {
            primeiro_digito = 11 - resto ;
        }
        soma = lista_2[0] * primeiro_digito ;
        for (i = 1;i < 13;i++) {
            soma = soma + (lista_2[i] * cnpj.charAt(i - 1)) ;
        }
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
        int aux_1 = Character.getNumericValue(cnpj.charAt(12)) ;
        int aux_2 = Character.getNumericValue(cnpj.charAt(13)) ;
        if (aux_1 == primeiro_digito & aux_2 == segundo_digito) {
            string = "cpf valido" ;
            return string ;
        }
        else {
            string = "cpf invalido";
            return string ;
        }
}
}