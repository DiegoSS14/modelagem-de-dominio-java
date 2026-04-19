package com.diego.shared;

import lombok.EqualsAndHashCode;
import lombok.Getter;

// Faz com que apenas parametros marcados sejam utilizados para comparação
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class Entity<ID extends Id<?>> {
    // Faz com que o ID seja um parametro de comparação do equals and hashcode
    @EqualsAndHashCode.Include
    private ID id;
    protected Entity(ID id) {
        if (id == null) {
            throw new IllegalArgumentException(Id.NULL_ID);
        }
        this.id = id;
    }    
}
