package Kodlama.io.devs2.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="technologies")
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="technologyId")
	private int id;
	
	@Column(name = "name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "programming_language_id")
	private Language languages;
	
}
