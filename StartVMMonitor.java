import java.util.Scanner;
//import java.util.concurrent.*;
import java.util.*;


public class StartVMMonitor {
	//private final ScheduledExecutorService service;
    
    private  static ArrayList<Double> cpu_usage = null;
	private  static ArrayList<Double> mem_usage = null;
	private  static ArrayList<Double> disk_usage = null;
	private static int vm_num;
	//private final long period = 30;//Repeat interval
	private static VM_Manager vm_manager;
	private static Scanner s;
	
    public VM_Manager getVm_manager() {
		return vm_manager;
	}


	public StartVMMonitor()
    {

         //service = Executors.newScheduledThreadPool(1);
         vm_manager = null;
         s = null;

    }
	
   
	public static void main(String[] args)
	{
		new StartVMMonitor();
    	System.out.println("Monitor VM");
		s = new Scanner(System.in);
		System.out.print( "Enter number of VMs configured: "  );
		vm_num = s.nextInt();
		if(vm_num == 0)
		{
			return;
		}
		//vm_manager = new VM_Manager(vm_num, cpu_usage, mem_usage, disk_usage);
		vm_manager = VM_Manager.getInstance(vm_num, cpu_usage, mem_usage, disk_usage);
		
		for ( int i=0; i<vm_num; i++)
		{
			
			System.out.println( "Enter the CPU usage in percentage for VM " + vm_manager.getVM(i).getVm_id() );
			vm_manager.getVM(i).getCpu_percent().add(s.nextDouble());
			System.out.println( "Enter the  Mem usage in percentage for VM "+ vm_manager.getVM(i).getVm_id() );
			vm_manager.getVM(i).getMem_percent().add(s.nextDouble());
			System.out.println( "Enter the  Disk Usage in percentage for VM "+ vm_manager.getVM(i).getVm_id() );
			vm_manager.getVM(i).getDisk_percent().add(s.nextDouble());
		}
		
		System.out.println( "Enter the number of times that the user wants to Poll the VMs before to determine if its Utilized /DeUtilized");

		
		final Timer timer = new Timer();
		// Note that timer has been declared final, to allow use in anon. class below
		timer.schedule( new TimerTask()
		{
			
		    private int i = s.nextInt();
		    public void run()
		    {
        		
        		for(int index1=0; index1 < vm_num ; index1 ++)
        		{
        			
	        		System.out.println( "Enter the CPU usage in percentage for VM " + index1 );
	        		vm_manager.getVM(index1).getCpu_percent().add(s.nextDouble());
	        		System.out.println( "Enter the  Mem usage in percentage for VM "+ index1 );
	        		vm_manager.getVM(index1).getMem_percent().add(s.nextDouble());
	        		System.out.println( "Enter the  Disk Usage in percentage for VM "+ index1 );
	        		vm_manager.getVM(index1).getDisk_percent().add(s.nextDouble());
        		}
        		
        		if (--i < 1) 
        		{
        		    	
        		 	    vm_manager.getVMStatus(vm_manager.getVmm());
        		    
                		timer.cancel(); 
        		}
        		
		    }
		    
		}, 0, 60000 //Note the second argument for repetition
		
		);
		

	}

}
