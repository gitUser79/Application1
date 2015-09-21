import java.util.*;

public class VM {
	private ArrayList<Double> cpu_percent;
	private  ArrayList<Double> mem_percent;
	private  ArrayList<Double> disk_percent;
	//In typical VM environment, its an IP
	public int vm_id; 

	 
	public ArrayList<Double> getCpu_percent() {
		return cpu_percent;
	}


	public void setCpu_percent(ArrayList<Double> cpu_percent) {
		this.cpu_percent = cpu_percent;
	}


	public ArrayList<Double> getMem_percent() {
		return mem_percent;
	}


	public void setMem_percent(ArrayList<Double> mem_percent) {
		this.mem_percent = mem_percent;
	}


	public ArrayList<Double> getDisk_percent() {
		return disk_percent;
	}


	public void setDisk_percent(ArrayList<Double> disk_percent) {
		this.disk_percent = disk_percent;
	}


	public int getVm_id() {
		return vm_id;
	}


	public void setVm_id(int vm_id) {
		this.vm_id = vm_id;
	}


	public VM(ArrayList<Double> cpu_percent, ArrayList<Double> mem_percent, ArrayList<Double> disk_percent, int vm_id)
	{
		this.cpu_percent=new ArrayList<Double>();
		this.mem_percent=new ArrayList<Double>();
		this.disk_percent=new ArrayList<Double>(); 
		this.vm_id = vm_id;	 
	}
	
	public Boolean checkIsdeUtilzedVM(ArrayList<Double> cpu_percent, ArrayList<Double> mem_percent, ArrayList<Double> disk_percent, int vm_id, int vm_num)
	{
		double cpu_sum = 0.0;
		double mem_sum = 0.0;
		double disk_sum = 0.0;
		
		for(Double mem : mem_percent)
		{
			mem_sum = mem_sum + mem;	
			
		}
		for (Double cpu : cpu_percent)
		{
			cpu_sum = cpu_sum + cpu;
		}
		for(Double disk : disk_percent)
		{
			disk_sum = disk_sum + disk;
			
		}
		
		try
		{
	
			
			if((((mem_sum)/mem_percent.size()) <= 20.00) && (cpu_sum/(cpu_percent.size()) <=10.00) && ((disk_sum/(disk_percent.size()) <= 10.00)))
			{
				
				return true;
			}
			else
			{
				
			    return false;	
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
		
	}
	
}
