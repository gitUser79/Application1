import java.util.ArrayList;


public class VM_Manager {
	private static ArrayList<VM> vmm = null;
	private static VM_Manager instance;
	private static int numberofVm;
	private int index = 0;
	//private ArrayList<Boolean> VM_MetaData;
	
	public ArrayList<VM> getVmm() {
		if(vmm == null)
    	{
    		vmm = new ArrayList<VM>();
    	}
		return vmm;
	}
	
  public static synchronized VM_Manager getInstance(int numberofVm, ArrayList<Double> cpu_percent, ArrayList<Double> mem_percent, ArrayList<Double> disk_percent) {
	    if (instance == null) {
	      instance = new VM_Manager(numberofVm, cpu_percent, mem_percent, disk_percent);
	    }
	    return instance;
	  }

	
	public VM getVM(int index)
	{
		return vmm.get(index);
	}

	public int getNumberofVm() {
		return numberofVm;
	}

	/*public void setNumberofVm(int numberofVm) {
		this.numberofVm = numberofVm;
	}*/
	
   public VM_Manager(int numberofVm, ArrayList<Double> cpu_percent, ArrayList<Double> mem_percent, ArrayList<Double> disk_percent )
   {
        VM_Manager.numberofVm = numberofVm;
        //VM_MetaData = new ArrayList<Boolean>();
        if (numberofVm != 0)
		{

            vmm = new ArrayList<VM>();

			for(index = 0;index < numberofVm; index++)
			{    
				 vmm.add(new VM(cpu_percent, mem_percent, disk_percent,index));
				 //System.out.println(vmm.get(index).toString());
			}			
		}
	}
   
   public void getVMStatus(ArrayList<VM> vm_machine)
   {  
	       for (int i=0;i<vm_machine.size(); i++)
	       {
	    	   if(true == vm_machine.get(i).checkIsdeUtilzedVM(vm_machine.get(i).getCpu_percent(), vm_machine.get(i).getMem_percent(), vm_machine.get(i).getDisk_percent(), i, vm_machine.size()))
			   {
				   System.out.println("Deutilized VM that needs to be Reclaimed VM "+ i);
//				   System.out.println(vm_machine.get(i).getCpu_percent().toString());
//				   System.out.println(vm_machine.get(i).getMem_percent().toString());
//				   System.out.println( vm_machine.get(i).getDisk_percent().toString());
				   
			   }
			   else
			   {
				   System.out.println("Utilized VM "+ i);
//				   System.out.println(vm_machine.get(i).getCpu_percent().toString());
//				   System.out.println(vm_machine.get(i).getMem_percent().toString());
//				   System.out.println( vm_machine.get(i).getDisk_percent().toString());
			   }
	       }
		   
			   
		   //System.out.println(VM_MetaData.toString());
	   return;
   }
   
  

}
