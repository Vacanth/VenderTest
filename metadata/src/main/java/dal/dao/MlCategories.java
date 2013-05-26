package dal.dao;

// Generated May 10, 2013 2:06:06 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MlCategories generated by hbm2java
 */
@Entity
@Table(name = "ml_categories", catalog = "stool")
public class MlCategories implements java.io.Serializable {

	private Integer categoryId;
	private String meliCategoryId;
	private String meliCategoryName;
	private String siteId;
	private boolean hasAttributes;
	private String rootId;
	private boolean listingAllowed;
	private boolean buyingAllowed;

	public MlCategories() {
	}

	public MlCategories(boolean hasAttributes, String rootId,
			boolean listingAllowed, boolean buyingAllowed) {
		this.hasAttributes = hasAttributes;
		this.rootId = rootId;
		this.listingAllowed = listingAllowed;
		this.buyingAllowed = buyingAllowed;
	}

	public MlCategories(String meliCategoryId, String meliCategoryName,
			String siteId, boolean hasAttributes, String rootId,
			boolean listingAllowed, boolean buyingAllowed) {
		this.meliCategoryId = meliCategoryId;
		this.meliCategoryName = meliCategoryName;
		this.siteId = siteId;
		this.hasAttributes = hasAttributes;
		this.rootId = rootId;
		this.listingAllowed = listingAllowed;
		this.buyingAllowed = buyingAllowed;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "meli_category_id", length = 100)
	public String getMeliCategoryId() {
		return this.meliCategoryId;
	}

	public void setMeliCategoryId(String meliCategoryId) {
		this.meliCategoryId = meliCategoryId;
	}

	@Column(name = "meli_category_name", length = 200)
	public String getMeliCategoryName() {
		return this.meliCategoryName;
	}

	public void setMeliCategoryName(String meliCategoryName) {
		this.meliCategoryName = meliCategoryName;
	}

	@Column(name = "site_id", length = 100)
	public String getSiteId() {
		return this.siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	@Column(name = "has_attributes", nullable = false)
	public boolean isHasAttributes() {
		return this.hasAttributes;
	}

	public void setHasAttributes(boolean hasAttributes) {
		this.hasAttributes = hasAttributes;
	}

	@Column(name = "root_id", nullable = false, length = 20)
	public String getRootId() {
		return this.rootId;
	}

	public void setRootId(String rootId) {
		this.rootId = rootId;
	}

	@Column(name = "listing_allowed", nullable = false, length = 2)
	public boolean getListingAllowed() {
		return this.listingAllowed;
	}

	public void setListingAllowed(boolean listingAllowed) {
		this.listingAllowed = listingAllowed;
	}

	@Column(name = "buying_allowed", nullable = false, length = 2)
	public boolean getBuyingAllowed() {
		return this.buyingAllowed;
	}

	public void setBuyingAllowed(boolean buyingAllowed) {
		this.buyingAllowed = buyingAllowed;
	}

}
