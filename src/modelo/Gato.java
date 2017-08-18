/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



/**
 *
 * @author (name= Gabriel Boeing,date=07-22-2017)
 */
public class Gato {
    
    private String nome,raca,nivelPreguica,racao,nomeDono,cordaPataTraseiraDireita,corDaPataTraseiraEsquerda,corDaPataFrontalDireita,corDaPataFrontalEsquerda,corDoOlhoDireito,corOlhoEsquerdo;
    private int quantidadeVidas,quantidadeDeFiosDePelos;
    private byte idade,qtdcirurgias,qtdFilhotes;       
    private float comprimento,altura,peso;  
    private char sexo,tossa,cirurgia,pedigree,filhotes,castrado;
    

    //JTextField:
    //nome,nomeDono,racao
    
    //JFormattedTextField:
    //peso,altura,comprimento,quantidadeVidas,quantidadeDeFiosDePelos
    
    //JComboBox:          Problema ver !!! ----------- qtdFilhotes e qtdcirurgias
    //cordaPataTraseiraDireita,corDaPataTraseiraEsquerda,corDaPataFrontalDireita,corDaPataFrontalEsquerda,corDoOlhoDireito,corOlhoEsquerdo,raca,nivelPreguica,qtdcirurgias,qtdFilhotes
    
    //JRadioButton:       Problema ver !!! ----------- filhotes e cirurgia
    //sexo,tossa,cirurgia,pedigree,filhotes,castrado

    
    public Gato(){
        
    }
    
    /**
     * 
     * @param nome
     * @param raca
     * @param nivelPreguica
     * @param racao
     * @param nomeDono
     * @param cordaPataTraseiraDireita
     * @param corDaPataTraseiraEsquerda
     * @param corDaPataFrontalDireita
     * @param corDaPataFrontalEsquerda
     * @param corDoOlhoDireito
     * @param corOlhoEsquerdo
     * @param quantidadeVidas
     * @param quantidadeDeFiosDePelos
     * @param idade
     * @param qtdcirurgias
     * @param qtdFilhotes
     * @param comprimento
     * @param altura
     * @param peso
     * @param sexo
     * @param tossa
     * @param cirurgia
     * @param pedigree
     * @param filhotes
     * @param castrado 
     */
    public Gato(String nome, String raca, String nivelPreguica, String racao, String nomeDono, String cordaPataTraseiraDireita, String corDaPataTraseiraEsquerda, String corDaPataFrontalDireita, String corDaPataFrontalEsquerda, String corDoOlhoDireito, String corOlhoEsquerdo, int quantidadeVidas, int quantidadeDeFiosDePelos, byte idade, byte qtdcirurgias, byte qtdFilhotes, float comprimento, float altura, float peso, char sexo, char tossa, char cirurgia, char pedigree, char filhotes, char castrado) {
        this.nome = nome;
        this.raca = raca;
        this.nivelPreguica = nivelPreguica;
        this.racao = racao;
        this.nomeDono = nomeDono;
        this.cordaPataTraseiraDireita = cordaPataTraseiraDireita;
        this.corDaPataTraseiraEsquerda = corDaPataTraseiraEsquerda;
        this.corDaPataFrontalDireita = corDaPataFrontalDireita;
        this.corDaPataFrontalEsquerda = corDaPataFrontalEsquerda;
        this.corDoOlhoDireito = corDoOlhoDireito;
        this.corOlhoEsquerdo = corOlhoEsquerdo;
        this.quantidadeVidas = quantidadeVidas;
        this.quantidadeDeFiosDePelos = quantidadeDeFiosDePelos;
        this.idade = idade;
        this.qtdcirurgias = qtdcirurgias;
        this.qtdFilhotes = qtdFilhotes;
        this.comprimento = comprimento;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.tossa = tossa;
        this.cirurgia = cirurgia;
        this.pedigree = pedigree;
        this.filhotes = filhotes;
        this.castrado = castrado;
    }

    public Gato(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNivelPreguica() {
        return nivelPreguica;
    }

    public void setNivelPreguica(String nivelPreguica) {
        this.nivelPreguica = nivelPreguica;
    }

    public String getRacao() {
        return racao;
    }

    public void setRacao(String racao) {
        this.racao = racao;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getCordaPataTraseiraDireita() {
        return cordaPataTraseiraDireita;
    }

    public void setCordaPataTraseiraDireita(String cordaPataTraseiraDireita) {
        this.cordaPataTraseiraDireita = cordaPataTraseiraDireita;
    }

    public String getCorDaPataTraseiraEsquerda() {
        return corDaPataTraseiraEsquerda;
    }

    public void setCorDaPataTraseiraEsquerda(String corDaPataTraseiraEsquerda) {
        this.corDaPataTraseiraEsquerda = corDaPataTraseiraEsquerda;
    }

    public String getCorDaPataFrontalDireita() {
        return corDaPataFrontalDireita;
    }

    public void setCorDaPataFrontalDireita(String corDaPataFrontalDireita) {
        this.corDaPataFrontalDireita = corDaPataFrontalDireita;
    }

    public String getCorDaPataFrontalEsquerda() {
        return corDaPataFrontalEsquerda;
    }

    public void setCorDaPataFrontalEsquerda(String corDaPataFrontalEsquerda) {
        this.corDaPataFrontalEsquerda = corDaPataFrontalEsquerda;
    }

    public String getCorDoOlhoDireito() {
        return corDoOlhoDireito;
    }

    public void setCorDoOlhoDireito(String corDoOlhoDireito) {
        this.corDoOlhoDireito = corDoOlhoDireito;
    }

    public String getCorOlhoEsquerdo() {
        return corOlhoEsquerdo;
    }

    public void setCorOlhoEsquerdo(String corOlhoEsquerdo) {
        this.corOlhoEsquerdo = corOlhoEsquerdo;
    }

    public int getQuantidadeVidas() {
        return quantidadeVidas;
    }

    public void setQuantidadeVidas(int quantidadeVidas) {
        this.quantidadeVidas = quantidadeVidas;
    }

    public int getQuantidadeDeFiosDePelos() {
        return quantidadeDeFiosDePelos;
    }

    public void setQuantidadeDeFiosDePelos(int quantidadeDeFiosDePelos) {
        this.quantidadeDeFiosDePelos = quantidadeDeFiosDePelos;
    }

    public byte getIdade() {
        return idade;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

    public byte getQtdcirurgias() {
        return qtdcirurgias;
    }

    public void setQtdcirurgias(byte qtdcirurgias) {
        this.qtdcirurgias = qtdcirurgias;
    }

    public byte getQtdFilhotes() {
        return qtdFilhotes;
    }

    public void setQtdFilhotes(byte qtdFilhotes) {
        this.qtdFilhotes = qtdFilhotes;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getTossa() {
        return tossa;
    }

    public void setTossa(char tossa) {
        this.tossa = tossa;
    }

    public char getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(char cirurgia) {
        this.cirurgia = cirurgia;
    }

    public char getPedigree() {
        return pedigree;
    }

    public void setPedigree(char pedigree) {
        this.pedigree = pedigree;
    }

    public char getFilhotes() {
        return filhotes;
    }

    public void setFilhotes(char filhotes) {
        this.filhotes = filhotes;
    }

    public char getCastrado() {
        return castrado;
    }

    public void setCastrado(char castrado) {
        this.castrado = castrado;
    }
    

    
    
    
    
    
    
}
