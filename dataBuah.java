public class dataBuah
{
	private String idBuah;
	private String namaBuah;
	private float hargaBuah;
	private float hargaJual;
	private float Untung;
	
	public dataBuah(String idBuah, String namaBuah, float hargaBuah)
	{
		this.idBuah = idBuah;
		this.namaBuah = namaBuah;
		this.hargaBuah = hargaBuah;
		hargaJual = hargaBuah + (int)(hargaBuah * 0.1);
		Untung = hargaJual - hargaBuah;
	}
	
	public String getId()
	{
		return idBuah;
	}
	
	public String getNamaBuah()
	{
		return namaBuah;
	}
	
	public float getHargaBuah()
	{
		return hargaBuah;
	}
	
	public float getHargaJual()
	{
		return hargaJual;
	}
	
	public void setHarga(float hargaBuah)
	{
		this.hargaBuah = hargaBuah;
	}
	
	public void setNama(String namaBuah)
	{
		this.namaBuah = namaBuah;
	}
}