package TwoSigma;

public class ValidSocketAddress {
	
	
	public static boolean isValidSocket(String socket){
		
		if(socket == null || socket.equals("")){
			return false;
		}
		
		String [] components = socket.split(":");
		if(components.length != 2){
			return false;
		}
		
		
		String ip = components[0];
		String port = components[1];
		
		
		if(isValidIP(ip) && isValidPort(port)){
			return true;
		}
		
		//Check ip validity
		
		
		
		return false;
		
	}
	
	
	public static boolean isValidPort(String port){
		
		int portNum;
		if(port.length() > 5 || port.length() < 1){
			
			return false;
		}
		if(port.charAt(0) == '+' || port.charAt(0) == '-'){
			return false;
		}

		//remove leading zeros
		int i = 0;
		while(port.charAt(i) == '0'){
			port = port.substring(i,port.length());
			i++;
		}
		
		try{
			portNum = Integer.parseInt(port);
			System.out.println(portNum);
			
			if(!(portNum >= 1 && portNum <= 65535)){
				return false;
			}
		}
		catch(NumberFormatException e){
			
			return false;
		}
		
		System.out.println("Passed port");
		return true;
	}
	
	public static boolean isValidIP(String ip){
		
		//if it comes here ensure that the input is some string of the form AAA:BBB
		//i.e ip input param is not null
		
		String [] ipOctets = ip.split("\\.");
		System.out.println(ip);
		
		if(ipOctets.length != 4){
			System.out.println(ipOctets.length);
			System.out.println("Failed length");
			return false;
		}
		
			
		for(String s:ipOctets){
			
			//System.out.println("parsing " + s);
			//remove leading zeros from every octet
			int i = 0;
			while(s.charAt(i) == '0'){
				s = s.substring(i,s.length());
				i++;
			}
			
			System.out.println("parsing " + s);
			//prevents overflow when parsing string for int
			if(s.length() > 3 || s.length() <1){
				System.out.println("Failed octet length");
				return false;
			}
			
			if(s.charAt(0)== '-' || s.charAt(0) == '+'){
				return false;
			}
			
			
			
			try{
			//check for range
			int octet = Integer.parseInt(s);
			if( !(octet <= 255 && octet >=0) ){
				return false;
				}
			}
			catch(NumberFormatException e){
				
				System.out.println("Failed not parsable");
				//Not parsable
				return false;
			}
			
		}
		
		
		System.out.println("Passed");
		return true;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ValidSocketAddress.isValidIP("0001.4.5.6");
		
		String falsePort = "5647";
		System.out.println(ValidSocketAddress.isValidPort(falsePort));

	}

}
