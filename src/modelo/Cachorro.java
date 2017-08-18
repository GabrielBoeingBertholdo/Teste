package modelo;

/**
 *
 * @author (name= Gabriel Boeing,date=07-21-2017)
 * */
public class Cachorro {

    // atributos -> caracteristicas

    private String nome, raca;
    private float peso;
    private boolean vivo;
    private int tamanho;
    private char sexo;

    public Cachorro(){
        
    }
    
    /**
     * 
     * @param nome
     * @param raca
     * @param peso
     * @param vivo
     * @param tamanho
     * @param sexo 
     */
    public Cachorro(String nome, String raca, float peso, boolean vivo, int tamanho, char sexo) {
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
        this.vivo = vivo;
        this.tamanho = tamanho;
        this.sexo = sexo;
    }
    

    // metodo que permite acessar os atributos privados com 
    //encapsulamento private
    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public float getPeso() {
        return peso;
    }

    // variavel do tipo boolean verifica se eh verdade ou nao
    public boolean isVivo() {
        return vivo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public char getSexo() {
        return sexo;
    }

    // set: metodo que permite definir/alterar/
    // os atributos que estao com encapsulamento private
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}
