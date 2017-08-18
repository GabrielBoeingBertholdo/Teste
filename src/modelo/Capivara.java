/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author (name= Gabriel Boeing,date=07-21-2017)
 */
public class Capivara {

    private String nome,sobreNome,nomeCientifico,localDorme,clasNatcao,qtdDentes,qtdFilhotes,qtdSelfies,qtdJaComeu;
    private int altura,registroIbama,registroGeral;
    private float peso;
    
    public Capivara() {
        
    }
    
    /**
     * 
     * @param nome
     * @param sobreNome
     * @param nomeCientifico
     * @param localDorme
     * @param clasNatcao
     * @param qtdDentes
     * @param qtdFilhotes
     * @param qtdSelfies
     * @param qtdJaComeu
     * @param altura
     * @param registroIbama
     * @param registroGeral
     * @param peso 
     */
    public Capivara(String nome, String sobreNome, String nomeCientifico, String localDorme, String clasNatcao, String qtdDentes, String qtdFilhotes, String qtdSelfies, String qtdJaComeu, int altura, int registroIbama, int registroGeral, float peso) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.nomeCientifico = nomeCientifico;
        this.localDorme = localDorme;
        this.clasNatcao = clasNatcao;
        this.qtdDentes = qtdDentes;
        this.qtdFilhotes = qtdFilhotes;
        this.qtdSelfies = qtdSelfies;
        this.qtdJaComeu = qtdJaComeu;
        this.altura = altura;
        this.registroIbama = registroIbama;
        this.registroGeral = registroGeral;
        this.peso = peso;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getLocalDorme() {
        return localDorme;
    }

    public void setLocalDorme(String localDorme) {
        this.localDorme = localDorme;
    }

    public String getClasNatcao() {
        return clasNatcao;
    }

    public void setClasNatcao(String clasNatcao) {
        this.clasNatcao = clasNatcao;
    }

    public String getQtdDentes() {
        return qtdDentes;
    }

    public void setQtdDentes(String qtdDentes) {
        this.qtdDentes = qtdDentes;
    }

    public String getQtdFilhotes() {
        return qtdFilhotes;
    }

    public void setQtdFilhotes(String qtdFilhotes) {
        this.qtdFilhotes = qtdFilhotes;
    }

    public String getQtdSelfies() {
        return qtdSelfies;
    }

    public void setQtdSelfies(String qtdSelfies) {
        this.qtdSelfies = qtdSelfies;
    }

    public String getQtdJaComeu() {
        return qtdJaComeu;
    }

    public void setQtdJaComeu(String qtdJaComeu) {
        this.qtdJaComeu = qtdJaComeu;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getRegistroIbama() {
        return registroIbama;
    }

    public void setRegistroIbama(int registroIbama) {
        this.registroIbama = registroIbama;
    }

    public int getRegistroGeral() {
        return registroGeral;
    }

    public void setRegistroGeral(int registroGeral) {
        this.registroGeral = registroGeral;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

  


    
    
}
