package com.pe.ttk.admision.entity.master;

import com.pe.ttk.admision.entity.oferta.Oferta;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name ="encargado")
public class Encargado  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String apellido;
    @Email
    @Column(nullable = true, length = 100)
    private String email;
    @Column(nullable = true, length = 100)
    private String telefono;


}
