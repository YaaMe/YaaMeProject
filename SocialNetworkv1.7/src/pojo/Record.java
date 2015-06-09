package pojo;

/**
 * Record entity. @author MyEclipse Persistence Tools
 */

public class Record implements java.io.Serializable {

	// Fields

	private Integer recId;
	private String recOri;
	private String recDes;
	private Integer recValue;

	// Constructors

	/** default constructor */
	public Record() {
	}

	/** minimal constructor */
	public Record(String recOri, String recDes) {
		this.recOri = recOri;
		this.recDes = recDes;
	}

	/** full constructor */
	public Record(String recOri, String recDes, Integer recValue) {
		this.recOri = recOri;
		this.recDes = recDes;
		this.recValue = recValue;
	}

	// Property accessors

	public Integer getRecId() {
		return this.recId;
	}

	public void setRecId(Integer recId) {
		this.recId = recId;
	}

	public String getRecOri() {
		return this.recOri;
	}

	public void setRecOri(String recOri) {
		this.recOri = recOri;
	}

	public String getRecDes() {
		return this.recDes;
	}

	public void setRecDes(String recDes) {
		this.recDes = recDes;
	}

	public Integer getRecValue() {
		return this.recValue;
	}

	public void setRecValue(Integer recValue) {
		this.recValue = recValue;
	}

}