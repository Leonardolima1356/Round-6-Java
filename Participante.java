public class Participante {
    private String nome;
    private int numero;
    private int idade;

    public Participante(String nome, int numero, int idade) {
        this.nome = nome;
        this.numero = numero;
        this.idade = idade > 0 ? idade : 0;
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

    @Override
    public String toString() {
        return "\nNome: " + nome + "\nNúmero: " + numero + "\nIdade: \n" + idade;
    }
}
