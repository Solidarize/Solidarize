
package com.solidarize.model;


public class CatEvent {
    private Category categoria;
    private Event evento;

    public CatEvent() {
    }
    
    public CatEvent(Category categoria, Event evento) {
        this.categoria = categoria;
        this.evento = evento;
    }

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        this.categoria = categoria;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }
}
