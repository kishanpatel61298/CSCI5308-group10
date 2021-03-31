package dal.asdc.model;

//https://github.com/Java-Techie-jt/Spring-boot-mysql/blob/master/pom.xml
//References
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Player")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Player {
	@Id
	@GeneratedValue
	private int player_id;
	private String player_name;
	private String player_email;
	private String player_password;
	private String acc_created_date;

}

