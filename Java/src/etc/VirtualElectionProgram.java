package week1;

import java.util.*;

public class VirtualElectionProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalVoteNum, candidateNum;
        Election election;

        System.out.print("총 진행할 투표수를 입력해 주세요.");
        totalVoteNum = sc.nextInt();
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
        candidateNum = sc.nextInt();
        election = new Election(totalVoteNum, candidateNum);

        for (int i = 1; i <= candidateNum; i++) {
            System.out.print(i + "번째 후보자 이름을 입력해 주세요.");
            election.addCandidate(sc.next(), i);
        }

        election.startElection();
        election.electedPerson();
    }
}

class Election {

    private final int totalVoteNum;
    private final int candidatesNum;
    private int voteCount = 0;
    private List<Candidate> candidates;

    public Election(int totalVoteNum, int candidatesNum) {
        this.totalVoteNum = totalVoteNum;
        this.candidatesNum = candidatesNum;
        this.candidates = new ArrayList<>(candidatesNum);
    }

    public void addCandidate(String name, int symbolNumber) {
        if (this.candidates.size() >= candidatesNum) {
            System.out.println("후보자를 더 이상 추가할 수 없습니다.");
            return;
        }
        candidates.add(new Candidate(name, symbolNumber));
    }

    public void startElection() {
        Random rand = new Random();

        for (int i = 0; i < totalVoteNum; i++) {
            int index = rand.nextInt(candidatesNum);
            candidates.get(index).vote();
            voteCount++;
            printVoteProgress(index);
        }
    }

    public void electedPerson() {
        System.out.println("\n[투표결과] 당선인 : " +
                this.candidates.stream()
                        .max(Comparator.comparingInt(Candidate::getVoteCount))
                        .map(Candidate::getName)
                        .orElse(null));
    }

    private void printVoteProgress(int currentVote) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%n[투표진행률]: %.2f%%, %d명 투표 ==> %s %n",
                (double) this.voteCount / this.totalVoteNum * 100,
                this.voteCount,
                this.candidates.get(currentVote).getName()
        ));

        Candidate candidate;
        for (int i = 0; i < candidatesNum; i++) {
            candidate = this.candidates.get(i);

            sb.append(String.format("[기호:%2d] %-10s %4.2f%% (투표수: %d) %n",
                    candidate.getSymbolNumber(),
                    candidate.getName(),
                    (double) candidate.getVoteCount() / this.totalVoteNum * 100,
                    candidate.getVoteCount()
            ));
        }
        System.out.print(sb);
    }
}

class Candidate {
    String name;
    int symbolNumber;
    int voteCount = 0;

    public Candidate(String name, int symbolNumber) {
        this.name = name;
        this.symbolNumber = symbolNumber;
    }

    public void vote() {
        this.voteCount += 1;
    }

    public int getVoteCount() {
        return this.voteCount;
    }

    public String getName() {
        return this.name;
    }

    public int getSymbolNumber() {
        return symbolNumber;
    }
}
