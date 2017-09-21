import java.io.File;

public class InstantRunoffElection {
	private static final String[] CANDIDATE_NAMES = { "Akiko", "Bob", "Carlos",
			"Danielle" };
	private int[] votes;
	private boolean[] eliminated = { false, false, false, false };
	private File[] ballots;
	private int highestCount = -1;
	private double totalVotes = 0;
	private String result = "Nobody";
	private String directory;

	public InstantRunoffElection(String directory) {
		this.directory = directory;
		votes = new int[CANDIDATE_NAMES.length];
		ballots = new File(directory).listFiles();
		countVotes();
	}

	public void countVotes() {
		/*
		 * Counts the top vote on each ballot, so long as that candidate hasn't
		 * been eliminated by the runoff process
		 */
		votes = new int[CANDIDATE_NAMES.length];
		for (File f : ballots) {
			Ballot b = new Ballot(directory + f.getName());
			if (b.size() > 0) {
				boolean stillCounting = true;
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < CANDIDATE_NAMES.length; j++) {
						if (b.get(i).equals(CANDIDATE_NAMES[j])
								&& !eliminated[j]) {
							votes[j]++;
							stillCounting = false;
						}
					}
					if (!stillCounting) {
						break;
					}
				}
			}
		}
	}

	public String winner() {
		/*
		 * A recursive function that checks whether the candidate got more than
		 * half of the votes, and if not, marks the candidate with the fewest
		 * votes eliminated, then runs through again.
		 */
		countVotes();
		totalVotes = 0;
		for (int i = 0; i < votes.length; i++) {
			totalVotes += votes[i];
			if (votes[i] > highestCount) {
				highestCount = votes[i];
				result = CANDIDATE_NAMES[i];
			}
		}
		if (highestCount > totalVotes / 2) {
			return result;
		} else {
			int lowestCount = highestCount;
			int lowestIndex = -1;
			for (int i = 0; i < votes.length; i++) {
				if (votes[i] < lowestCount && votes[i] != 0) {
					lowestCount = votes[i];
					lowestIndex = i;
				}
			}
			eliminated[lowestIndex] = true;
			return winner();
		}
	}
}
