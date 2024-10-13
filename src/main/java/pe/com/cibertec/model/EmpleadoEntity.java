package pe.com.cibertec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleado")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpleadoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dniempleado;
	
	@Column(name = "nombre_empleado", nullable = false, length = 45)
	private String nombre;
	
	@Column(name = "apellido_empleado", nullable = false, length = 45)
	private String apellido;

	@Column(name = "fecha_nacimiento", nullable = false,columnDefinition = "DATE")
	private String fechaNacimiento;
	
	@Column(name = "direccion", nullable = false,length = 45)
	private String direccion;
	
	@Column(name = "correo", nullable = false, length = 45)
	private String correo;
	
	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private AreaEntity areaEntity;
	
	
}

/*
@ManyToOne
@JoinColumn(name = "fk_tipo", nullable = false)
private TipoEntity tipoEntity;
*/