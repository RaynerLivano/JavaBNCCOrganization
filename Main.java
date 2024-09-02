import java.util.*;

public class Main {
	Scanner sc = new Scanner (System.in);
	Vector <Bncc2> list = new Vector <>();
	ArrayList<Integer> gajiList = new ArrayList <>();
	String name = "", gender = "", jabatan = "", ID = "";
	int menu = 0, gaji = 0, count = 0;
	Random r = new Random();
	
	public Main() {
		// TODO Auto-generated constructor stub
		do {
		System.out.println("PT Mentol");
		System.out.println("=========================");
		System.out.println("1. Insert data karyawan");
		System.out.println("2. View data karyawan");
		System.out.println("3. Update data karyawan");
		System.out.println("4. Delete data karyawan");
		try {
			System.out.println(">>>");
			menu = sc.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Input Number!");
		} sc.nextLine();
		
		switch (menu) {
		case 1:
			insert();
			bonus();
			break;
		case 2 :
			view();
			break;
		case 3 :
			update();
			break;
		case 4:
			delete();
			break;
		}
		} while (menu != 5);
	}
	
		public void insert () {
			do { 
				System.out.println("Input nama karyawan [>= 3] :");
				name = sc.nextLine();
			} while (name.length() < 3);
			do {
				System.out.println("Input jenis kelamin [Laki-laki | Perempuan] :");
				gender = sc.nextLine();
			} while (!gender.equals("Laki-laki") && !gender.equals("Perempuan"));
			do {
				System.out.println("Input jabatan [Manager | Supervisor | Admin] :");
				jabatan = sc.nextLine();
			} while (!jabatan.contains("Manager") && !jabatan.contains("Supervisor") && !jabatan.contains("Admin"));
			
			
			if (jabatan.equals("Manager")) {
				gaji = 8000000;
			} else if (jabatan.equals("Supervisor")) {
				gaji = 6000000;
			} else {
				gaji = 4000000;
			}
			
					
				ID = "" + (char)(r.nextInt(26) + 'A') + (char)(r.nextInt(26) + 'A') + "-" +(int) (r.nextInt(10)) + (int) (r.nextInt(10)) + (int) (r.nextInt(10)) + (int) (r.nextInt(10));
				System.out.println("Berhasil menambahkan karyawan dengan id " + ID);
				Bncc2 user = new Bncc2 (name, gender, jabatan, ID, gaji);
				list.add(user);
		}
		
		public void bonus () {
			int count = 0;
			int bonus;
			if (jabatan.equals("Manager")) {
				for (Bncc2 i : list) {
					if (i.getJabatan().equals("Manager")) {
						count++;
					}
				}
				if (count >= 3) {
					String bonus1 ="";
					for (int i = 0; i < list.size(); i++) {
						if ((list.get(i).getJabatan()).equals("Manager")) {
							bonus = list.get(i).getGaji()*110/100;
							Bncc2 setBonus = list.get(i);
							setBonus.setGaji(bonus);
							bonus1 = bonus1 + list.get(i).getID() + " ";
						}
					}
					System.out.println("Bonus sebesar 10% telah diberikan kepada Karyawan dengan id " + bonus1);
				}
				count = 0;
			} else if (jabatan.equals("Supervisor")) {
				for (Bncc2 i : list) {
					if (i.getJabatan().equals("Supervisor")) {
						count++;
					}
				}
				if (count >= 3) {
					String bonus1 ="";
					for (int i = 0; i < list.size(); i++) {
						if ((list.get(i).getJabatan()).equals("Supervisor")) {
							bonus = list.get(i).getGaji()*75/1000 + list.get(i).getGaji();
							Bncc2 setBonus = list.get(i);
							setBonus.setGaji(bonus);
							bonus1 = bonus1 + list.get(i).getID() + " ";
						}
					}
					System.out.println("Bonus sebesar 7.5% telah diberikan kepada Karyawan dengan id " + bonus1);
				}
				count = 0;
				} else if (jabatan.equals("Admin")) {
					for (Bncc2 i : list) {
						if (i.getJabatan().equals("Admin")) {
							count++;
						}
					}
					if (count >= 3) {
						String bonus1 ="";
						for (int i = 0; i < list.size(); i++) {
							if ((list.get(i).getJabatan()).equals("Admin")) {
								bonus = list.get(i).getGaji()*105/100;
								Bncc2 setBonus = list.get(i);
								setBonus.setGaji(bonus);
								bonus1 = bonus1 + list.get(i).getID() + " ";
							}
						}
						System.out.println("Bonus sebesar 5% telah diberikan kepada Karyawan dengan id " + bonus1);
					}
					count = 0;
				}
		}
		
			public void sort () {
				for (int i = 0; i < list.size(); i++) {
					for (int j = 0; j < list.size()-i-1; j++) {
						if (list.get(j).getName().compareTo(list.get(j+1).getName()) > 0) {
							Bncc2 name = list.get(j);
							list.set(j, list.get(j+1));
							list.set(j+1, name);
						}
					}
				}
			}
		
		public void view () {
			sort();
			if (list.isEmpty()) {
				System.out.println ("No Data");
			} else {
			System.out.println ("=========================================================================================================================================");
			System.out.printf ("|%-3s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "No.", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
			}for (int i = 0; i < list.size(); i++) {
			System.out.printf ("|%-3d|%-15s|%-15s|%-15s|%-15s|%-15d|\n", (i+1), list.get(i).getID(),list.get(i).getName(), list.get(i).getGender(), list.get(i).getJabatan(), list.get(i).getGaji());
			System.out.println ("=========================================================================================================================================");
				}
				System.out.println("Press enter to continue!");
				sc.nextLine();
			}
		
		public void delete () {
			view();
			
			int del = -1;
			do {
				System.out.println("Input to Delete [1-" + list.size() + "]:");
				del = sc.nextInt();
			} while (del < 1|| del > list.size()); 
			
			list.remove(del-1);
			System.out.println("Deleted");
		}
	
		
		public void update () {
			view ();
			int upd = 0;
			do {
				System.out.printf("Choose data to update [ 1 - " + list.size()+" ] : ");
				upd = sc.nextInt();
				sc.nextLine();
			}while(upd<1 || upd>list.size());
			
			do { 
				System.out.println("Input nama karyawan [>= 3] :");
				name = sc.nextLine();
			} while (name.length() < 3);
			do {
				System.out.println("Input jenis kelamin [Laki-laki | Perempuan] :");
				gender = sc.nextLine();
			} while (!gender.equals("Laki-laki") && !gender.equals("Perempuan"));
			do {
				System.out.println("Input jabatan [Manager | Supervisor | Admin] :");
				jabatan = sc.nextLine();
			} while (!jabatan.contains("Manager") && !jabatan.contains("Supervisor") && !jabatan.contains("Admin"));
			
				if (jabatan.equals("Manager")) {
					gaji = 8000000;
				} else if (jabatan.equals("Supervisor")) {
					gaji = 6000000;
				} else {
					gaji = 4000000;
				}
				
				ID = "" + (char)(r.nextInt(26) + 'A') + (char)(r.nextInt(26) + 'A') + "-" +(int) (r.nextInt(10)) + (int) (r.nextInt(10)) + (int) (r.nextInt(10)) + (int) (r.nextInt(10));
				System.out.println("Berhasil menambahkan karyawan dengan id " + ID);
				Bncc2 user = new Bncc2 (name, gender, jabatan, ID, gaji);
				list.set(upd-1, user);
		}
		
		

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
