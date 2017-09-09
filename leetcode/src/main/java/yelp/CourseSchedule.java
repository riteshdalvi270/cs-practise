package yelp;

import com.google.common.collect.Maps;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *
 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.
 * Created by ritesh on 9/6/17.
 */
public class CourseSchedule {

    public static void main(String args[]) {

        int numberOfCourses = 3;
        int[][] prerequisite = new int[][] {{0,1},{1,2},{2,0}};

        System.out.println(canFinish1(numberOfCourses,prerequisite));
    }

    //DFS (does not work)
    public static boolean canFinish1(int numCourses, int[][] prerequisites) {

        final Map<Integer, Set<Integer>> prereqByCourses = Maps.newHashMap();

        for(int i=0; i<prerequisites.length; i++) {

            int courseToTake = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            if(prereqByCourses.containsKey(courseToTake)) {
                prereqByCourses.get(courseToTake).add(prereq);
            }else {
                final Set<Integer> prereqSet = new HashSet<>();
                prereqSet.add(prereq);
                prereqByCourses.put(courseToTake,prereqSet);
            }
        }

        /*for(Map.Entry<Integer,Set<Integer>> entrySet : prereqByCourses.entrySet()) {

            System.out.println(entrySet.getKey() + " " + entrySet.getValue());
        }*/

        int[] visited = new int[numCourses];

        for(Map.Entry<Integer,Set<Integer>> entrySet : prereqByCourses.entrySet()) {

            if(canFinish(entrySet.getKey(),prereqByCourses,entrySet.getValue(),visited)) {

                return true;
            }
        }

        return false;
    }

    private static boolean canFinish(Integer courseToTake, final Map<Integer,Set<Integer>> prereqByCourses, Set<Integer> prereq, int[] visited) {

        if(visited[courseToTake] == -1) {
            return false;
        }

        if(prereq!=null) {

            for (final Integer pre : prereq) {

                if (canFinish(pre, prereqByCourses, prereqByCourses.get(pre), visited)) {
                    return true;
                }
            }

            visited[courseToTake] = -1;
        }else {
            visited[courseToTake] = -1;
        }

        return true;
    }

    // BFS
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if(numCourses == 0 || len == 0){
            return true;
        }

        // counter for number of prerequisites
        int[] pCounter = new int[numCourses];
        for(int i=0; i<len; i++){
            pCounter[prerequisites[i][0]]++;
        }

        //store courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(pCounter[i]==0){
                queue.add(i);
            }
        }

        // number of courses that have no prerequisites
        int numNoPre = queue.size();

        while(!queue.isEmpty()){
            int top = queue.remove();
            for(int i=0; i<len; i++){
                // if a course's prerequisite can be satisfied by a course in queue
                if(prerequisites[i][1]==top){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]]==0){
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return numNoPre == numCourses;
    }

}
