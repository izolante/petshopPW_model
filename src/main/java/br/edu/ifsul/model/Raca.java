package br.edu.ifsul.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Izolante
 */
@Entity
@Table(name = "raca")
public class Raca implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_raca", sequenceName = "seq_raca_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_raca", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome da raça não pode ser nulo")
    @Length(max = 50, message = "O nome precisa estar dentro do limite de {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    public Raca(){
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return getId().toString();
    }
    
}
