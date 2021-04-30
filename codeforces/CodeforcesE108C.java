package com.personal.dsa.codeforces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CodeforcesE108C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = 0;
//		sc1.close();
		ArrayList<Pair> students = new ArrayList<>();
		while (x > 0) {
			x--;
			n = sc.nextInt();
			students.clear();
			for (int i = 0; i < n; i++) {
				Pair newPair = new Pair();
				students.add(newPair);
			}
			for (int i = 0; i < n; i++) {
				int tmp = sc.nextInt();
				students.get(i).setUni(tmp);
			}
			for (int i = 0; i < n; i++) {
				long tmp = sc.nextLong();
				students.get(i).setSkill(tmp);
			}
			
			if(students.size() > 1)
				Collections.sort(students, new PairComparator());
//			for(int i = 0; i < n; i++) {
//				System.out.println(students.get(i).getUni() + " " + students.get(i).getSkill());
//			}
			for(int i = 0; i < n; i++) {
				long totalSkill = 0;
				int index = 0;
				while(index + i < n) {
					long teamSkill = 0;
					boolean teamPos = true;
					for(int j = index; j <= index + i; j++) {
						if(students.get(j).getUni() != students.get(index).getUni()) {
							teamSkill = 0;
							index++;
							teamPos = false;
							break;
						} else {
							teamSkill += students.get(j).getSkill();
						}
					}
					if(teamPos) {
						totalSkill += teamSkill;
						index = index + i + 1;
					}
				}
				System.out.print(totalSkill + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}


class Pair {
	int uni;
	long skill;

	public Pair() {
		this.skill = 0;
		this.uni = 0;
	}

	public int getUni() {
		return uni;
	}

	public void setUni(int uni) {
		this.uni = uni;
	}

	public long getSkill() {
		return skill;
	}

	public void setSkill(long skill) {
		this.skill = skill;
	}

}

class PairComparator implements Comparator<Pair> {

	@Override
	public int compare(Pair o1, Pair o2) {
		if (o1.getUni() == o2.getUni()) {
			if (o1.getSkill() > o2.getSkill()) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return o1.getUni() - o2.getUni();
		}
	}

}

