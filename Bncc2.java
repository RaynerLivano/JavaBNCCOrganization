public class Bncc2 {
String name;
String gender;
String jabatan;
String ID;
Integer gaji;

	public Bncc2(String name, String gender, String jabatan, String ID, Integer gaji) {
		this.name = name;
		this.gender = gender;
		this.jabatan = jabatan;
		this.ID = ID;
		this.gaji = gaji;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName () {
		return name;
	}
	
	
	public void setGender (String gender) {
		this.gender = gender;
	}
	
	public String getGender () {
		return gender;
	}
	
	public void setJabatan (String jabatan) {
		this.jabatan = jabatan;
	}
	
	public String getJabatan () {
		return jabatan;
	}
	public void setID (String ID) {
		this.ID = ID;
	}
	
	public String getID () {
		return ID;
	}
	
	public void setGaji (Integer gaji) {
		this.gaji = gaji;
	}
	
	public Integer getGaji () {
		return gaji;
	}
}

