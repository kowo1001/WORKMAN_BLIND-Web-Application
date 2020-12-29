package workman.model.dto;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SequenceGenerator(name = "partlist_seq_gen", sequenceName = "partlist_seq_id", initialValue = 1, allocationSize = 50)

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
public class ParttimeList {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partlist_seq_gen")
	@Column(name="text_list")
	private Long textlist;
	
	@ManyToOne
	@JoinColumn(name="company_name")
	private Company companyname;

	@OneToMany
	@JoinColumn(name="user_id")
	private List<Member> userid;

	@Column(name="review_num")
	private int reviewnum;
	
	@Column(name="review_score")
	private int reviewscore;
	
	@Column(name="recruit_status")
	private String recruitstatus;
	
	@Column(name="regist_date")
	private String date;
	
	@Column(name="emp_period")
	private String empperiod;
	
}

