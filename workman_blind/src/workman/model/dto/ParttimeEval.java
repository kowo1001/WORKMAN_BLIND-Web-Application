/**
CREATE TABLE parttimeeval (
	   texteval             NUMBER(10) PRIMARY KEY,
       textlist             VARCHAR2(50),
       userid      VARCHAR2(20) NOT NULL,
       companyname 		VARCHAR2(20) NOT NULL,
       proscons     VARCHAR2(20) NOT NULL,
       hourlywage   			NUMBER(10) NOT NULL,
       environment          VARCHAR2(20) NOT NULL,
       incline        VARCHAR2(20) NOT NULL,
       workdif   VARCHAR2(20) NOT NULL,
       experience   VARCHAR2(50) NOT NULL
); */
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

@SequenceGenerator(name = "parteval_seq_gen", sequenceName = "parteval_seq_id", initialValue = 1, allocationSize = 50) 

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Entity
public class ParttimeEval {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parteval_seq_gen")
	@Column(name = "text_eval")
	private long texteval;
	
	@ManyToOne
	@Column(name = "text_list")
	private ParttimeList textlist;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Member userid; 
	
	@ManyToOne
	@JoinColumn(name = "company_name")
	private Company companyname;
	
	@Column(name = "pros_cons")
	private String proscons;

	@Column(name = "hourly_wage")
	private long hourlywage;
	
	@Column(name = "environment")
	private String environment;
	
	@Column(name = "incline")
	private String incline;
	
	@Column(name = "work_dif")
	private String workdif;
	
	@Column(name = "experience")
	private String experience;

}
