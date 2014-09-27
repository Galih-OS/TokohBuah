import java.util.*;
public class ManageBuah
{
	public static Vector<dataBuah> dbBuah = new Vector<dataBuah>();
	public static Scanner Scn = new Scanner(System.in);
	public static void main(String[] agit)
	{
		dbBuah.add(new dataBuah("B001", "Jeruk", 10000));
		dbBuah.add(new dataBuah("B002", "Mangga", 5000));
		dbBuah.add(new dataBuah("B003", "Apel", 7000));
		dbBuah.add(new dataBuah("B004", "Pir", 8000));
		dbBuah.add(new dataBuah("B005", "Melon", 15000));
		int Pilihan = 0;
		do
		{
			System.out.println();
			System.out.println("     TOKO BUAH JAVA MANISE     ");
			System.out.println();
			System.out.println("1. Tambah Data Buah");
			System.out.println("2. Lihat Data Buah");
			System.out.println("3. Hapus Data Buah");
			System.out.println("4. Exit");
			System.out.print("Masukkan Pilihan Anda : ");
			Pilihan = Scn.nextInt();
			System.out.println();
			switch(Pilihan)
			{
				case 1 : addGoods();
				break;
				case 2 : viewGoods();
				break;
				case 3 : deleteGoods();
				break;
			}
		}while(Pilihan < 4);
		
	}
	
	public static void addGoods()
	{
		System.out.println("     Tambah Data Buah Baru     ");
		int index = 0;
		String ID = "";
		boolean valid = false;
		do
		{
			System.out.print("ID Barang   : ");
			ID = Scn.next();
			index = cariIdx(ID,dbBuah);
			if(index != - 1)
			{
				System.out.println("ID " + ID + " Sudah ada dalam Tabel Barang");
			}
			else
			{
				valid = true;
			}
		}
		while(!valid);
		System.out.print("Masukkan Nama Buah \t : ");
		String nmBuah = Scn.next();
		System.out.print("Masukkan Harga Buah \t : Rp. ");
		float hgBuah = Scn.nextFloat();
		dbBuah.add(new dataBuah(ID, nmBuah, hgBuah));
	}
	
	public static void viewGoods()
	{
		System.out.println("No. ID\t\tNama\t\tHarga");
		int i = 0;
		for(dataBuah vBuah : dbBuah)
		{
			System.out.println((i+1) + ".  " + vBuah.getId() + "\t" + vBuah.getNamaBuah() + "\t\tRp. " + vBuah.getHargaBuah() + "\t\t" + vBuah.getHargaJual());
			i++;
		}
	}
	
	public static void deleteGoods()
	{
		int idx = -1;
		int i = 0;
		System.out.println("     Hapus Data Buah     ");
		System.out.print("Masukkan ID Buah yang akan dihapus \t: ");
		String ID = Scn.next();
		do
		{
			if(dbBuah.elementAt(i).getId().equals(ID))
			{
				idx = i;
			}
			i++;
		}while((i < dbBuah.size() && (idx == -1)));
		
		if(idx == -1)
		{
			System.out.println(ID + " Tidak ada ditemukan");
		}
		else
		{
			System.out.print("Apakah User " + ID + " akan dihapus (Y / T) : ");
			String Hapus = Scn.next();
			if(Hapus.equalsIgnoreCase("Y"))
			{
				dbBuah.removeElementAt(idx);
				System.out.println("User " + ID + " Berhasil dihapus");
			}
		}
	}
	
	public static int cariIdx(String Key, Vector<dataBuah> dbBuah)
	{
		int idx = -1;
		int i = 0;
		while((i < dbBuah.size()) && (idx == -1))
		{
			if(dbBuah.elementAt(i).getId().equals(Key))
			{
				idx = i;
			}
				i++;
		}
		return idx;
	}
}