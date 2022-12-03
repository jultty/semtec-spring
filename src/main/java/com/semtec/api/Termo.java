package com.semtec.api;

import java.util.Objects;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;

import java.text.Normalizer;

@Entity
class Termo {

    static String FRONT_URL="https://semtec.netlify.app/";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column
    private String termo;

    @Column
    private String significado;

    @Column
    private String resumo;

    @Column
    private String pagina;

    @Column
    private String tag;

    @Column
    private String paginaTag;

    Termo() {
    }

    Termo(String termo, String significado, String resumo, String pagina, String tag, String paginaTag) {
        this.termo = termo;
        this.significado = significado;
        this.resumo = resumo;
        this.pagina = pagina;
        this.tag = tag;
        this.paginaTag = paginaTag;
    }

    public String getFRONT_URL() { return FRONT_URL; }

    public String getResumo() {
        return this.termo + ": " + this.significado;
    }

    public void setResumo(String resumo) {
        String[] partes = resumo.split(": ");
        this.termo = partes[0];
        this.significado = partes[1];
    }

    public String getPagina() {
        String termoNormalizado = Normalizer.normalize(this.termo,
                Normalizer.Form.NFD);
        termoNormalizado = termoNormalizado.replaceAll(
                "[^\\p{ASCII}]", "");
        try {
        return FRONT_URL + "termo/" + URLEncoder.encode(termoNormalizado,
                StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public void setPagina(String pagina) {
        String[] partes = pagina.split("/termo/");
        partes[0] = FRONT_URL + "termo/";
        this.pagina = partes[0] + partes[1];
    }

    public String getTag() { return tag; }

    public void setTag(String tag) { this.tag = tag; }

    public String getPaginaTag() {
        return FRONT_URL + "tag/" + this.tag;
    }

    public void setPaginaTag(String tag) {
        String[] partes = paginaTag.split("/tag/");
        partes[0] = FRONT_URL + "tag/";
        this.pagina = partes[0] + partes[1];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Termo termo1 = (Termo) o;
        return id.equals(termo1.id) && Objects.equals(termo, termo1.termo) && Objects.equals(significado, termo1.significado) && Objects.equals(resumo, termo1.resumo) && Objects.equals(pagina, termo1.pagina) && Objects.equals(tag, termo1.tag) && Objects.equals(paginaTag, termo1.paginaTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, termo, significado, resumo, pagina, tag, paginaTag);
    }

    @Override
    public String toString() {
        return "Termo{" +
                "id=" + id +
                ", termo='" + termo + '\'' +
                ", significado='" + significado + '\'' +
                ", resumo='" + resumo + '\'' +
                ", pagina='" + pagina + '\'' +
                ", tag='" + tag + '\'' +
                ", paginaTag='" + paginaTag + '\'' +
                '}';
    }
}
