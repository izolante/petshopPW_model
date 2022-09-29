package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Izolante
 */

@Entity
@Table(name = "pet")
public class Pet implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_pet", sequenceName = "seq_pet_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pet", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome do pet não pode ser nulo")
    @Length(max = 50, message = "O nome precisa estar dentro do limite de {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @NotBlank(message = "A data de nascimento não pode ser nula")
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @NotBlank(message = "O peso do pet não pode ser nulo")
    @Column(name = "peso", nullable = false)
    private Double peso;
    
    @NotBlank(message = "A espécie do pet não pode ser nula")
    @Length(max = 50, message = "A espécie precisa estar dentro do limite de {max} caracteres")
    @Column(name = "especie", nullable = false, length = 50)
    private String especie;
    
    @NotNull(message = "A raça do pet não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "raca", referencedColumnName = "id", nullable = false)
    private Raca raca;

    public Pet(){
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

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }
    
    
}
