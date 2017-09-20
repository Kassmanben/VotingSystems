import java.io.File;


public class ApprovalElection {

	/** For simplicity, this is fixed for all elections. */
	private static final String[] CANDIDATE_NAMES = {"Akiko", "Bob", "Carlos", "Danielle"};
	
	/** Number of votes for each candidate. */
	private int[] votes;
	
	public ApprovalElection(String directory) {
		votes = new int[CANDIDATE_NAMES.length]; // new array to count votes for candidates
		File[] ballots = new File(directory).listFiles();
		for (File f : ballots) {
			Ballot b = new Ballot(directory + f.getName());
			if (b.size() > 0) {
				for (int j = 0; j < 4; j++) 
				{
					int z = j;
					for (int i = 0; i < CANDIDATE_NAMES.length; i++) {
						if (b.get(z).equals(CANDIDATE_NAMES[i])) {
							votes[i]++;
						}
					}
				}
			}
		}
	}


	public Object winner() {
		int highestCount = -1;
		String result = "Nobody";
		for (int i = 0; i < votes.length; i++) {
			if (votes[i] > highestCount) {
				result = CANDIDATE_NAMES[i];
				highestCount = votes[i];
			}
		}
		return result;
	}

}
