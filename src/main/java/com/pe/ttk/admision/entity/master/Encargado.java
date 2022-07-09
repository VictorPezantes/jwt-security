package com.pe.ttk.admision.entity.master;

import com.pe.ttk.admision.entity.oferta.Oferta;
import lombok.*;

import javax.persistence.*;
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
    @Column(nullable = false, length = 20)
    private String nombre;
    @Column(nullable = false, length = 20)
    private String apellido;
    @Column(nullable = true, length = 20)
    private String email;
    @Column(nullable = true, length = 100)
    private String telefono;


}
