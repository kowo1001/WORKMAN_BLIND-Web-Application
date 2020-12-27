package workman.model.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SequenceGenerator(name = "company_seq_gen", sequenceName = "company_seq_id", initialValue = 1, allocationSize = 50) 

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq_gen")
	@Column(name = "company_name")
	private long companyname;
	
	@Column(name = "company_story")
	private long companystory;
	
	@Column(name = "company_loc")
	private long companyloc;
	
	@Column(name = "company_num")
	private long companynum;
	
	@OneToMany(mappedBy = "company")
	private List<Member> members;
	

}
