package zalho.com.br.ilhasguide.entities;

import java.math.BigDecimal;

/**
 * Created by andrepereira on 12/06/17.
 */

public class PontoTuristico {

    private int idPT;
    private String nomePT;
    private String descricaoPT;
    private String imagePathPT;
    private String enderecoPT;
    private BigDecimal precoPT;
    private boolean favorito;

    public PontoTuristico() {
    }

    public PontoTuristico(String nomePT, String descricaoPT, String imagePathPT, BigDecimal precoPT, String enderecoPT) {
        this.nomePT = nomePT;
        this.descricaoPT = descricaoPT;
        this.imagePathPT = imagePathPT;
        this.precoPT = precoPT;
        this.enderecoPT = enderecoPT;
    }

    public int getIdPT() {
        return idPT;
    }

    public void setIdPT(int idPT) {
        this.idPT = idPT;
    }

    public String getNomePT() {
        return nomePT;
    }

    public void setNomePT(String nomePT) {
        this.nomePT = nomePT;
    }

    public String getDescricaoPT() {
        return descricaoPT;
    }

    public void setDescricaoPT(String descricaoPT) {
        this.descricaoPT = descricaoPT;
    }

    public String getImagePathPT() {
        return imagePathPT;
    }

    public void setImagePathPT(String imagePathPT) {
        this.imagePathPT = imagePathPT;
    }

    public BigDecimal getPrecoPT() {
        return precoPT;
    }

    public void setPrecoPT(BigDecimal precoPT) {
        this.precoPT = precoPT;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getEnderecoPT() {
        return enderecoPT;
    }

    public void setEnderecoPT(String enderecoPT) {
        this.enderecoPT = enderecoPT;
    }
}
