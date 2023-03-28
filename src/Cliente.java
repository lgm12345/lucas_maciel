public class Cliente {
    private String nome ;
    private String cpf ;
    private String dataNascimento ;
    private int idade ;
    private String endereco ;
    
    // construtor

    public Cliente(String nome,String cpf,String dataNascimento,int idade,String endereco) {
        this.nome = nome ;
        this.cpf = cpf ;
        this.dataNascimento = dataNascimento ;
        this.idade = idade ;
        this.endereco = endereco ;
    }
    
    // setters e getters

    public String getNome() {
        return nome ;
    }
    public void setNome(String nome) {
        this.nome = nome ;
    }
    public String getCpf() {
        return cpf ;
    } 
    public void setCpf(String cpf) {
        this.cpf = cpf ;
    }
    public String getDataNascimento() {
        return dataNascimento ;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento ;
    }
    public int getIdade() {
        return idade ;
    }
    public void setIdade(int idade) {
        this.idade = idade ;
    }
    public String getEndereco() {
        return endereco ;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco ;
    }
    public String toString() {
        return ("nome :" + nome + "cpf:" + cpf + "data nascimento" + dataNascimento + "idade" + idade + "endereco" + endereco) ;
    }
    public String validarCPF(String cpf) {
        int i ;
        String string ;
        int primeiro_digito ;
        int segundo_digito ;
        boolean sao_iguais = true ;
        int[] lista = {10,9,8,7,6,5,4,3,2} ;
        String cpf_aux_1 = cpf.replaceAll("[^0-9]+", "");
        if (cpf_aux_1.length() != 11) {
            string = "cpf invalido" ;
            return string;
        } ;
        for (i = 0;i < 9;i++) {
            if (cpf_aux_1.charAt(i) != cpf_aux_1.charAt(i + 1)) {
                sao_iguais = false ;
            } ;
        } ;
        if (sao_iguais == true) {
            string = "cpf invalido" ;
            return string ;
        } ;
        int soma  = 0;
        //conversao do cpf_aux em inteiro
        int digito ;
        for (i = 0;i < 10;i++) {
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
        soma = soma + (lista[9] * primeiro_digito) ;
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
            string = "cpf valido" ;
            return string ;
        }
        else {
            string = "cpf invalido";
            return string ;
        }
    }   
    }

