package ECamaraOrganizada;

import java.util.Objects;

/**
 * Representação abstrata de um Projeto , caracterizado pelo seu código de lei, dni de seu autor,
 * ementa, interesses e url, todos do tipo String e ano do tipo int.
 *
 */
public abstract class ProposicaoAbstract {
    /**
     * DNI do autor do projeto.
     */
    protected String dniAutor;
    /**
     * Ano da criação do projeto.
     */
    protected int ano;
    /**
     * Código do projeto.
     */
    protected String codigoLei;
    /**
     * Ementa do projeto.
     */
    protected String ementa;
    /**
     * Interesses do projeto.
     */
    protected String interesses;
    /**
     * Endereço URL do projeto.
     */
    protected String urlDocumento;
    /**
     * Situação em que se encontra o projeto.
     */
    protected String situacao;
    /**
     * Local onde o projeto se encontra para votação.
     */
    protected String localDeVotacao;
    /**
     * Indica o tipo de projeto (PL, PLP ou PEC).
     */
    protected String tipoDeProposicao;

    private boolean proposicaoAtiva;
    /**
     * Indica se uma proposta já foi votada no plenário.
     */
    private boolean passouNoPlenario;

    /**
     * Atributo que denota o estado conclusivo do Projeto de Lei.
     */
    protected boolean conclusivo;

    /**
     * Método responsável por criar um Projeto de Emenda Constitucional no sistema, cujos dados: dni,
     * ementa, interesses, url e artigos, todos do tipo String, ano do tipo int
     * são passados como parâmetro.
     *
     * Inicializa o atributo situação como "EM VOTACAO (CCJC)".
     *
     * @param codigoLei código da lei.
     * @param dniAutor dni do autor do projeto.
     * @param ementa ementa do projeto.
     * @param interesses interesses do projeto.
     * @param urlDocumento endereço url do projeto.
     * @param ano ano de criacção do projeto
     *
     *
     */
    public ProposicaoAbstract(String dniAutor, Integer ano, String codigoLei, String ementa, String interesses, String urlDocumento) {
        this.dniAutor = dniAutor;
        this.ano = ano;
        this.codigoLei = codigoLei;
        this.ementa = ementa;
        this.interesses = interesses;
        this.urlDocumento = urlDocumento;
        this.situacao = "EM VOTACAO (CCJC)";
        this.localDeVotacao = "CCJC";
        this.proposicaoAtiva = true;
        this.passouNoPlenario = false;
    }

    /**
     * Método que sobreescreve o método equals de Objects para se enquadrar nos moldes
     * da classe ProposicaoAbstract. Um projeto é igual a outro projeto se ambos possuírem código de lei iguais.
     *
     * @param o parâmetro a ser comparado.
     *
     * @return true, se os objetos forem iguais, false, se os objetos forem diferentes
     *                                                    ou se o objeto passado como parâmetro for null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProposicaoAbstract that = (ProposicaoAbstract) o;
        return codigoLei.equals(that.codigoLei);
    }

    /**
     * Método que sobreescreve o método hashcode de Objects para se enquadrar nos moldes
     * da classe ProposicaoAbstract. Um projeto é igual a outro se ambos possuírem o mesmo código de lei,
     * portanto devem possuir o mesmo hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(codigoLei);
    }

    /**
     * Retorna a representação em String do projeto. A representação
     * segue o formato: - this.código da lei - dni do autor - ementa -
     *
     * É usado para compor o toString individual de cada tipo específico
     * de projeto de lei.
     *
     * @return retorna a representação em String do projeto
     */
    @Override
    public String toString(){
        return " - " + this.codigoLei + " - " + this.dniAutor +
                " - " + this.ementa + " - ";
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDniAutor() {
        return dniAutor;
    }

    public String getInteresses() {
        return interesses;
    }

    public String getLocalDeVotacao() {
        return localDeVotacao;
    }

    /**
     * Altera o local no qual o projeto se encontra para ser votado a partir de um novo
     * local passado como parâmetro.
     *
     * @param localDeVotacao novo local de votação.
     */
    public void setLocalDeVotacao(String localDeVotacao) {
        this.localDeVotacao = localDeVotacao;
    }

    public boolean isConclusivo() {
        return conclusivo;
    }

    public boolean getProposicaoAtiva() {
        return proposicaoAtiva;
    }

    public void setProposicaoAtiva(boolean proposicaoAtiva) {
        this.proposicaoAtiva = proposicaoAtiva;
    }

    /**
     * Retorna uam String que indica o tipo do projeto (PL, PLP ou PEC).
     *
     * @return uma String que indica o tipo do projeto.
     */
    public String getTipoDeProposicao() {
        return tipoDeProposicao;
    }

    /**
     * Altera o atributo passouNoPlenario a partir de um novo status passado como
     * parâmetro.
     *
     * @param passouNoPlenario novo status.
     */
    public void setPassouNoPlenario(boolean passouNoPlenario) {
        this.passouNoPlenario = passouNoPlenario;
    }

    /**
     * Retorna um boolean que indica se um determinado projeto já passou pelo plenário.
     *
     * @return um boolean que indica se o projeto já passou no plenário.
     */
    public boolean getPassouNoPlenario() {
        return passouNoPlenario;
    }
}
