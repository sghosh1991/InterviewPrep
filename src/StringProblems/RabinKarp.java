package StringProblems;

public class RabinKarp
{
	private String pat;
	private long patHash;
	private int M;
	private long Q;
	private int R = 256;
	private long RM;
	
	public RabinKarp(String pat)
	{
	this.pat = pat;
	this.M = pat.length();
	//Q = longRandomPrime();
	
	RM = 1;
	for (int i = 1; i <= M-1; i++)
		RM = (R * RM) % Q;
	patHash = hash(pat, M);
	}
	
	
	public boolean check(int i){ return true; }
	
	
	private long hash(String key, int M){
		long h = 0;
		for (int j = 0; j < M; j++)
		
		h = (R * h + key.charAt(j)) % Q;
		
		return h;
	}
	
	private int search(String txt){ // Search for hash match in text.
		int N = txt.length();
		long txtHash = hash(txt, M);
		if (patHash == txtHash) return 0;
		//Match at beginning.
		for (int i = M; i < N; i++)
		{ // Remove leading digit, add trailing digit, check for match.
		txtHash = (txtHash + Q - RM*txt.charAt(i-M) % Q) % Q;
		txtHash = (txtHash*R + txt.charAt(i)) % Q;
		if (patHash == txtHash)
		if (check(i - M + 1)) return i - M + 1; // match
		}
		return N;
		//no match found
	}
	}