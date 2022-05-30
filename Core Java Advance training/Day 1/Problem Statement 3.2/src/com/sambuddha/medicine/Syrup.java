package com.sambuddha.medicine;
public class Syrup implements MedicineInfo
{
	@Override
	public void displayLabel()
	{
		System.out.println(this.getClass().getSimpleName()+"-> consume as directed by the physician");
		}
}