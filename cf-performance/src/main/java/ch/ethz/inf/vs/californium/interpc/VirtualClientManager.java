package ch.ethz.inf.vs.californium.interpc;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The VirtualClient manager creates the virtual clients for the benchmarks.
 * Each virtual client sends request to the server as fast as the server can
 * handle them.
 */
public class VirtualClientManager {

//	public static final String HOST = ClientSlave.MASTER_ADDRESS;
	public static String HOST = "localhost";
	public static int[] PORTS = { 5683 };
	public static final String LOG_FILE = "bench";
	
	public static final int DEFAULT_TIME = 60*1000;
	private Timer timer;
	
	private InetAddress address;
	private int[] ports;
	private long timestamp;
	
	private ArrayList<VirtualClient> clients;
	
	private LogFile log;
	
	public VirtualClientManager() throws Exception {
		this.log = new LogFile(LOG_FILE);
		this.address = InetAddress.getByName(HOST);
		this.ports = PORTS;
		this.clients = new ArrayList<VirtualClient>();
		this.timer = new Timer();
	}
	
	public void setClientCount(int c) throws Exception {
		if (c < clients.size()) {
			for (int i=clients.size()-1; i>=c; i--)
				clients.remove(i);
		} else {
			for (int i=clients.size(); i<c; i++)
				clients.add(new VirtualClient(address, ports));
		}
	}
	
	public void start(int count, int time) throws Exception {
		setClientCount(count);
		Thread[] threads = new Thread[count];
		for (int i=0;i<count;i++) {
			VirtualClient c = clients.get(i);
			c.reset();
			threads[i] = new Thread(c);
		}
		log.println("\nStart "+count+" virtual clients for "+time+" ms");
		for (int i=0;i<count;i++)
			threads[i].start();
		timestamp = System.nanoTime();
		timer.schedule(new TimerTask() {
			public void run() {
				stop();
			} }, time);
	}
	
	public void stop() {
		float dt = (System.nanoTime() - timestamp) / 1000000f;
		for (VirtualClient vc:clients)
			vc.stop();
		log.println("Stoped virtual clients");
		int sum = 0;
		int sumLost = 0;
		for (int i=0;i<clients.size();i++) {
			int count = clients.get(i).getCount();
			int lost = clients.get(i).getLost();
			sum += count;
			sumLost += lost;
			log.format("Virtual client %2d received %7d, timeout %3d, throughput %d /s\n"
					, i, count, lost, (int) (count * 1000L / dt));
		}
		log.format("Total received %8d, timeout %4d, throughput %d /s\n"
				, sum, sumLost, (int) (sum * 1000L / dt));
	}
	
	public static void main(String[] args) throws Exception {
		args = new String[] {"-host", "localhost", "-ports", "5683", "-cs", "2", "10", "20", "-t", "12000", };//, "-target", "fibonacci?n=22"};
		int t = 10000;
		int c = 20;
		int[] cs = null;
		
		if (args.length > 0) {
			int index = 0;
			while (index < args.length) {
				String arg = args[index];
				if ("-host".equals(arg)) {
					HOST = args[index+1];
				} else if ("-port".equals(arg)) {
					PORTS = new int[] {Integer.parseInt(args[index+1])};
				} else if ("-ports".equals(arg)) {
					ArrayList<String> vals = new ArrayList<String>();
					for (int i=index+1; i<args.length && !args[i].startsWith("-") ;i++)
						vals.add(args[i]);
					PORTS = new int[vals.size()];
					for (int i=0;i<vals.size();i++)
						PORTS[i] = Integer.parseInt(vals.get(i));
					index = index + vals.size() - 1;
				} else if ("-c".equals(arg)) {
					c = Integer.parseInt(args[index+1]);
				} else if ("-cs".equals(arg)) {
					int cn = Integer.parseInt(args[index+1]);
					cs = new int[cn];
					for (int i=0;i<cn;i++) cs[i] = Integer.parseInt(args[index+2+i]);
					index += cn;
				} else if ("-t".equals(arg)) {
					t = Integer.parseInt(args[index+1]);
				} else if ("-target".equals(arg)) {
					VirtualClient.TARGET = args[index+1];
				} else if ("-nocheck".equals(arg))
					VirtualClient.CHECK_CODE = false;
				index += 2;
			}
		}
		System.out.println("VirtualClientManager sends requests to "+HOST+":"+Arrays.toString(PORTS));
		VirtualClientManager m = new VirtualClientManager();
		if (cs != null) {
			for (int i=0;i<cs.length;i++) {
				m.start(cs[i], t);
				Thread.sleep(t+5000);
			}
		} else {
			m.start(c, t);
			Thread.sleep(t+1000);
		}
		System.exit(0);
	}
}
