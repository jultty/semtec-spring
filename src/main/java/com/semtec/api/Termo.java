package com.semtec.api;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Termo {

    private @Id
    @GeneratedValue
    Long id;
    private String termo;
    private String significado;
    private String resumo;

    Termo() {
    }

    Termo(String termo, String significado, String resumo) {

        this.termo = termo;
        this.significado = significado;
        this.resumo = resumo;
    }

    public String getResumo() {
        return this.termo + ": " + this.significado;
    }

    public void setResumo(String resumo) {
        String[] partes = resumo.split(": ");
        this.termo = partes[0];
        this.significado = partes[1];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

        if (this == o)
            return true;
        if (!(o instanceof Termo))
            return false;
        Termo termo = (Termo) o;
        return Objects.equals(this.id, termo.id) &&
                Objects.equals(this.termo, termo.termo);
    }

    @Override
    public String toString() {
        return "Termo{" +
                "id=" + id +
                ", termo='" + termo + '\'' +
                ", significado='" + significado + '\'' +
                ", resumo='" + resumo + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}