package dal.dao;

// Generated May 10, 2013 2:06:06 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MlCategoriesDumpDate generated by hbm2java
 */
@Entity
@Table(name = "ml_categories_dump_date", catalog = "stool")
public class MlCategoriesDumpDate implements java.io.Serializable {

	private String siteId;
	private Date dumpDate;
	private Date createDate;
	private Date modifiedDate;
	private String changeWho;

	public MlCategoriesDumpDate() {
	}

	public MlCategoriesDumpDate(String siteId) {
		this.siteId = siteId;
	}

	public MlCategoriesDumpDate(String siteId, Date dumpDate, Date createDate,
			Date modifiedDate, String changeWho) {
		this.siteId = siteId;
		this.dumpDate = dumpDate;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.changeWho = changeWho;
	}

	@Id
	@Column(name = "SITE_ID", unique = true, nullable = false, length = 100)
	public String getSiteId() {
		return this.siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DUMP_DATE", length = 19)
	public Date getDumpDate() {
		return this.dumpDate;
	}

	public void setDumpDate(Date dumpDate) {
		this.dumpDate = dumpDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", length = 19)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "CHANGE_WHO", length = 45)
	public String getChangeWho() {
		return this.changeWho;
	}

	public void setChangeWho(String changeWho) {
		this.changeWho = changeWho;
	}

}
