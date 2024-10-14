package pe.com.cibertec.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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


@Entity
@Table(name = "tb_empleado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dni_empleado")
	private Integer dniempleado;
	
	@Column(name = "nombre_empleado", nullable = false, length = 45)
	private String nombre;
	
	@Column(name = "apellido_empleado", nullable = false, length = 45)
	private String apellido;

	@Column(name = "fecha_nacimiento", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	@Column(name = "direccion", nullable = false,length = 45)
	private String direccion;
	
	@Column(name = "correo", nullable = false, length = 45)
	private String correo;
	
	@ManyToOne
	@JoinColumn(name = "fk_area", nullable = false)
	private AreaEntity areaEntity;
	
	
}
