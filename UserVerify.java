import java.util.*;
public class ManageUser
{
	public static Vector<UserLogin> dataUser = new Vector<UserLogin>();
	public static Scanner Scn = new Scanner(System.in);
	
	public static void main(String[] agit)
	{
		dataUser.add(new UserLogin("admin","221"));
		dataUser.add(new UserLogin("kasir","321"));
		
		boolean loginSukses = false;
		if(!Login())
		{
			loginSukses = true;
		}
		while(!loginSukses)
		{
			System.out.println();
			System.out.println("     TOKO BUAH JAVA MANISE     ");
			System.out.println();
			System.out.println("1. Tambah User Baru");
			System.out.println("2. Lihat Data User");
			System.out.println("3. Hapus Data User");
			System.out.println("4. Ganti Password");
			System.out.println("5. Keluar");
			System.out.print("Masukkan Pilihan Anda 1 - 5 : ");
			int Pilihan = Scn.nextInt();
			System.out.println();
			switch(Pilihan)
			{
				case 1 : addUser();
				break;
				case 2 : viewUser();
				break;
				case 3 : deleteUser();
				break;
				case 4 : changePass();
				break;
			}
		}
	}
	
	public static boolean Login() // Cek User dan Password
	{
		boolean Benar = false;
		int i = 0;
		do
		{
			System.out.println("     Halaman Login     ");
			System.out.println();
			System.out.print("Masukkan Username \t: ");
			String userLgn = Scn.nextLine();
			System.out.print("Masukkan Password \t: ");
			String passLgn = Scn.nextLine();
			System.out.println();
			int j = 0;
			do
			{
				if(dataUser.elementAt(j).checkPassUser(userLgn, passLgn))
				{
					Benar = true;
					j = dataUser.size();
				}
					j++;
			}while(j < dataUser.size());
			i++;
		}while((!Benar) && (i < 3));
		return Benar;
	}
	
	public static void addUser() // Tambah User
	{
		System.out.println("     Tambah User Baru     ");
		System.out.print("Masukkan Username Baru \t : ");
		String userName = Scn.next();
		System.out.print("Masukkan Password \t : ");
		String password = Scn.next();
		UserLogin userBaru = new UserLogin(userName, password);
		dataUser.add(userBaru);
	}
	
	public static void viewUser() // Lihat Data User
	{
		System.out.println("No. Username\tPassword");
		int i = 0;
		for(UserLogin vUser : dataUser)
		{
			System.out.println((i+1) + ".  " + vUser.getUserName() + "\t" + vUser.getPassword());
			i++;
		}
	}
	
	public static void deleteUser() // Hapus Data User
	{
		int idx = -1;
		int i = 0;
		System.out.println("     Hapus Data User     ");
		System.out.print("Masukkan Username yang akan dihapus \t: ");
		String userName = Scn.next();
		do
		{
			if(dataUser.elementAt(i).getUserName().equals(userName))
			{
				idx = i;
			}
			i++;
		}while((i < dataUser.size() && (idx == -1)));
		
		if(idx == -1)
		{
			System.out.println(userName + " Tidak ada ditemukan");
		}
		else
		{
			System.out.print("Apakah User " + userName + " akan dihapus (Y / T)");
			String Hapus = Scn.next();
			if(Hapus.equalsIgnoreCase("Y"))
			{
				dataUser.removeElementAt(idx);
				System.out.println("User " + userName + " Berhasil dihapus");
			}
		}
	}
	
	public static void changePass()
	{
		int idx = -1;
		int i = 0;
		System.out.println("     Ganti Password User     ");
		System.out.print("Masukkan Username yang akan diubah \t: ");
		String usrName = Scn.next();
		do
		{
			if(dataUser.elementAt(i).getUserName().equals(usrName))
			{
				idx = i;
			}
			i++;
		}while((i < dataUser.size() && (idx == -1)));
		
		if(idx == -1)
		{
			System.out.println(usrName + " Tidak ada ditemukan");
		}
		else
		{
			System.out.print("Masukkan Password Baru : ");
			String newPass = Scn.next();
			dataUser.elementAt(idx).setPassword(newPass);
		}
	}
}