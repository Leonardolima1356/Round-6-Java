public class Participante {
    private String nome;
    private int numero;
    private int idade;
    private String dataNascimento;
    private String genero;
    private String endereco;

    public Participante(String nome, int numero, int idade, String dataNascimento, String genero, String endereco) {
        this.nome = nome;
        this.numero = numero;
        this.idade = idade > 0 ? idade : 0;
        this.dataNascimento = dataNascimento;
        setGenero(genero);
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public int getIdade() {
        return idade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        }
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setGenero(String genero) {
        if (genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Feminino")) {
            this.genero = genero;
        } else {
            this.genero = "Não especificado";
        }
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome +
               "\nNúmero: " + numero +
               "\nIdade: " + idade +
               "\nData de Nascimento: " + dataNascimento +
               "\nGênero: " + genero +
               "\nEndereço: " + endereco;
    }
}
