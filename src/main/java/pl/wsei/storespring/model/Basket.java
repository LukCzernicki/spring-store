package pl.wsei.storespring.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "item")
	private List<Item> items;
	//private String item;
	@ManyToOne
	@JoinColumn(name = "promotion_id")
	private Promotion promotion;

	@OneToOne
	@JoinColumn(name = "user_id", unique = true)
	private User user;

	public long getId() {

		return id;
	}

	public void setId(long id) {

		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
