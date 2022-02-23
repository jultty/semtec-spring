package com.semtec.api;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Termo {

    private @Id
    @GeneratedValue Long id;
    private String termo;
    private String significado;

    Termo() {}

    Termo(String termo, String significado) {

        this.termo = termo;
        this.significado = significado;
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
        if (!(o instanceof Termo termo))
            return false;
        return Objects.equals(this.id, termo.id) &&
                Objects.equals(this.termo, termo.termo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.termo, this.significado);
    }

    @Override
    public String toString() {
        return "Termo{" + "id=" + this.id + ",termo ='" +
                this.termo + '\'' + ", significado ='" + this.significado +
                '\'' + '}';
    }
}
