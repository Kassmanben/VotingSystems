import java.io.File;


public class ApprovalElection {

	/** For simplicity, this is fixed for all elections. */
	private static final String[] CANDIDATE_NAMES = {"Akiko", "Bob", "Carlos", "Danielle"};
	
	/** Number of votes for each candidate. */
	private int[] goodVotes;
	private int[] badVotes;
	private int badCounter; //tracks the "disapproval" line
	
	public ApprovalElection(String directory) {
		goodVotes = new int[CANDIDATE_NAMES.length]; // new array to count good votes for candidates
		badVotes = new int[CANDIDATE_NAMES.length]; // new array to count bad votes for candidates
		File[] ballots = new File(directory).listFiles();
		for (File f : ballots) {
			Ballot b = new Ballot(directory + f.getName());
			badCounter = 6;
			if (b.size() > 0) {
				for (int j = 0; j < 5; j++) 
				{
					if (j < badCounter) {
						for (int i = 0; i < CANDIDATE_NAMES.length; i++) {
							if ( (b.get(j).equals(CANDIDATE_NAMES[i])) && (b.get(j)!=("--"))) {
							goodVotes[i]++;
							}
							if ( (b.get(j).equals("--") ) ) {
								badCounter = j;
							}
						}
					}
					else {
						for (int i = 0; i < CANDIDATE_NAMES.length; i++) {
							if ( (b.get(j).equals(CANDIDATE_NAMES[i])) ) {
							badVotes[i]++;
							}
						}
					}
				}
			}
		}
	}
	public Object winner() {
		int highestCount = -1;
		String result = "Nobody";
		for (int i = 0; i < goodVotes.length; i++) {		
				StdOut.println(CANDIDATE_NAMES[i] + " : " + goodVotes[i] + " - " + badVotes[i]);
			if (goodVotes[i] > highestCount) {
				result = CANDIDATE_NAMES[i];
				highestCount = goodVotes[i];
			}
		}
		StdOut.println(badCounter);
		return result;	
	}
}
